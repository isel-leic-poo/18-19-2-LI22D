package edu.isel.adeetc.poo;

/**
 * Class whose instances represent arrays whose size grows according to execution time needs.
 */
public class DynamicArray {

    private static final int INITIAL_CAPACITY = 4;
    private int[] array;
    private int size;

    private void growArrayIfNeeded() {
        if (size != array.length)
            return;

        int[] newArray = new int[array.length * 2];
        for (int idx = 0; idx < array.length; idx++)
            newArray[idx] = array[idx];

        array = newArray;
    }

    public DynamicArray(int initialCapacity) {
        array = new int[initialCapacity];
        size = 0;
    }

    public DynamicArray() {
        this(INITIAL_CAPACITY);
    }

    public void add(int value) {
        growArrayIfNeeded();
        array[size++] = value;
    }

    public int size() {
        return size;
    }

    public int get(int idx) {
        return array[idx];
    }
}
