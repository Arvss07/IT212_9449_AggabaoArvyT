/**
 * Name: AGGABAO, Arvy T.
 * CLass Code & Course Number: IT212 - 9449
 *
 * A fixed size implementation of a Linked List
 *
 */

package prelim;

import prelim.interfaceAndTemplate.ListOverflowException;
import prelim.interfaceAndTemplate.MyList;

import java.util.NoSuchElementException;


/**
 * General Algorithm for Fixed Size Array List:
 * 1. Create an array with a fixed size [5]
 * 2. Create a constructor that initializes the list
 * 3. Implement MyList methods
 * 4. End
 */
public class MyFixedSizeArrayList<T> implements MyList<T> {
    private final int MAX_SIZE = 5;
    private Object[] elements;
    private int listSize;

    /** Constructor */
    public MyFixedSizeArrayList() {
        elements = new Object [MAX_SIZE];
        listSize = 0;
    }

    @Override
    public int getSize() {
        return listSize;
    }

    /**
     * Insert an element at the end of the list
     * @param data the element to be inserted
     * @throws ListOverflowException if the list is full
     */
    @Override
    public void insert(T data) throws ListOverflowException {
        // Check if the list is full
        if (listSize >= MAX_SIZE) {
            // Throw an exception if the list is full
            throw new ListOverflowException("List is full. Cannot insert more elements.");
        }
        // Insert the element at the end of the list
        elements[listSize] = data;
        // Increment the size of the list
        listSize++;
    }

    /**
     * Get the element with the same value as the parameter
     * @param data the element to be searched
     * @return the element if found, else throw NoSuchElementException
     * @throws NoSuchElementException if the element is not found
     */
    @Override
    public T getElement(T data) throws NoSuchElementException {
        // search for the element in the list
        if (search(data) != -1) {
            return data;
        } else {
            throw new NoSuchElementException("Element not found.");
        } // end of if statement
    } // end of getElement method

    /**
     * Delete the element with the same value as the parameter
     * @param data the element to be deleted
     * @return true if the element is deleted, else false
     */
    @Override
    public boolean delete(T data) {
        // Search for the element in the list
        for (int i = 0; i < listSize; i++) {
            // Check if the element is found
            if (elements[i].equals(data)) {
                // Shift elements to fill the gap
                // The size of the list is decremented
                for (int j = i; j < listSize - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                listSize--;
                return true;
            } // end of if statement
        } // end of for loop
        return false; // Element not found
    } // end of delete method

    /**
     * Search for the element with the same value as the parameter
     * @param data the element to be searched
     * @return the index of the element if found, else -1
     */
    @Override
    public int search(T data) {
        // Search for the element in the list
        for (int i = 0; i < listSize; i++) {
            // Check if the element is found
            if (elements[i].equals(data)) {
                // Return the index of the element if found
                return i;
            }
        }
        return -1; // Element not found
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