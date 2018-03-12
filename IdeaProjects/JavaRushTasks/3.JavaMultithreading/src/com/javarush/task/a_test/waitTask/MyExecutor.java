package com.javarush.task.a_test.waitTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor extends Thread {
    private TaskQueue taskQueue;

    public MyExecutor(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        ExecutorService service = Executors.newFixedThreadPool(4);

        while (true){
            service.submit(taskQueue.getTask());
        }
    }

}
