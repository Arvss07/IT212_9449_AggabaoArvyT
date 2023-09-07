/**
 * Name: AGGABAO, Arvy T.
 * CLass Code & Course Number: IT212 - 9449
 *
 * A class that implements the MyList interface and
 * uses a singly linked list as the data structure.
 *
 */

package prelim;

import prelim.interfaceAndTemplate.LinkedListNodeAggabaoArvy;
import prelim.interfaceAndTemplate.ListOverflowException;
import prelim.interfaceAndTemplate.MyList;
import java.util.NoSuchElementException;

/**
 * General Algorithm:
 * 1. Create a new node
 * 2. Check if the list is empty
 * 3. If empty, set the new node as the head
 * 4. If not empty, traverse the list until the last node
 * 5. Set the new node as the next node of the last node
 */

public class MySinglyLinkedList<T> implements MyList {
    private LinkedListNodeAggabaoArvy<T> head;
    private int listSize;

    /**
     * Constructor
     */
    public MySinglyLinkedList() {
        head = null;
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
    public void insert(Object data) throws ListOverflowException {
        // Create a new node
        LinkedListNodeAggabaoArvy<T> newNode = new LinkedListNodeAggabaoArvy<>((T) data);
        // Check if the list is empty
        if (head == null) {
            // If empty, set the new node as the head
            head = newNode;

        } else {
            // If not empty, traverse the list until the last node
            LinkedListNodeAggabaoArvy<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            } // end of while loop
            // Set the new node as the next node of the last node
            current.setNext(newNode);
        } // end of if-else statement

    } // end of insert method

    @Override
    /**
     * Get the element with the same value as the parameter
     * @param data the element to be searched
     * @return the element if found, else throw NoSuchElementException
     * @throws NoSuchElementException if the element is not found
     */
    public T getElement(Object data) throws NoSuchElementException {
        LinkedListNodeAggabaoArvy<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current.getData();
            } // end of if statement
            current = current.getNext();
        } // end of while loop
        throw new NoSuchElementException("Element not found.");
    } // end of getElement method

    @Override
    /**
     * Delete the element with the same value as the parameter
     * @param data the element to be deleted
     * @return true if the element is deleted, else false
     */
    public boolean delete(Object data) {
        // Check if the list is empty
        if (head == null) {
            // Return false if the list is empty
            return false;
        } // end of if statement

        // Check if the element to be deleted is the head
        if (head.getData().equals(data)) {
            // Set the next node as the head
            head = head.getNext();
            // Decrement the size of the list
            listSize--;
            // Return true if the element is deleted
            return true;
        } // end of if statement

        // Traverse the list until the element is found
        LinkedListNodeAggabaoArvy<T> current = head;
        while(current.getNext() != null) {
            // Check if the next node is the element to be deleted
            if (current.getNext().getData().equals(data)) {
                // Set the next node of the current node to the next next node
                current.setNext(current.getNext().getNext());
                // Decrement the size of the list
                listSize--;
                // Return true if the element is deleted
                return true;
            } // end of if statement
            // Move to the next node
            current = current.getNext();
        } // end of while loop
        return false;
    } // end of delete method

    @Override
    /**
     * Search for the element with the same value as the parameter
     * @param data the element to be searched
     * @return the index of the element if found, else -1
     */
    public int search(Object data) {
        LinkedListNodeAggabaoArvy current = head;
        int index = 0;
        while (current != null) {
            if (current.getData().equals(data)) {
                return index;
            }
            // Move to the next node
            current = current.getNext();
            // Increment the index
            index++;
        } // end of while loop
        // return -1 if the element is not found
        return -1;
    } // end of search method

    /**
     * Get the element at the specified index
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * @throws NoSuchElementException if the index is out of bounds
     */
    public T getIndexElement(int index) throws NoSuchElementException {
        if (index < 0 || index >= listSize) {
            throw new NoSuchElementException("Element not found at index " + index);
        } // end of if statement
        LinkedListNodeAggabaoArvy<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        } // end of for loop
        return current.getData();
    } // end of getIndexElement method

    /**
     * display all the nodes present in the list
     */
    public void display() {
        LinkedListNodeAggabaoArvy<T> current = head;

        if (head == null) {
            System.out.println("List is empty.");
            return;
        } // end of if statement

        System.out.println("List contents [Singly Linked List]: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } // end of while loop
        System.out.println();
    } // end of display method
} // end of class