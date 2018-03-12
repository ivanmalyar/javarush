package com.javarush.task.task17.task1718.my;

public class Women {
    static private String name = "Shalava";
    static private Women women = null;

    private Women(String name) {
        this.name = name;
    }

    public static Women getInstanceWomen(){
        if(women == null){
            women = new Women("Shalava");
        }
        return women;
    }

    public void fuck(Man man) {
        synchronized (Women.class) {
            try {
                System.out.println(man.getName() + " start fuck " + name);
                Thread.sleep(3000);
                System.out.println(man.getName() + " stop fuck " + name);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }







}
