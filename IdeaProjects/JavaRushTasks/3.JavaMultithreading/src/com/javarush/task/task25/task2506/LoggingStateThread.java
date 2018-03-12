package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;
    private State state;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        while (true){
            State s = target.getState();
            if(state != s) System.out.println(s);
            state = s;
            if(s == State.TERMINATED) break;
        }
    }
}
