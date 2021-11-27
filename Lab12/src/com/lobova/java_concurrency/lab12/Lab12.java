package com.lobova.java_concurrency.lab12;

/*Родительская нить программы должна считывать вводимые пользователем строки
и помещать их в начало связанного списка. При вводе пустой строки программа должна выдавать текущее
состояние списка. Дочерняя нить пробуждается каждые пять секунд и сортирует список
в лексикографическом порядке (используйте пузырьковую сортировку).*/

import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab12 {
    public static ListAccessModifier list = new ListAccessModifier();


    public static void main(String[] args) {
        Thread sorter = new Thread(new Sorter(list));
        sorter.start();
        Scanner in = new Scanner(System.in);
        String t = in.nextLine();
        while (t.compareTo("") != 0) {
            if (t.length() >= 80) {
                Iterable<String> split = Splitter.fixedLength(80).split(t);
                List<String> splitToList = new ArrayList<>();
                split.forEach(splitToList::add);
                for (String s : splitToList) {
                    list.add(s);
                }
            }
            list.add(t);
            t = in.nextLine();
        }
        list.print();
    }
}
