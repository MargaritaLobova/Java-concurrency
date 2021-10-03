package com.lobova.java_concurrency.lab3;
/**
 * Prints lines of text.
 */
public class PrintLines implements Runnable {
    String[] words;

    public PrintLines(String[] words) {
        this.words = words;
    }

    /**
     * Method to demonstrate the thread's work
     */
    @Override
    public void run() {
        for (String word : words) {
            System.out.print(word);
        }
        System.out.println("");
    }
}
