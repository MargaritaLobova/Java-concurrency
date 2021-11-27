package com.lobova.java_concurrency.lab12;

public class Sorter implements Runnable {
    private ListAccessModifier list;

    Sorter(ListAccessModifier list) {
        setList(list);
    }

    @Override
    public void run() {
        while (!list.isNeedSorting()) {
            list.sort();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }

    public void setList(ListAccessModifier list) {
        this.list = list;
    }
}
