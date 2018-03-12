package com.javarush.task.task23.task2301.my.Test.Test2;
import com.javarush.task.task23.task2301.my.Test.Test2.Outer.Inner;

public class Test {
    public static int ii = 15;
    public static void main(String[] args) {
        //Outer outer = new Outer();
        //outer.start();

        Outer o = new Outer(){
            @Override
            public void run() {
                //super.run();
                System.out.println(ii);
            }
        };

        o.start();

    }
}
