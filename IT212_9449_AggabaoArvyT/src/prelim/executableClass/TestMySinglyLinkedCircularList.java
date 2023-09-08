package prelim.executableClass;

import prelim.MySinglyLinkedCircularList;
import prelim.interfaceAndTemplate.ListOverflowException;

import java.util.NoSuchElementException;

public class TestMySinglyLinkedCircularList {
    public static void main(String[] args) throws ListOverflowException {
        // Create a MySinglyLinkedCircularList to store Animal objects
        MySinglyLinkedCircularList<Animal> animalList = new MySinglyLinkedCircularList<>();

        // Insert Animal objects into the list
        Animal lion = new Animal("Lion");
        Animal tiger = new Animal("Tiger");
        Animal bear = new Animal("Bear");
        Animal elephant = new Animal("Elephant");
        Animal giraffe = new Animal("Giraffe");

        try {
            animalList.insert(lion);
            animalList.insert(tiger);
            animalList.insert(bear);
            animalList.insert(elephant);
            animalList.insert(giraffe);
        } catch (ListOverflowException e) {
            System.out.println(e.getMessage());
        }

        // Display the elements in the circular singly linked list
        System.out.println("List contents:");
        animalList.display();

        // Test other methods
        System.out.println("Size of the list: " + animalList.getSize());

        // Search for an animal by name
        String searchAnimalName = "Lion";
        int searchResult = animalList.search(new Animal(searchAnimalName));
        if (searchResult != -1) {
            System.out.println(searchAnimalName + " found at index " + searchResult);
        } else {
            System.out.println(searchAnimalName + " not found in the list.");
        }

        // Get an element at a specific index
        try {
            Animal elementAtIndex = animalList.getIndexElement(2);
            System.out.println("Element at index 2: " + elementAtIndex.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Insert an element at the front
        Animal zebra = new Animal("Zebra");
        animalList.insertAtFront(zebra);
        System.out.println("After inserting Zebra at the front:");
        animalList.display();

        // Insert an element at the end
        Animal rhino = new Animal("Rhino");
        animalList.insert(rhino);
        System.out.println("After inserting Rhino at the end:");
        animalList.display();

        // Clear the list
        animalList.clear();
        System.out.println("After clearing the list:");
        animalList.display();

        // Check if the list is empty
        System.out.println("Is the list empty? " + animalList.isEmpty());
    }

} // end of class TestMySinglyLinkedCircularList
