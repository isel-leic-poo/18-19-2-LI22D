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

    public void add(int idx, int value) {
        if (idx < 0 || idx > size())
            throw new IllegalArgumentException("Invalid index");

        int[] arr = size() != array.length ? array : new int[array.length * 2];

        int currIdx = size() - 1;
        while (currIdx >= idx) {
            arr[currIdx + 1] = array[currIdx];
            currIdx -= 1;
        }

        arr[idx] = value;
        if (array != arr) {
            for (int i = 0; i < idx; i++)
                arr[i] = array[i];
            array = arr;
        }

        size += 1;
    }

    public int remove(int idx) {
        if (idx < 0 || idx >= size())
            throw new IllegalArgumentException("Invalid index");

        int element = array[idx];
        for (int i = idx; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size -= 1;
        return element;
    }

    public int size() {
        return size;
    }

    public int get(int idx) {
        if (idx < 0 || idx >= size())
            throw new IllegalArgumentException("Invalid index");
        return array[idx];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException("Container is empty");

        return array[--size];
    }

    public int capacity() {
        return array.length;
    }
}
