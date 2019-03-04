package edu.isel.adeetc.poo;

class Node {
    public final Node next;
    public final int value;
    public Node(int value) {
        this(value, null);
    }
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

public class LinkedList {

    private int size;
    private Node head;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(int value) {
        head = new Node(value, head);
        size += 1;
    }

    public void addLast(int value) {
        add(value);
    }

    public void add(int value) {
        // TODO
    }

    public void add(int idx, int value) {
        // TODO
    }

    public int remove(int idx) {
        // TODO
        return 0;
    }

    public int size() {
        return size;
    }

    public int get(int idx) {
        if (idx < 0 || idx >= size())
            throw new IllegalArgumentException("Invalid index");

        Node curr = head;
        while (idx-- != 0)
            curr = curr.next;

        return curr.value;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException("Container is empty");

        //TODO
        return 0;
    }
}
