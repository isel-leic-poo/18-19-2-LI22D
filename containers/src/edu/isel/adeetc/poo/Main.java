package edu.isel.adeetc.poo;


import java.util.Scanner;

public class Main {

    private static void displayOdds(Sequence collection) {

        for (int idx = 0; idx < collection.size(); idx++) {
            final int value = collection.get(idx);
            if (value % 2 != 0)
                System.out.print(value + " ");
        }
    }

    private static void displayOddsLikeABoss(Iterable collection) {

        Iterator itr = collection.iterator();
        while (itr.hasNext()) {
            final int value = itr.next();
            if (value % 2 != 0)
                System.out.print(value + " ");
        }
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Sequence sequence = new DynamicArray();

        int value;
        while ((value = in.nextInt()) != 0) {
            sequence.add(value);
        }

        displayOdds(sequence);
        System.out.println();
        displayOddsLikeABoss(sequence);


        Sequence iterable1 = new DynamicArray();
        iterable1.add(4);
        DynamicArray iterable2 = new DynamicArray();
        iterable2.add(5);

        Iterator itr11 = iterable1.iterator();
        itr11.next();
        Iterator itr21 = iterable1.iterator();
    }
}
