package com.ankit.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class CustomBlockingQueue<T> {

    CustomBlockingQueue(int size){
        this.size = size;
    }
    private int size;
    private List<T> queue = new ArrayList<>();
    private Lock lock = new ReentrantLock();
    private Condition putCondition = lock.newCondition();
    private Condition takeCondition = lock.newCondition();

    public void put(T item){
        if(item == null){
            throw new NullPointerException();
        }
        lock.lock();
        try{
            while(queue.size() == size){
                System.out.println(Thread.currentThread().getName()+ " - Queue Full.. Waiting");
                putCondition.await();
            }
            queue.add(item);
            System.out.println(Thread.currentThread().getName()+ " - Produced "+item);
            takeCondition.signalAll();
        }catch (InterruptedException e){
            System.err.println("Producer Thread: "+Thread.currentThread().getName()+" Interrupted.. Stopping this thread.");
            return;
        }finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        T result;
        try{
            while(queue.size() == 0){
                System.out.println(Thread.currentThread().getName()+ " - Queue Empty.. Waiting");
                takeCondition.await();
            }
            result = queue.remove(queue.size()-1);
            System.out.println(Thread.currentThread().getName()+ " - Took "+ result);
            putCondition.signalAll();
            return  result;
        }catch (InterruptedException e){
            System.err.println("Consumer Thread: "+Thread.currentThread().getName()+" Interrupted. . Stopping this thread");
            return null;
        }finally {
            lock.unlock();
        }

    }

}


class MainClass{
    private static class Producer implements Runnable{
        private CustomBlockingQueue<Integer> queue;
        int start, end;
        public Producer(CustomBlockingQueue queue, int start, int end) {
            this.queue = queue;
            this.start = start;
            this.end  = end;
        }

        @Override
        public void run() {
            java.util.function.Consumer<Integer> c = i ->{
              queue.put(i);
              try{
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
            };
            IntStream.rangeClosed(start, end).boxed().forEach(c);
            System.out.println(Thread.currentThread().getName() + " - Completed..");
        }
    }

    private static class Consumer implements Runnable{
        private CustomBlockingQueue<Integer> queue;

        public Consumer(CustomBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            java.util.function.Consumer<Integer> c = i ->{
                queue.take();
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            IntStream.range(0,10).boxed().forEach( c);
            System.out.println(Thread.currentThread().getName() + " - Completed..");
        }
    }
    public static void main(String[] args) {
        CustomBlockingQueue<Integer> queue = new CustomBlockingQueue<>(10);
        List<Producer> producers = new ArrayList<>();
        for(int i=1; i<=100; i+=10){
            producers.add(new Producer(queue, i, i+9));
        }
        System.out.println("Total Producers: "+producers.size());

        List<Consumer> consumers = new ArrayList<>();
        for(int i=1; i<=100; i+=10){
            consumers.add(new Consumer(queue));
        }
        System.out.println("Total Consumers: "+consumers.size());

        Executor threadPool = Executors.newFixedThreadPool(20);
        consumers.stream().forEach(threadPool::execute);
        producers.stream().forEach(threadPool::execute);
    }
}