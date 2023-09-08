package prelim.executableClass;

import prelim.MyDoublyLinkedList;
import prelim.interfaceAndTemplate.ListOverflowException;

import java.util.Scanner;
import java.util.NoSuchElementException;


public class TestMyDoublyLinkedList {
    public static void main(String[] args) {
        MyDoublyLinkedList<Person> personList = new MyDoublyLinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Insert Person");
            System.out.println("2. Search Person");
            System.out.println("3. Delete Person");
            System.out.println("4. Get Person at Index");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("Enter a name (or 'stop' to stop inserting): ");
                        String name = scanner.next();
                        if (name.equals("stop")) {
                            break; // Exit the insert loop
                        }
                        Person person = new Person(name);

                        try {
                            personList.insert(person);
                            System.out.print("person added to the list.");
                            System.out.println();
                        } catch (ListOverflowException e) {
                            System.out.println("List is full.");
                            break; // Exit the insert loop if the list is full
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter a name to search: ");
                    String searchName = scanner.next();
                    int searchIndex = personList.search(new Person(searchName));
                    if (searchIndex != -1) {
                        System.out.println("Person found at index " + searchIndex + ": " + personList.getIndexElement(searchIndex));
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter a name to delete: ");
                    String deleteName = scanner.next();
                    boolean deleteResult = personList.delete(new Person(deleteName));
                    if (deleteResult) {
                        System.out.println("Person " + deleteName + " deleted.");
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter an index to get a person: ");
                    int index = scanner.nextInt();
                    try {
                        Person personAtIndex = personList.getIndexElement(index);
                        System.out.println("Person at index " + index + ": " + personAtIndex);
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    personList.display();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
