package com.lobova.java_concurrency.lab9;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Philosopher implements Runnable {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private String name;


    private final State state;
    public final AtomicBoolean stopped = new AtomicBoolean();

    public AtomicInteger eatCount = new AtomicInteger();

    protected Philosopher(int id, Fork leftFork, Fork rightFork, State state, String name) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.state = state;
        this.name = name;
    }

    public void think() throws InterruptedException {
        System.out.println(System.nanoTime() + ": Philosopher "+ name + " is thinking...");
        Thread.sleep((long) Math.random());
    }

    public void eat() throws InterruptedException {
        System.out.println(System.nanoTime() + ": Philosopher "+ name + " is eating...");
        Thread.sleep((long) Math.random());
    }

    @Override
    public void run() {
        while (!stopped.get()) {
            try {
                think();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state.takeForks(id, leftFork, rightFork);
            try {
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state.putForks(id, leftFork, rightFork);
        }
    }
}