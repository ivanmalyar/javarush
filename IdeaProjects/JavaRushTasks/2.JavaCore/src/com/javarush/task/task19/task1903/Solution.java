package com.javarush.task.task19.task1903;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        /*Customer customer = new IncomeDataAdapter(new MyClass());
        System.out.println(customer.getCountryName());
        System.out.println(customer.getCompanyName());

        Contact contact = new IncomeDataAdapter(new MyClass());
        System.out.println(contact.getName());
        System.out.println(contact.getPhoneNumber());*/

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            data = incomeData;
        }


        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            String code = data.getCountryCode();
            return countries.get(code);
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            //Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
            //Обратите внимание на формат вывода фамилии и имени человека.
            int number = data.getPhoneNumber();
            String numStr = String.valueOf(number);
            char[] chars = numStr.toCharArray();
            char[] chars10 = new char[10];

            for (int i = 0; i < 10 - chars.length; i++){
                chars10[i] = '0';
            }

            for (int i = (10 - chars.length); i < 10; i++){
                chars10[i] = chars[i - (10 - chars.length)];
            }

            String s = "("+chars10[0]+chars10[1]+chars10[2]+")"+
                    chars10[3]+chars10[4]+chars10[5]+"-"+chars10[6]+chars10[7]+"-"+chars10[8]+chars10[9];

            return "+" + data.getCountryPhoneCode() + s;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}