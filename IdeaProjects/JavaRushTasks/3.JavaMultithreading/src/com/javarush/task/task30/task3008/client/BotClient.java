package com.javarush.task.task30.task3008.client;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random()*100);
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] strings = message.split(": ");
            if (strings.length < 2) return;
            String pattern = "";

            if (strings[1].equals("дата")) pattern = "d.MM.YYYY";
            else if (strings[1].equals("день")) pattern = "d";
            else if (strings[1].equals("месяц")) pattern = "MMMM";
            else if (strings[1].equals("год")) pattern = "YYYY";
            else if (strings[1].equals("время")) pattern = "H:mm:ss";
            else if (strings[1].equals("час")) pattern = "H";
            else if (strings[1].equals("минуты")) pattern = "m";
            else if (strings[1].equals("секунды")) pattern = "s";
            else return;

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String text = simpleDateFormat.format(new GregorianCalendar().getTime());

            String string = "Информация для " + strings[0] + ": " + text;
            sendTextMessage(string);

        }
    }

}
