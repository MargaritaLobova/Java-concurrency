package com.lobova.java_concurrency.lab1;

import static com.lobova.java_concurrency.lab1.Lab1.NUMBER_OF_STRINGS;

/**
 * Class to implement the thread's work.
 */
public class MyThread extends Thread {
    /**
     * Prints lines of text.
     */
    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_STRINGS; i++) {
            System.out.println("Thread" + i);
        }
    }
}

