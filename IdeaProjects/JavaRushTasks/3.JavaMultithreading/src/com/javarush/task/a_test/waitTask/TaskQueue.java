package com.javarush.task.a_test.waitTask;
import java.util.ArrayList;
import java.util.List;

public class TaskQueue {

    private List<Runnable> taskList = new ArrayList<>();

    public synchronized void putTask(Runnable task){
        taskList.add(task);
        this.notifyAll();
    }

    public synchronized Runnable getTask(){
        while (taskList.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return taskList.remove(0);
    }
}
