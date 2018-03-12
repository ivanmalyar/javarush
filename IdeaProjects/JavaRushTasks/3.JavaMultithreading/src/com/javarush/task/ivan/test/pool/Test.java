package com.javarush.task.ivan.test.pool;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        exec2();

    }

    public static void exec() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future f = null;
        for (int i = 0; i < 10; i++){
            f = service.submit(new MyTask());
            System.out.println(f.get());
        }
        service.shutdown();
        //System.out.println(f.get());
    }

    public static void exec2(){
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++){
            service.submit(() -> {
                //System.out.println("lambda");
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }



        service.shutdown();
    }
}
