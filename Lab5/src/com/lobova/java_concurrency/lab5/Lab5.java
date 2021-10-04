package com.lobova.java_concurrency.lab5;
/**
 * Modification of previous lab - child thread prints a message before it finishes.
 */
public class Lab5 {
    public static void main(String[] args) throws InterruptedException {
        Runnable printLines = () -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(i);
                i++;
            }
            System.out.println("OOPS! I was interrupted by my mom( Bye-bye!");
        };

        Thread thread = new Thread(printLines);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
