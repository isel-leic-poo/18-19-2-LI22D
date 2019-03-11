package edu.isel.adeetc.poo;

/**
 * Contract to be supported by all iterators, that is, objects that are able to traverse a container.
 */
public interface Iterator {

    /**
     * Gets the next element.
     * @return the next element
     */
    int next();

    /**
     * Gets a boolean value whether the current traversal may proceed or not, that is, the next element actually exists.
     * @return a boolean value indicating whether the next element exists or not.
     */
    boolean hasNext();
}
