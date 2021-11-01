package com.lobova.java_concurrency.lab11;

import static com.lobova.java_concurrency.lab11.Lab11.NUMBER_OF_STRINGS;

/**
 * Creates and starts thread with the attached controller.
 */
public class MyThread implements Runnable {
    Controller controller;

    MyThread(Controller с) {
        this.controller = с;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_STRINGS; i++) {
            controller.printMyThread();
        }
    }
}
