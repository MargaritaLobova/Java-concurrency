package com.lobova.java_concurrency.lab2;

/**
 * Class to implement the thread's work.
 */
public class MyThread extends Thread {
    /**
     * Prints lines of text.
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread" + i);
        }
    }
}

