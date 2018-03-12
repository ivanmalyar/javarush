package com.javarush.task.task19.task1901.my;

public class MyAdapter {
    public static void main(String[] args) {

        AFlyable aFlyable = new AFlyable() {
            @Override
            public void fly() {
                System.out.println("I am flying");
            }
        };

        aFlyable.fly();
        BFlyable bFlyable = new FlyAdapter(aFlyable);
        bFlyable.fly();






    }

    public static class FlyAdapter implements BFlyable{
        private AFlyable aFlyable;

        public FlyAdapter(AFlyable aFlyable) {
            this.aFlyable = aFlyable;
        }

        @Override
        public void fly() {
            aFlyable.fly();
            System.out.println("very fast");
        }
    }


    public interface AFlyable{
        void fly();
    }
    public interface BFlyable{
        void fly();
    }




}
