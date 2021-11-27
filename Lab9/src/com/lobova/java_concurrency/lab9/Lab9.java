package com.lobova.java_concurrency.lab9;

public class Lab9 {
    static final int PHILOSOPHERS_COUNT = 5;
    public static int DINNER_DURATION_IN_MS = 1000;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[PHILOSOPHERS_COUNT];
        System.out.println(System.nanoTime() + ": Dinner is started");
        Fork[] forks = new Fork[PHILOSOPHERS_COUNT];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i);
        }

        Philosopher[] philosophers = new Philosopher[PHILOSOPHERS_COUNT];
        State state = new State(philosophers);
        String[] names = {"Plato", "Aristotle", "Socrates", "Empedocles", "Heraclitus"};

        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % forks.length];
            philosophers[i] = new Philosopher(i, leftFork, rightFork, state, names[i]);
            threads[i] = new Thread(philosophers[i], "Philosopher " + (i + 1));
            threads[i].start();
        }

        Thread.sleep(DINNER_DURATION_IN_MS);
        for (Philosopher philosopher : philosophers) {
            if (!philosopher.stopped.get()) {
                philosopher.stopped.set(true);
            }
        }

        Thread.sleep(200);
        for (Thread thread : threads) {
            if (!thread.isInterrupted()) {
                thread.interrupt();
            }
        }

        Thread.sleep(100);
        System.out.println(System.nanoTime() + ": Dinner is finished");
    }
}
