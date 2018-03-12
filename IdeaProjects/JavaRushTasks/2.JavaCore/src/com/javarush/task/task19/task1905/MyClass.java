package com.javarush.task.task19.task1905;

public class MyClass implements Solution.Contact {
    @Override
    public String getName() {
        return "Ivanov, Ivan";
    }

    @Override
    public String getPhoneNumber() {
        return "+38(050)123-45-67";
    }
}
