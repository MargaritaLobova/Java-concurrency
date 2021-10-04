package com.lobova.java_concurrency.lab4;
/**
 * Child thread prints text. After 2000 millis main thread interrupts child.
 */
public class Lab4 {
    public static void main(String[] args) throws InterruptedException {
        Runnable printLines = () -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(i);
                i++;
            }
        };

        Thread thread = new Thread(printLines);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
