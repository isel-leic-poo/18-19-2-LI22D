package edu.isel.leic.poo;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    private static void iterableDemo() {
        Collection<Integer> container = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int value = 0;
        while ((value = in.nextInt()) != 0) {
            container.add(value);
        }

        for (Integer elem : container) {
            System.out.print(elem);
            System.out.print(' ');
        }
    }

    private static void listDemo() {
        List<Integer> list = new ArrayList<>();
        // List<Integer> list = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        int value = 0;
        while ((value = in.nextInt()) != 0) {
            list.add(value);
        }

        for(int idx = list.size() - 1; idx >= 0; --idx) {
            System.out.print(list.get(idx));
            System.out.print(' ');
        }
    }

    private static void setDemo() {
        Set<String> set = new TreeSet<>();

        Scanner in = new Scanner(System.in);
        String value = "";
        while (!(value = in.next()).equals("END")) {
            set.add(value);
        }

        for (String elem : set) {
            System.out.print(elem);
            System.out.print(' ');
        }
    }

    public static void main(String[] args) {
        // iterableDemo();
        // listDemo();
        setDemo();
    }
}
