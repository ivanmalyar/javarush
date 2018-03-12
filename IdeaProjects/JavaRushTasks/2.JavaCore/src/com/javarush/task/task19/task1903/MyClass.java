package com.javarush.task.task19.task1903;

public class MyClass implements Solution.IncomeData {
    @Override
    public String getCountryCode() {
        return "UA";
    }

    @Override
    public String getCompany() {
        return "JavaRush Ltd";
    }

    @Override
    public String getContactFirstName() {
        return "Ivan";
    }

    @Override
    public String getContactLastName() {
        return "Ivanov";
    }

    @Override
    public int getCountryPhoneCode() {
        return 38;
    }

    @Override
    public int getPhoneNumber() {
        return 501234567;
    }
}
