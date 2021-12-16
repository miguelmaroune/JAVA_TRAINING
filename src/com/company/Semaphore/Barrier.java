package com.company.Semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Barrier {
    private final int numberOfWorkers;
    private Semaphore semaphore = new Semaphore( 0);
    private int counter = 0;
    private Lock lock = new ReentrantLock();

    public Barrier(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public void barrier() {
        lock.lock();
        boolean isLastWorker = false;
        try {
            counter++;

            if (counter == numberOfWorkers) {
                isLastWorker = true;
            }
        } finally {
            lock.unlock();
        }

        if (isLastWorker) {
            semaphore.release(numberOfWorkers -1 );
        } else {
            try {//This will cause the first Thread to freeze until the last worker
                semaphore.acquire();
                
            } catch (InterruptedException e) {
            }
        }
    }
}

//    int numberOfThreads = 200; //or any number you'd like
//
//    List<Thread> threads = new ArrayList<>();
//
//    Barrier barrier = new Barrier(numberOfThreads);
//    for (int i = 0; i < numberOfThreads; i++) {
//        threads.add(new Thread(new CoordinatedWorkRunner(barrier)));
//        }
//
//        for(Thread thread: threads) {
//        thread.start();
//        }
