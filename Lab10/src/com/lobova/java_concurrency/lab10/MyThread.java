package com.lobova.java_concurrency.lab10;

/**
 *  Creates new thread and runs it.
 */
public class MyThread implements Runnable {
    Controller printer;

    public MyThread(Controller printer) {
        this.printer = printer;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            printer.printMyThread();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
