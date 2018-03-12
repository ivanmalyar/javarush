package com.javarush.task.task27.task2705;

public class Knight {
    private int id;
    private int life;
    private int expirience;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getExpirience() {
        return expirience;
    }

    public void setExpirience(int expirience) {
        this.expirience = expirience;
    }

    public void kill(Knight knight1, Knight knight2){

        Knight knightMax = knight1.getId() > knight2.getId() ? knight1 : knight2;
        Knight knightMin = knight1.getId() > knight2.getId() ? knight2 : knight1;

        synchronized (knightMax) {
            synchronized (knightMin) {
                knight2.setLife(0);
                knight1.setExpirience(knight1.getExpirience() + 100);
            }
        }
    }
}
