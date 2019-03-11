package edu.isel.adeetc.poo;

/**
 * Class whose instances represent linked lists.
 */
public class LinkedList implements Sequence {

    private static class ListIterator implements Iterator {

        private final LinkedList list;
        private Node iterator;

        ListIterator(LinkedList list) {
            this.list = list;
            this.iterator = list.head;
        }

        @Override
        public int next() {
            if (!hasNext())
                throw new IllegalStateException();

            int elem = iterator.value;
            iterator = iterator.next;
            return elem;
        }

        @Override
        public boolean hasNext() {
            return iterator != list.tail;
        }
    }

    /**
     * Class whose instances represent list nodes.
     */
    private static class Node {
        public Node next;
        public final int value;
        public Node(int value) {
            this(value, null);
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size;
    private Node head, tail;

    /**
     * Creates an instance.
     */
    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    /**
     * Adds the given element to the end (i.e. last position) of the container.
     * @param value the element to be added.
     * @see #add(int)
     */
    public void addFirst(int value) {
        head = new Node(value, head);
        if (tail == null)
            tail = head;
        size += 1;
    }

    /**
     * Adds the given element to the end (i.e. last position) of the container.
     * @param value the element to be added.
     * @see #add(int)
     */
    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
        }
        else {
            tail = tail.next = new Node(value);
            size += 1;
        }
    }

    /**
     * Adds the given element to the end (i.e. last position) of the container.
     * @param value the element to be added.
     */
    @Override
    public void add(int value) {
        addLast(value);
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

        if (idx == 0) {
            addFirst(value);
            return;
        }

        Node curr = head;
        while (--idx != 0)
            curr = curr.next;

        Node newNode = new Node(value, curr.next);
        curr.next = newNode;

        if (newNode.next == null)
            tail = newNode;

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

        Node curr = head;
        if (size() == 1 || idx == 0) {
            int elem = curr.value;
            head = curr.next;
            size -= 1;
            return elem;
        }

        Node prev = curr;
        curr = curr.next;
        while (--idx != 0) {
            prev = curr;
            curr = curr.next;
        }

        int elem = curr.value;
        prev.next = curr.next;
        if (curr.next == null)
            tail = prev;
        return elem;
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

        Node curr = head;
        while (idx-- != 0)
            curr = curr.next;

        return curr.value;
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

        final int result = tail.value;

        if (tail == head) {
            head = tail = null;
        } else {
            Node curr = head;
            while (curr.next != tail)
                curr = curr.next;

            tail = curr;
            curr.next = null;
        }

        size -= 1;
        return result;
    }

    /**
     * Gets an iterator for the container.
     * @return the iterator to be used in the traversal.
     */
    @Override
    public Iterator iterator() {
        return new ListIterator(this);
    }
}
