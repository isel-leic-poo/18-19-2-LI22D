package edu.isel.adeetc.poo;

/**
 * Contract to be supported by all containers that can be traversed.
 */
public interface Iterable {

    /**
     * Gets an iterator for the container.
     * @return the iterator to be used in the traversal.
     */
    Iterator iterator();
}
