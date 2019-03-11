package edu.isel.adeetc.poo;

/**
 * Class whose instances represent arrays whose capacity increases according to execution needs.
 */
public class DynamicArray implements Sequence {

    private static class ArrayIterator implements Iterator {

        private final DynamicArray array;
        private int iterator;

        ArrayIterator(DynamicArray array) {
            this.array = array;
            this.iterator = 0;
        }

        @Override
        public int next() {
            if (!hasNext())
                throw new IllegalStateException();

            return array.get(++iterator);
        }

        @Override
        public boolean hasNext() {
            return iterator != array.size() - 1;
        }
    }

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

    /**
     * Creates an instance with the given initial capacity.
     * @param initialCapacity the initial capacity.
     */
    public DynamicArray(int initialCapacity) {
        array = new int[initialCapacity];
        size = 0;
    }

    /**
     * Creates an instance with the default initial capacity.
     */
    public DynamicArray() {
        this(INITIAL_CAPACITY);
    }

    /**
     * Adds the given element to the end (i.e. last position) of the container.
     * @param value the element to be added.
     */
    @Override
    public void add(int value) {
        growArrayIfNeeded();
        array[size++] = value;
    }

    /**
     * Adds the given element at the specified position. All elements from that position are shifted right (i.e. their
     * indexes are incremented).
     * @param idx   the index where the element is to be added. It must be in the interval [0..size].
     * @param value the element to be added.
     * @throws      IllegalArgumentException if {@param idx} is not in the interval [0..size].
     */
    @Override
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

    /**
     * Removes an element from the specified position.
     * @param idx   the index from where the element is to be removed. It must be in the interval [0..size[.
     * @return      the removed element.
     * @throws      IllegalArgumentException if {@param idx} is not in the interval [0..size[ .
     */
    @Override
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

    /**
     * Gets the number of elements stored in the container.
     * @return the of stored elements.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Gets the element at the specified position.
     * @param idx   the index of the element. It must be in the interval [0..size[.
     * @return      the corresponding element.
     * @throws      IllegalArgumentException if {@param idx} is not in the interval [0..size[ .
     */
    @Override
    public int get(int idx) {
        if (idx < 0 || idx >= size())
            throw new IllegalArgumentException("Invalid index");
        return array[idx];
    }

    /**
     * Gets a boolean value indicating whether the container is empty or not.
     * @return  {@literal true} if the container is empty, {@literal false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Removes an element from the end (i.e. last position) of the container.
     * @return the removed element.
     * @throws IllegalStateException if the container is currently empty.
     */
    @Override
    public int remove() {
        if (isEmpty())
            throw new IllegalStateException("Container is empty");

        return array[--size];
    }

    /**
     * Gets the current capacity of the container.
     * @return  the current capacity.
     */
    public int capacity() {
        return array.length;
    }

    /**
     * Gets an iterator for the container.
     * @return the iterator to be used in the traversal.
     */
    @Override
    public Iterator iterator() {
        return new ArrayIterator(this);
    }
}
