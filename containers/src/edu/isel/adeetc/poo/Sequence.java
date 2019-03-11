package edu.isel.adeetc.poo;

/**
 * Contract to be supported by all containers that represent sequences of elements. In a sequence each element is
 * associated to a particular order number (i.e. index).
 */
public interface Sequence extends Iterable {

    /**
     * Adds the given element to the end (i.e. last position) of the container.
     * @param value the element to be added.
     */
    void add(int value);

    /**
     * Adds the given element at the specified position. All elements from that position are shifted right (i.e. their
     * indexes are incremented).
     * @param idx   the index where the element is to be added. It must be in the interval [0..size].
     * @param value the element to be added.
     * @throws      IllegalArgumentException if {@param idx} is not in the interval [0..size].
     */
    void add(int idx, int value);

    /**
     * Removes an element from the end (i.e. last position) of the container.
     * @return the removed element.
     * @throws IllegalStateException if the container is currently empty.
     */
    int remove();

    /**
     * Removes an element from the specified position.
     * @param idx   the index from where the element is to be removed. It must be in the interval [0..size[.
     * @return      the removed element.
     * @throws      IllegalArgumentException if {@param idx} is not in the interval [0..size[ .
     */
    int remove(int idx);

    /**
     * Gets the number of elements stored in the container.
     * @return the of stored elements.
     */
    int size();

    /**
     * Gets the element at the specified position.
     * @param idx   the index of the element. It must be in the interval [0..size[.
     * @return      the corresponding element.
     * @throws      IllegalArgumentException if {@param idx} is not in the interval [0..size[ .
     */
    int get(int idx);

    /**
     * Gets a boolean value indicating whether the container is empty or not.
     * @return  {@literal true} if the container is empty, {@literal false} otherwise.
     */
    boolean isEmpty();
}
