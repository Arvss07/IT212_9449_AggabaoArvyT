/**
 * Name: AGGABAO, Arvy T.
 * CLass Code & Course Number: IT212 - 9449
 *
 * A class that implements the MyList interface and
 * uses a doubly linked list as the data structure.
 *
 */
package prelim;

import prelim.interfaceAndTemplate.LinkedListNodeAggabaoArvy;
import prelim.interfaceAndTemplate.ListOverflowException;
import prelim.interfaceAndTemplate.MyList;
import java.util.NoSuchElementException;


/**
 * General Algorithm for Doubly Linked List:
 * 1. Create a new node
 * 2. Check if the list is empty
 * 3. If empty, set the new node as the head and tail
 * 4. Else, set the next node of the tail to the new node
 * 5. Ensure the new node points to the previous node
 * 6. Set the new node as the tail
 * 7. Increment the size of the list
 * 8. End
 */
public class MyDoublyLinkedList<T> implements MyList<T> {
    private LinkedListNodeAggabaoArvy<T> head;
    private LinkedListNodeAggabaoArvy<T> tail;
    private int listSize;

    /**
     * Constructor
     */
    public MyDoublyLinkedList() {
        head = null;
        tail = null;
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
        // Create a new node
        LinkedListNodeAggabaoArvy<T> newNode = new LinkedListNodeAggabaoArvy<>(data);
        // Check if the list is empty
        if (head == null) {
            // If empty, set the new node as the head and tail
            head = newNode;
            tail = newNode;

        } else {
            tail.setNext(newNode);
            // Ensure the new node points to the previous node
            newNode.setNext(null);
            tail = newNode;
        } // end of if-else statement
        // Increment the size of the list
        listSize++;
    } // end of insert method

    @Override
    /**
     * Get the element with the same value as the parameter
     * @param data the element to be searched
     * @return the element if found, else throw NoSuchElementException
     * @throws NoSuchElementException if the element is not found
     */
    public T getElement(T data) throws NoSuchElementException {
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
    public boolean delete(T data) {
        // Check if the list is empty
        if (head == null) {
            // Return false if the list is empty
            return false;
        } // end of if statement

        // Check if the element to be deleted is the head
        if (head.getData().equals(data)) {
            // Set the next node as the head
            head = head.getNext();
            // This updates the tail if the list becomes empty
            if (head == null) {
                tail = null;
            } // end of if statement
            // Decrement the size of the list
            listSize--;
            // Return true if the element is deleted
            return true;
        } // end of if statement

        LinkedListNodeAggabaoArvy<T> current = head;
        while(current.getNext() != null) {
            // Check if the next node is the element to be deleted
            if (current.getNext().getData().equals(data)) {
                // Set the next node of the current node to the next next node
                current.setNext(current.getNext().getNext());

                if (current.getNext() == null) {
                    // Update the tail if the last node is deleted
                    tail = current;
                } // end of if statement

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
    public int search(T data) {
        LinkedListNodeAggabaoArvy<T> current = head;
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

        System.out.println("List contents [Doubly Linked List]: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } // end of while loop
        System.out.println();
    } // end of display method
} // end of MyDoublyLinkedList class
