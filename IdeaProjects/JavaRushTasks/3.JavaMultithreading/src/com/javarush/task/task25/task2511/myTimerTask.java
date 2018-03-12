package com.javarush.task.task25.task2511;
import java.util.TimerTask;

public class myTimerTask extends TimerTask {
    @Override
    public void run() {
        //System.out.println("run myTimerTask");
        throw new RuntimeException();
    }
}
