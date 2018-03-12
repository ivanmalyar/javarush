package com.javarush.task.task30.task3008;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите номер порта");
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        ConsoleHelper.writeMessage("Сервер запущен.");
        try {
            while (true){
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
           serverSocket.close();
           ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    public static void sendBroadcastMessage(Message message)  {
        for (Map.Entry<String, Connection> pair:connectionMap.entrySet()) {
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            Connection connection;
            String userName = "";
            try {
                connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            }finally {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
            }

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String userName = null;
            Message nameResponse = null;
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));       // Сформировать и отправить команду запроса имени пользователя
                nameResponse = connection.receive();                        // Получить ответ клиента

                if (nameResponse.getType() != MessageType.USER_NAME) continue;        // Проверить, что получена команда с именем пользователя
                userName = nameResponse.getData();

                if (userName.isEmpty()) continue;                        // Достать из ответа имя, проверить, что оно не пустое и пользователь с таким именем еще не подключен(используй connectionMap)
                if (userName == null) continue;                        // Достать из ответа имя, проверить, что оно не пустое и пользователь с таким именем еще не подключен(используй connectionMap)

                if (connectionMap.containsKey(userName)) continue;
                connectionMap.put(userName, connection);                                //Добавить нового пользователя и соединение с ним в connectionMap
                connection.send(new Message(MessageType.NAME_ACCEPTED));    //Отправить клиенту команду информирующую, что его имя принято
                ConsoleHelper.writeMessage("Имя " + userName + " принято");
                break;
            }
            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pair:connectionMap.entrySet()) {
                if (!pair.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message message;
            while (true){
                message = connection.receive();
                if (message.getType() == MessageType.TEXT){
                    String string = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                }else {
                    ConsoleHelper.writeMessage("Ошибка! Сообщение не является текстом.");
                }
            }
        }
    }
}

