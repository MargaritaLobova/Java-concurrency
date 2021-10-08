package com.lobova.java_concurrency.lab6;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Creates a worker, that is attached to the department.
 */
public class Worker implements Runnable {

    CyclicBarrier cyclicBarrier;
    Department department;

    /**
     * @param cyclicBarrier makes a set of threads to all wait for each other
     *                      to reach a common barrier point - the end of calculations.
     * @param department    to which the worker is attached.
     */
    public Worker(CyclicBarrier cyclicBarrier, Department department) {
        this.cyclicBarrier = cyclicBarrier;
        this.department = department;
    }

    /**
     * Department, to which the worker is attached, starts it's work. Barrier waits, till all
     * the departments will finish the calculations.
     */
    @Override
    public void run() {
        department.performCalculations();
        System.out.println("Department " + department.getIdentifier() + " finished. (" + department.workingSeconds + " sec).");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}