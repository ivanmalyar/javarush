package com.javarush.task.task17.task1714;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }
    //Реализовать метод compareTo так, чтобы он при сравнении двух пляжей выдавал число,
    // которое показывает что первый пляж лучше(позитивное число)
    //или второй пляж лучше (негативное число),и насколько он лучше.

    @Override
    public synchronized int compareTo(Beach o) {
        int q = this.quality - o.quality;
        float d = o.distance - this.distance;

        return q + (int)d;
    }
}
