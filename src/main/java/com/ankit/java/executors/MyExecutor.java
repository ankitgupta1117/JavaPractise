package com.ankit.java.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MyExecutor {

    public static void main(String[] args) {
        List<Runnable> rejectedTasks = new ArrayList<>();

        ThreadPoolExecutor myPool = new ThreadPoolExecutor(2,10,10
                , TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        IntStream.range(0,100).forEach((i) -> {
            myPool.execute(new Task(i));
            System.out.println("Task "+i +" scheduled");

        });
        System.out.println("Pool shutting down");
        try {
            myPool.shutdown();
            myPool.awaitTermination(120, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("I am interrupted!!!!");
        }
        System.out.println("Pool has shut down");
        System.out.println("Total rejected Tasks: "+rejectedTasks.size());
    }

}


class Task implements Runnable{
    public int getTaskId() {
        return taskId;
    }

    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Task "+taskId+" Executing");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" Task "+taskId+"Completed");

    }
}
