package com.lobova.java_concurrency.lab1;

/**
 * Creates a thread.
 * Parent thread and newly created thread print ten lines of text.
 */
public class Lab1 {
    public static final int NUMBER_OF_STRINGS = 5;

    /**
     * @param args no params are used here.
     */
    public static void main(final String[] args) {
        MyThread th = new MyThread();
        th.start();
        for (int i = 0; i < NUMBER_OF_STRINGS; i++) {
            System.out.println("Main" + i);
        }
    }
}
