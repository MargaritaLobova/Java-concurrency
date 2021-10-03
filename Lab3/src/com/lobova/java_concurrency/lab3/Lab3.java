package com.lobova.java_concurrency.lab3;
/**
 * Main class of the third lab.
 */
public class Lab3 {
    static String line1 = "a b c d";

    /**
     * @param words to be printed by threads
     * @param id    of the thread
     * @throws InterruptedException
     */
    public static void createThread(String[] words, int id) throws InterruptedException {
        String[] text = words.clone();
        PrintLines thread1 = new PrintLines(text);
        Thread th1 = new Thread(thread1);
        th1.start();
        th1.join();
    }

    /**
     * @param args no params are used here
     * @throws InterruptedException
     */
    public static void main(final String[] args) throws InterruptedException {
        String[] words = line1.split("\\s");
        createThread(words, 0);
        words[0] = "A";
        createThread(words, 1);
        words[1] = "B";
        createThread(words, 2);
        words[2] = "C";
        createThread(words, 3);
        words[3] = "D";
    }
}
