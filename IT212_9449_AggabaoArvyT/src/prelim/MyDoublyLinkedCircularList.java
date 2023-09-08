/**
 * Name: AGGABAO, Arvy T.
 * CLass Code & Course Number: IT212 - 9449
 *
 * A class that implements the MyList interface and
 * uses a doubly linked circular list as the data structure.
 *
 */
package prelim;

import prelim.interfaceAndTemplate.LinkedListNodeAggabaoArvy;
import prelim.interfaceAndTemplate.ListOverflowException;
import prelim.interfaceAndTemplate.MyList;
import java.util.NoSuchElementException;

/**
 * General Algorithm for Doubly Linked Circular List:
 * 1. Create a new node
 * 2. Check if the list is empty
 * 3. If empty, set the new node as the head and tail
 * 4. Else, set the next node of the tail to the new node
 * 5. Ensure the new node points to the previous node
 * 6. Set the new node as the tail
 * 7. Increment the size of the list
 * 8. End
 */
public class MyDoublyLinkedCircularList<T> implements MyList<T> {
    private LinkedListNodeAggabaoArvy<T> head;
    private LinkedListNodeAggabaoArvy<T> tail;
    private int listSize;

    /**
     * Constructor
     */
    public MyDoublyLinkedCircularList() {
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
            // Make it circular
            head.setNext(tail);
            tail.setNext(head);

        } else {
            // Set the next node of the tail to the new node
            tail.setNext(newNode);
            // Ensure the new node points to the previous node
            newNode.setNext(tail);
            // Set the new node as the tail
            tail = newNode;
            // Make it circular
            tail.setNext(head);
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
        // Traverse the list until the element is found
        do {
            if (current.getData().equals(data)) {
                // Return the element if found
                return current.getData();
            }
        } while (current != head);  // end of do-while loop

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
            if (head == tail) {
                tail = null;
            } // end of if statement
            // Make it circular
            if (head != null) {
                tail.setNext(head);
            } // end of if statement
            // Decrement the size of the list
            listSize--;
            // Return true if the element is deleted
            return true;
        } // end of if statement

        LinkedListNodeAggabaoArvy<T> current = head;
        while(current.getNext() != head) {
            // Check if the next node is the element to be deleted
            if (current.getNext().getData().equals(data)) {
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
    public int search(T data) {
        LinkedListNodeAggabaoArvy<T> current = head;
        int index = 0;
        // Traverse the list until the element is found
        do {
            // Check if the current node is the element to be searched
            if (current.getData().equals(data)) {
                // Return the index of the element if found
                return index;
            }
            // Move to the next node
            current = current.getNext();
            index++;
        } while (current != head); // end of do-while loop
        // Return -1 if the element is not found
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

        System.out.println("List contents [Doubly Linked Circular List]: ");
        int currentIndex = 0;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
            currentIndex++;
        } while (current != head);
        System.out.println();
    } // end of display method
} // end of MyDoublyLinkedList class
