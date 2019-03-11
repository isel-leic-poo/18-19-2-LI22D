package edu.isel.adeetc.poo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTests {

    @Test(expected = IllegalArgumentException.class)
    public void getOnEmptyList_shouldThrow() {
        LinkedList sut = new LinkedList();
        sut.get(0);
    }

    @Test
    public void getFirstElementOfNonEmptyList_producesCorrectResult() {
        LinkedList sut = new LinkedList();
        int expected = 42;
        sut.add(expected);
        assertEquals(expected, sut.get(0));
    }

    @Test
    public void getElementOnNonEmptyList_producesCorrectResult() {
        LinkedList sut = new LinkedList();
        int expected = 42;
        sut.add(1);
        sut.add(2);
        sut.add(expected);
        sut.add(4);
        assertEquals(expected, sut.get(2));
    }

    @Test
    public void addOnEmptyList_makesSizeOne() {
        LinkedList sut = new LinkedList();
        sut.add(5);
        assertEquals(1, sut.size());
    }

    @Test
    public void addFirst_addsElementToTheHead() {
        LinkedList sut = new LinkedList();
        sut.addFirst(5);
        sut.addFirst(3);

        int expected = 42;
        sut.addFirst(expected);

        assertEquals(expected, sut.get(0));
        assertEquals(3, sut.size());
    }

    @Test(expected = IllegalStateException.class)
    public void removeOnEmptyList_shouldThrow() {
        LinkedList sut = new LinkedList();
        sut.remove();
    }

    @Test
    public void removeOnNonEmptyList_returnsElement() {
        LinkedList sut = new LinkedList();
        int expected = 5;
        sut.add(expected);
        assertEquals(expected, sut.remove());
    }

    @Test
    public void removeAtIndex_returnsElement() {
        LinkedList sut = new LinkedList();
        int expected = 5, other = 42;
        sut.add(expected);
        sut.add(other);
        sut.add(other);

        assertEquals(3, sut.size());
        assertEquals(expected, sut.remove(0));
        assertEquals(2, sut.size());
    }

    @Test
    public void addAtIndexEqualToSize_onListWithOneElement_worksFine() {
        LinkedList sut = new LinkedList();
        sut.add(5);

        int expected = 42;
        sut.add(1, expected);

        assertEquals(expected, sut.get(1));
    }
}
