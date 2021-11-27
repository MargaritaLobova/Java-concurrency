package com.lobova.java_concurrency.lab12;

import java.util.LinkedList;

public class ListAccessModifier {
    private static final LinkedList<String> list = new LinkedList();
    private boolean needSorting = false;

    public boolean isNeedSorting() {
        return needSorting;
    }

    public synchronized void add(String t) {
        list.add(t);
    }

    public synchronized void print() {
        needSorting = true;
        for (String string : list) {
            System.out.println(string);
        }
    }

    public void sort() {
        int size = list.size();
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                for (int j = i; j < size; j++) {
                    String first = list.get(i);
                    String second = list.get(j);
                    if (second.compareTo(first) < 0) {
                        list.set(i, second);
                        list.set(j, first);
                    }
                }
            }
        }
    }
}
