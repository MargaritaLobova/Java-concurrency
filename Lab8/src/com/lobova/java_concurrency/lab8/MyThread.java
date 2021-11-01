package com.lobova.java_concurrency.lab8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.sleep;

/**
 * Creates one thread for calculations.
 * Uses one counter and barrier to synchronize.
 */
public class MyThread implements Runnable {

    Counter counter;
    CyclicBarrier cyclicBarrier;
    /**
     * @param counter       to run the calculations by this thread.
     * @param cyclicBarrier to synchronize correctly.
     */
    public MyThread(Counter counter, CyclicBarrier cyclicBarrier) {
        this.counter = counter;
        this.cyclicBarrier = cyclicBarrier;
    }

    /**
     * Runs the calculations using cyclic barrier for concurrency.
     */
    @Override
    public void run() {
        counter.count();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}