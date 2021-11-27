package com.lobova.java_concurrency.lab9;

public class Fork {
    private int id;
    private boolean isAvailable;

    public Fork(int id) {
        this.id = id;
        isAvailable=true;
    }

    public int getId() {
        return id;
    }

    public void take() {
        long t = System.nanoTime();
        System.out.println(t + ": Fork " + id + " is taken");
        isAvailable = false;
    }

    public void put() {
        long t = System.nanoTime();
        System.out.println(t + ": Fork " + id + " is put");
        isAvailable = true;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public void setAvailability(boolean b) {
        isAvailable = b;
    }
}
