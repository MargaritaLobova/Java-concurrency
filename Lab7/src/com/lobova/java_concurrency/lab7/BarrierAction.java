package com.lobova.java_concurrency.lab7;

import java.util.List;

/**
 * After all calculations finish prints the result of calculations.
 */
public class BarrierAction implements Runnable {

    List<Counter> counters;

    public BarrierAction(List<Counter> counters) {
        this.counters = counters;
    }

    /**
     * Returns and prints the final result of calculations.
     */
    @Override
    public void run() {
        double sum = counters.stream().map(Counter::getPartialSum).reduce(Double::sum).orElse(0.0);
        System.out.println("RESULT: " + sum);
    }
}