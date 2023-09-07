/**
 * Name: AGGABAO, Arvy T.
 * CLass Code & Course Number: IT212 - 9449
 *
 * Executable class for MyFixedSizeArrayList
 */

package prelim.executableClass;

import prelim.interfaceAndTemplate.ListOverflowException;
import prelim.MyFixedSizeArrayList;

import java.util.NoSuchElementException;

public class TestMyFixedSizeArrayList {
    public static void main(String[] args) {
        MyFixedSizeArrayList<Integer> sampleList = new MyFixedSizeArrayList<>();

        try {
            // Insert some elements into the list
            sampleList.insert(10);
            sampleList.insert(20);
            sampleList.insert(30);
            sampleList.insert(40);
            sampleList.insert(50);

            // Attempt to insert when the list is full (uncomment to test ListOverflowException)
            // sampleList.insert(60);

            // Get the contents of the list
            System.out.println("List contents:");
            for (int i = 0; i < sampleList.getSize(); i++) {
                System.out.println(sampleList.getIndexElement(i));
            }
            // Get the size of the list
            System.out.println("List size: " + sampleList.getSize());

            // Get an element from the list;
            System.out.println("Element: " + sampleList.getElement(30));

            // Search for an element in the list
            int searchElement = 30;

            // Uncomment to test NoSuchElementException
            //int searchElement = 100;
            int index = sampleList.search(searchElement);
            if (index != -1) {
                System.out.println("\"" + searchElement + "\" is located at index " + index);
            } else {
                System.out.println("\""+ searchElement + "\" not found.");
            }

            // Delete an element from the list
            int deleteElement = 20;
            boolean deleted = sampleList.delete(deleteElement);
            if (deleted) {
                System.out.println(deleteElement + " deleted from the list.");
            } else {
                System.out.println(deleteElement + " not found for deletion.");
            }

        } catch (ListOverflowException e) {
            System.out.println("ListOverflowException: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: " + e.getMessage());
        }
    } // end of main method
} // end of class