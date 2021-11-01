package com.lobova.java_concurrency.lab11;

/**
 * Creates a couple of threads.
 * Parent thread and newly created thread print ten lines of text. Alternately.
 */
public class Lab11 {
    final public static int NUMBER_OF_STRINGS = 5;

    /**
     * @param args no params are used here.
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        new MyThread(controller);
        for (int i = 0; i < NUMBER_OF_STRINGS; i++) {
            controller.printMainThread(i);
        }
    }
}