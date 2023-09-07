package prelim.executableClass;

import prelim.interfaceAndTemplate.ListOverflowException;
import prelim.MyGrowingArrayList;

import java.util.NoSuchElementException;

public class TestMyGrowingArrayList {
    public static void main(String[] args) {
        MyGrowingArrayList<String> completedTasks = new MyGrowingArrayList<>();

        try {
            // Insert some completed tasks into the list
            completedTasks.insert("Project 1 - Due Date: 2023-08-15");
            completedTasks.insert("Assignment 1 - Due Date: 2023-09-02");
            completedTasks.insert("Project 2 - Due Date: 2023-09-20");
            completedTasks.insert("Assignment 2 - Due Date: 2023-10-02");
            completedTasks.insert("Project 3 - Due Date: 2023-10-20");
            completedTasks.insert("Assignment 3 - Due Date: 2023-11-02");
            completedTasks.insert("Project 4 - Due Date: 2023-11-20");
            completedTasks.insert("Assignment 4 - Due Date: 2023-12-02");

            // Printing the whole list
            System.out.println("Completed tasks:");
            for (int i = 0; i < completedTasks.getSize(); i++) {
                System.out.println(completedTasks.getIndexElement(i));
            }


            System.out.println();
            // Demonstrate the getElement method by displaying all elements in the list
            System.out.println(completedTasks.getElement("Project 1 - Due Date: 2023-08-15"));

            // Get the size of the list
            System.out.println();
            System.out.println("Completed tasks count: " + completedTasks.getSize());

            // Search for a completed task in the list
            System.out.println("\n\nSearching for a completed task in the list...");
            System.out.println("Searching for: Project 1 - Due Date: 2023-08-15");
            String searchTask = "Project 1 - Due Date: 2023-08-15";
            int index = completedTasks.search(searchTask);
            if (index != -1) {
                System.out.println("Found at index " + index);
            } else {
                System.out.println("Task not found.");
            }

            // Delete a completed task from the list
            System.out.println("\n\nDeleting a completed task from the list...");
            System.out.println("Deleting: Assignment 1 - Due Date: 2023-09-02");
            String deleteTask = "Assignment 1 - Due Date: 2023-09-02";
            boolean deleted = completedTasks.delete(deleteTask);
            if (deleted) {
                System.out.println(deleteTask + " deleted from the list.");
            } else {
                System.out.println(deleteTask + " not found for deletion.");
            }
            System.out.println("\nCompleted tasks count: " + completedTasks.getSize());

        } catch (ListOverflowException e) {
            System.out.println("ListOverflowException: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: " + e.getMessage());
        }
    } // end of main method
}
