package com.lobova.java_concurrency.lab2;

/**
 * Modified class from Lab No1 so that parent thread output
 * * produced after completion of the newly created tread.
 */
public class Lab2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread th = new MyThread();
        th.start();
        th.join();
        for (int i = 0; i < 5; i++) {
            System.out.println("Main" + i);
        }
    }
}
