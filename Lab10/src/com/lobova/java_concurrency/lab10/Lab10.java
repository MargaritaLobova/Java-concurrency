package com.lobova.java_concurrency.lab10;


/**
 * Creates a thread.
 * Parent thread and newly created thread print ten lines of text.
 * Using mutexes.
 */
public class Lab10 {
    /**
     * @param args no params are used here.
     */
    public static void main(String[] args) throws InterruptedException {
        Controller c = new Controller();
        new MyThread(c);
        c.printMainThread();
    }
}
