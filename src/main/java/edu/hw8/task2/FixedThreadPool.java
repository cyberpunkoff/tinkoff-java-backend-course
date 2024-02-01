package edu.hw8.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final BlockingQueue<Runnable> tasks;
    private final Thread[] threads;

    public FixedThreadPool(int amount) {
        threads = new Thread[amount];
        Thread thread = new Thread();
        this.tasks = new LinkedBlockingQueue<>();
    }

    @Override
    public void start() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Worker();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            tasks.put(runnable);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        for (Thread thread : threads) {
            thread.interrupt();

        }
    }

    class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = tasks.take();
                    task.run();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
