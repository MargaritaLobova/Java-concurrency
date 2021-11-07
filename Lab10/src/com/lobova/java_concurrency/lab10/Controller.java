package com.lobova.java_concurrency.lab10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Controls locks to simulate the work of mutexes.
 */
public class Controller {

    final int capacity = 1;
    Queue<Integer> queue = new LinkedList<>();
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * Controls printing process on main thread.
     * @throws InterruptedException
     */
    public void printMainThread() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            lock.lock();
            while (queue.size() == capacity) {
                condition.await();
            }
            queue.add(i);
            System.out.println("MainThread: line " + i);
            condition.signal();
            lock.unlock();
        }
    }

    /**
     * Controls printing process on subsidiary thread.
     * @throws InterruptedException
     */
    public void printMyThread() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            lock.lock();
            while (queue.size() < 1) {
                condition.await();
            }
            System.out.println("MyThread: line " + queue.remove());
            condition.signal();
            lock.unlock();
        }
    }

}