package com.lobova.java_concurrency.lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * Calculates PI using the Leibniz formula.
 *
 */
public class Lab8 {

    /**
     * @param args to enter the number of threads.
     */
    public static void main(String[] args) throws InterruptedException {
        final int numberOfThreads = Integer.parseInt(args[0]);
        List<Counter> counters;
        counters = new ArrayList<>(numberOfThreads);
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("Shutdown hook ran!");
                new BarrierAction(counters).run();
            }
        });
        for (int i = 0; i < numberOfThreads; i++) {
            counters.add(i, new Counter(i, numberOfThreads));
        }
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfThreads, new BarrierAction(counters));
        for (Counter counter : counters) {
            new Thread(new MyThread(counter, cyclicBarrier)).start();
        }

    }
}