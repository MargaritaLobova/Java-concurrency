package com.lobova.java_concurrency.lab11;

import java.util.concurrent.Semaphore;

/**
 * A class that performs alternating printing of thread's strings.
 * It's done with a help of a couple of semaphores.
 */
public class Controller {
    static Semaphore mySemaphore = new Semaphore(0);
    static Semaphore mainSemaphore = new Semaphore(1);
    int count;

    /**
     * A class to control and print the lines of the MyThread.
     */
    void printMyThread() {
        try {
            mySemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread: " + count);
        mainSemaphore.release();
    }

    /**
     * A class to control and print the lines of the MainThread.
     * @param count current line to be printed
     */
    void printMainThread(int count) {
        try {
            mainSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.count = count;
        System.out.println("MainThread: " + count);
        mySemaphore.release();
    }
}