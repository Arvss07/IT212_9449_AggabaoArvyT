package prelim.executableClass;

import prelim.MySinglyLinkedList;
import prelim.interfaceAndTemplate.ListOverflowException;

import java.util.NoSuchElementException;

public class TestMySinglyLinkedList {
    public static void main(String[] args) {
        MySinglyLinkedList<Object> list = new MySinglyLinkedList<>();

        // Add random nodes to the list
        try {
            list.insert(1);
            list.insert("Hello");
            list.insert(2.5);
            list.insert("World");


            // Print the list
            list.display();

            // Delete the first node
            list.delete(2.5);

            // Print the new list
            list.display();

        } catch (ListOverflowException e) {
            System.out.println("ListOverflowException: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: " + e.getMessage());
        }
    } // end of main method
} // end of class TestMySinglyLinkedList
