package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("tmp", ".temp", new File("d://"));

            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();     //создаем юзера
            user1.setFirstName("Ivan");
            user1.setLastName("Malyar");
            user1.setBirthDate(new Date());
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            User user2 = new User();     //создаем юзера
            user2.setFirstName("Petr");
            user2.setLastName("Petrov");
            user2.setBirthDate(new Date());
            user2.setMale(true);
            user2.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user1);       //добавляем юзера в список(поле объекта javarash)
            javaRush.users.add(user2);

            javaRush.save(outputStream);    //сохраняем в файл
            outputStream.flush();

//-------------------
            /*JavaRush javaRush1 = new JavaRush();
            User user3 = new User();     //создаем юзера
            user3.setFirstName("Bob");
            user3.setLastName("Smith");
            user3.setBirthDate(new Date());
            user3.setMale(true);
            user3.setCountry(User.Country.RUSSIA);
            javaRush1.users.add(user3);       //добавляем юзера в список(поле объекта javarash)
            javaRush1.save(outputStream);    //сохраняем в файл
            outputStream.flush();*/
//-------------
            outputStream.close();



            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            for (User user:users) {
                outputStream.write((user.getFirstName() + "\r\n").getBytes());
                outputStream.write((user.getLastName() + "\r\n").getBytes());
                outputStream.write((user.getBirthDate().getTime() + "\r\n").getBytes());
                outputStream.write((user.isMale() + "\r\n").getBytes());
                outputStream.write((user.getCountry() + "\r\n").getBytes());
            }
            outputStream.write("\r\n".getBytes());
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()){

                String s = reader.readLine();
                if(s.equals("")) break;
                String firstName = s;

                String lastName = reader.readLine();
                String birthDate = reader.readLine();
                String male = reader.readLine();
                String country = reader.readLine();

                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setBirthDate(new Date(Long.parseLong(birthDate)));
                user.setMale(Boolean.parseBoolean(male));
                user.setCountry(User.Country.valueOf(country));

                users.add(user);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
