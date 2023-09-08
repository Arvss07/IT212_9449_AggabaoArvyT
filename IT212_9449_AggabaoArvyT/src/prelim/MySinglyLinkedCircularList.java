/**
 * Name: AGGABAO, Arvy T.
 * CLass Code & Course Number: IT212 - 9449
 *
 * A class that implements the MyList interface and
 * uses a singly linked circular list as the data structure.
 *
 */

package prelim;

import prelim.interfaceAndTemplate.LinkedListNodeAggabaoArvy;
import prelim.interfaceAndTemplate.ListOverflowException;
import prelim.interfaceAndTemplate.MyList;
import prelim.interfaceAndTemplate.MyListCircular;

import java.util.NoSuchElementException;

/**
 * General Algorithm for Singly Linked Circular List:
 * 1. Create a new node
 * 2. Check if the list is empty
 * 3. If empty, set the new node as the head
 * 4. Else, traverse the list until the last node
 * 5. Set the new node as the next node of the last node
 * 6. Make the list circular by pointing the new node to the head
 * 7. Increment the size of the list
 * 8. End
 */

public class MySinglyLinkedCircularList<T> implements MyList<T>, MyListCircular<T> {
    private LinkedListNodeAggabaoArvy<T> head;
    private int listSize;

    /**
     * Constructor
     */
    public MySinglyLinkedCircularList() {
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
    public void insert(T data) throws ListOverflowException {
        // Create a new node
        LinkedListNodeAggabaoArvy<T> newNode = new LinkedListNodeAggabaoArvy<>(data);
        if (head == null) {
            // If empty, set the new node as the head
            // Make it circular by pointing the next node to itself
            head = newNode;
            head.setNext(head);

        } else {
            // Find the last node and point it to the new node to keep it circular
            LinkedListNodeAggabaoArvy<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            } // end of while loop
            newNode.setNext(head);
            current.setNext(newNode);
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
            current = current.getNext();
        } while (current.getNext() != head);  // update termination condition

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
            return false;
        } // end of if statement

        // Check if the element to be deleted is the head
        if (head.getData().equals(data)) {
            if (listSize == 1) {
                // Remove the head node if the list has only one element
                head = null;
            } else {
                // Find the last node and update its next reference
                LinkedListNodeAggabaoArvy<T> current = head;
                while (current.getNext() != head) {
                    current = current.getNext();
                } // end of if-else statement
                // Set the next node as the head
                head = head.getNext();
                // update the last element next pointer
                current.setNext(head);
            } // end of if-else statement
            // Decrement the size of the list
            listSize--;
            return true;
        } else {
            LinkedListNodeAggabaoArvy<T> current = head;
            LinkedListNodeAggabaoArvy<T> prev = null;

            for (int i = 0; i < listSize; i++) {
                if (current.getData().equals(data)) {
                    prev.setNext(current.getNext());
                    listSize--;
                    return true;
                }
                prev = current;
                current = current.getNext();
            }
            return false; // Data not found in the list
        } // end of if-else statement
    } // end of delete method

    @Override
    /**
     * Search for the element with the same value as the parameter
     * @param data the element to be searched
     * @return the index of the element if found, else -1
     */
    public int search(T data) {
        LinkedListNodeAggabaoArvy<T> current = head;
        for (int i = 0; i < listSize; i++) {
            if (current.getData().equals(data)) {
                return i;
            }
            current = current.getNext();
        }
        return -1; // Data not found in the list
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

        System.out.println("List contents [Singly Linked Circular List]: ");
        int currentIndex = 0;
        do {
            System.out.print(current.getData());
            current = current.getNext();
            currentIndex++;
        } while (current != head);

        System.out.println();
    } // end of display method

    @Override
    public void insertAtFront(T data) {
        // Create a new node
        LinkedListNodeAggabaoArvy<T> newNode = new LinkedListNodeAggabaoArvy<>(data);
        if (head == null) {
            // If empty, set the new node as the head
            // Make it circular by pointing the next node to itself
            head = newNode;
            head.setNext(head);
        } else {
            // Find the last node and point it to the new node to keep it circular
            LinkedListNodeAggabaoArvy<T> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            newNode.setNext(head);
            current.setNext(newNode);
            head = newNode; // Update the head to the new node
        }

        // Increment the size of the list
        listSize++;
    }

    @Override
    public void clear() {
        head = null;
        listSize = 0;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }
} // end of class