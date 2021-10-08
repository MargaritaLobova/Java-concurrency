package com.lobova.java_concurrency.lab7;

/**
 * Perform one-thread iterations.
 */
public class Counter {

    private static final int ACCURACY = 10000;
    int currentPlace;
    int shift;
    double partialSum = 0.0d;

    /**
     * @param currentPlace in the Leibniz formula.
     * @param shift
     */
    public Counter(int currentPlace, int shift) {
        this.currentPlace = currentPlace;
        this.shift = shift;
    }

    /**
     * @return current sum that already was calculated.
     */
    public double getPartialSum() {
        return partialSum;
    }

    /**
     * Counts according to Leibniz formula with accuracy ACCURACY.
     */
    public void count() {
        while (currentPlace <= ACCURACY) {
            partialSum += 4.0d * Math.pow(-1.0d, currentPlace) / (2.0d * currentPlace + 1.0d);
            currentPlace += shift;
        }
    }
}
