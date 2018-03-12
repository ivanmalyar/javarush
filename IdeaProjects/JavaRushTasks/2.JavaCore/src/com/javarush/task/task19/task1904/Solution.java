package com.javarush.task.task19.task1904;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Solution {
    private static String file = "d://a.txt";

    public static void main(String[] args) throws IOException, ParseException {
        //PersonScanner personScanner = new PersonScannerAdapter(new Scanner(new FileReader(file)));
        //Person person = personScanner.read();
        //System.out.println(person);

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner ;

        public PersonScannerAdapter(Scanner scanner) {
            fileScanner  = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String string = fileScanner.nextLine();
            String[] strings = string.split(" ");
            String firstName = strings[1];
            String middleName = strings[2];
            String lastName = strings[0];

            int length = string.length();
            String dateStr = string.substring(length-10, length);

            SimpleDateFormat formatDate = new SimpleDateFormat("dd MM yyyy");
            Date parsingDate = formatDate.parse(dateStr);

            return new Person(firstName, middleName, lastName, parsingDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
