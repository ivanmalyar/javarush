package com.javarush.task.a_test.waitTask;

public class MyProducer extends Thread {

    private TaskQueue taskQueue;

    public MyProducer(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <=10; i++){
            taskQueue.putTask(new MyTask("task#" + i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
