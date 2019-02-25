package edu.isel.adeetc.poo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int total = 0;
        DynamicArray array = new DynamicArray();

        int value;
        while ((value = in.nextInt()) != 0) {
            array.add(value);
            total += value;
        }

        int average = total / array.size();
        for(int idx=0; idx < array.size(); ++idx) {
            int element = array.get(idx);
            if (element > average)
                System.out.print(element + " ");
        }
    }
}
