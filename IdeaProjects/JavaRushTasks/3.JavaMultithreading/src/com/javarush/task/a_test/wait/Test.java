package com.javarush.task.a_test.wait;

public class Test {
    public static MyClass myClass = new MyClass();

    public static void main(String[] args) throws InterruptedException {
        MyCustomThread thread1 = new MyCustomThread(myClass);
        MyCustomThread thread2 = new MyCustomThread(myClass);

        thread1.start();
        thread2.start();

        Thread.sleep(3000);

        System.out.println(thread1.getState());
        System.out.println(thread2.getState());

    }


    public static class MyCustomThread extends Thread{
        private final MyClass myClass;

        public MyCustomThread(MyClass myClass) {
            this.myClass = myClass;
        }

        @Override
        public void run() {
            try {
                myClass.method();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
