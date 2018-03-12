package com.javarush.task.a_test.myCall;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallable implements Callable<String> {
    private int taskNumber;

    public MyCallable(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + " :: task#" + taskNumber;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<String>> list = new ArrayList<>();

        for (int i = 1; i <= 100; i++){
            Thread.sleep(500);
            list.add(service.submit(new MyCallable(i)));
        }

        for (Future<String> f:list) {
            System.out.println(f.get());
        }

        service.shutdown();

    }




}
