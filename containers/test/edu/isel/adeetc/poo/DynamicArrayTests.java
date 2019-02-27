package edu.isel.adeetc.poo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicArrayTests {

    @Test(expected = IllegalArgumentException.class)
    public void getOnEmptyArray_shouldThrow() {
        DynamicArray sut = new DynamicArray(10);
        sut.get(0);
    }

    @Test
    public void getOnNonEmptyArray_producesCorrectResult() {
        DynamicArray sut = new DynamicArray(10);
        int expected = 42;
        sut.add(expected);
        assertEquals(expected, sut.get(0));
    }

    @Test(expected = IllegalStateException.class)
    public void removeOnEmptyArray_shouldThrow() {
        DynamicArray sut = new DynamicArray(10);
        sut.remove();
    }

    @Test
    public void removeOnNonEmptyArray_returnsElement() {
        DynamicArray sut = new DynamicArray(10);
        int expected = 5;
        sut.add(expected);
        assertEquals(expected, sut.remove());
    }

    @Test
    public void addOnEmptyArray_makesSizeOne() {
        DynamicArray sut = new DynamicArray(10);
        sut.add(5);
        assertEquals(1, sut.size());
    }

    @Test
    public void addAtZeroIndexOnFullArray_insertsElement() {

        final int INITIAL_CAPACITY = 10;
        DynamicArray sut = new DynamicArray(INITIAL_CAPACITY);
        for (int idx = 0; idx < sut.capacity(); idx++) {
            sut.add(idx);
        }

        int expected = 42;
        sut.add(0, expected);
        assertEquals(expected, sut.get(0));
        assertEquals(INITIAL_CAPACITY + 1, sut.size());
    }

    @Test
    public void addAtZeroIndexOnNonFullArray_insertsElement() {

        final int INITIAL_CAPACITY = 10;
        DynamicArray sut = new DynamicArray(INITIAL_CAPACITY);
        for (int idx = 0; idx < sut.capacity() - 1; idx++) {
            sut.add(idx);
        }

        int expected = 42;
        sut.add(0, expected);
        assertEquals(expected, sut.get(0));
        assertEquals(INITIAL_CAPACITY, sut.size());
    }

    @Test
    public void removeAtIndex_returnsElement() {
        DynamicArray sut = new DynamicArray(10);
        int expected = 5, other = 42;
        sut.add(expected);
        sut.add(other);
        sut.add(other);

        assertEquals(3, sut.size());
        assertEquals(expected, sut.remove(0));
        assertEquals(2, sut.size());
    }
}
