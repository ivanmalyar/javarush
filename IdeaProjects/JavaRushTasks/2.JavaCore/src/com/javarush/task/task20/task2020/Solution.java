package com.javarush.task.task20.task2020;
import java.io.*;
import java.util.logging.Logger;

public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        String fullName;
        final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person = new Person("Bob", "Kerry", "USA", Sex.MALE);

        FileOutputStream fileOutputStream = new FileOutputStream("d://a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

        oos.writeObject(person);
        fileOutputStream.close();
        oos.close();

        FileInputStream fileInputStream = new FileInputStream("d://a.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);

        Person loadedPerson = (Person) ois.readObject();
        fileInputStream.close();
        ois.close();

        System.out.println(loadedPerson.firstName);
        System.out.println(loadedPerson.lastName);
        System.out.println(loadedPerson.fullName);
        System.out.println(loadedPerson.country);
        System.out.println(loadedPerson.sex);
        System.out.println(loadedPerson.greetingString);
        System.out.println(loadedPerson.logger);








    }
}
