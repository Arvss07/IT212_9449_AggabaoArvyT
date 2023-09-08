/**
 * Name: AGGABAO, Arvy T.
 * CLass Code & Course Number: IT212 - 9449
 *
 * A class that implements the MyList interface using an array
 * that grows when the list is full.
 */
package prelim;

import prelim.interfaceAndTemplate.ListOverflowException;
import prelim.interfaceAndTemplate.MyList;

import java.util.NoSuchElementException;

/**
 * General Algorithm for Growing Array List:
 * 1. Create an array with a default size
 * 2. Check if the list is full
 * 3. If full, create a new array with double the size
 * 4. Copy the elements from the old array to the new array
 * 5. Set the new array as the elements array
 * 6. Insert the element into the list
 * 7. End
 */
public class MyGrowingArrayList<T> implements MyList<T> {
    private final int DEFAULT_SIZE = 5;
    private Object[] elements;
    private int listSize;

    /**
     * Default constructor
     */
    public MyGrowingArrayList() {
        elements = new Object[DEFAULT_SIZE];
        listSize = 0;
    } // end of constructor


    @Override
    /**
     * Return the size of the list
     * @return the size of the list
     */
    public int getSize() {
        return listSize;
    } // end of getSize method

    @Override
    /**
     * Insert an element into the list
     * @param data the element to be inserted
     * @throws ListOverflowException if the list is full
     */
    public void insert(T data) throws ListOverflowException {
        // check if the list is full
        if (listSize == elements.length) {
            // create a new array with double the size
            Object[] newElements = new Object[elements.length * 2];

        // copy the elements from the old array to the new array
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        } // end of for loop

        elements = newElements;
        } // end of if statement

        elements[listSize] = data;
        listSize++;
    } // end of insert method

    @Override
    /**
     * Return the element of a list
     * @return the element at the specified index
     * @throws NoSuchElementException if the index is out of bounds
     */
    public T getElement(T data) throws NoSuchElementException {
        // search for the element in the list
        if (search(data) != -1) {
            return data;
        } else {
            throw new NoSuchElementException("Element not found.");
        } // end of if statement
    } // end of getElement method

    @Override
    /**
     * Delete an element from the list
     * @param data the element to be deleted
     * @return true if the element is deleted, else false
     */
    public boolean delete(T data) {
        // search for the element in the list
        for (int i = 0; i < listSize; i++) {
            // if the element is found, delete it
            if (elements[i].equals(data)) {
                // shift the elements to fill the gap
                for (int j = i; j < listSize - 1; j++) {
                    elements[j] = elements[j + 1];
                } // end of for loop
                // decrement the list size if the element is deleted
                listSize--;
                return true;
            } // end of if statement
        } // end of for loop
        // return false if the element is not found
        return false;
    }

    @Override
    /**
     * Search for the element with the same value as the parameter
     * @param data the element to be searched
     * @return the index of the element if found, else -1
     */
    public int search(T data) {
        // search for the element in the list
        for (int i = 0; i < listSize; i++) {
            // if the element is found, return its index
            if (elements[i].equals(data)) {
                return i; // return the index of the element
            } // end of if statement
        } // end of for loop
        return -1; // return -1 if the element is not found
    } // end of search method

    @Override
    /**
     * Get the element at the specified index
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * @throws NoSuchElementException if the index is out of bounds
     */
    public T getIndexElement(int index) throws NoSuchElementException {
        // Check if the index is within bounds
        if (index >= 0 && index < listSize) {
            // Return the element at the specified index
            return (T) elements[index];
        }
        throw new NoSuchElementException("Element not found at index " + index);
    } // end of getIndexElement method
} // end of class
