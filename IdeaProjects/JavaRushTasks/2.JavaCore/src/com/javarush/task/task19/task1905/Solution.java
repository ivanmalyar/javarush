package com.javarush.task.task19.task1905;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        //RowItem rowItem = new DataAdapter(new MyClass2(), new MyClass());
        //System.out.println(rowItem.getContactFirstName());
        //System.out.println(rowItem.getContactLastName());
        //System.out.println(rowItem.getDialString());
        //System.out.println(rowItem.getCountryCode());

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String code = "";
            String c = customer.getCountryName();
            for (Map.Entry<String,String> pair :countries.entrySet()) {
                if (pair.getValue().equals(c)){
                    code = pair.getKey();
                }
            }
            return code;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String name = contact.getName();
            String[]strings = name.split(", ");
            return strings[1];
        }

        @Override
        public String getContactLastName() {
            String name = contact.getName();
            String[]strings = name.split(", ");
            return strings[0];
        }

        @Override
        public String getDialString() {
            return "callto://" + contact.getPhoneNumber().replaceAll("[()-]", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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
//Метод getDialString() должен вернуть строку состоящую из надписи callto://+
// и телефонного номера из которого убраны все символы кроме цифр(смотри примеры).
// Номер телефона нужно взять из getPhoneNumber() объекта сontact.