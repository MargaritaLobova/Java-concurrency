package com.lobova.java_concurrency.lab9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class State {
    private int philosophersCount;
    private Philosopher[] philosophers;

    private enum PhilosopherState {
        HUNGRY,
        EATING,
        THINKING
    }

    private PhilosopherState[] state;
    private Lock lock;
    private Condition[] cond;

    public State(Philosopher[] philosophers) {
        this.philosophers = philosophers;
        this.philosophersCount = philosophers.length;
        lock = new ReentrantLock();
        state = new PhilosopherState[philosophersCount];
        cond = new Condition[philosophersCount];
        for (int i = 0; i < philosophersCount; i++) {
            state[i] = PhilosopherState.THINKING;
            cond[i] = lock.newCondition();
        }
    }

    public void takeForks(int id, Fork l, Fork r) {
        lock.lock();
        try {
            while (!philosophers[id].stopped.get() &&
                    (!l.getAvailability() || !r.getAvailability())) {
                cond[id].await();
            }
            l.take();
            r.take();
            // setState(id, PhilosopherState.EATING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void putForks(int id, Fork l, Fork r) {
        lock.lock();
        try {
            //setState(id, PhilosopherState.THINKING);
            l.put();
            r.put();
            cond[(id + 1) % philosophersCount].signalAll();
            cond[(id + philosophersCount - 1) % philosophersCount].signalAll();
        } finally {
            lock.unlock();
        }
    }
}