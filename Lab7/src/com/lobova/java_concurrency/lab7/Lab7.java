package com.lobova.java_concurrency.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * Calculates PI using the Leibniz formula.
 */
public class Lab7 {

    /**
     * @param args to enter the number of threads.
     */
    public static void main(String[] args) {
        final int numberOfThreads = Integer.parseInt(args[0]);
        List<Counter> counters;
        counters = new ArrayList<>(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            counters.add(i, new Counter(i, numberOfThreads));
        }
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfThreads, new BarrierAction(counters));
        for (Counter counter : counters) {
            new Thread(new MyThread(counter, cyclicBarrier)).start();
        }
    }
}