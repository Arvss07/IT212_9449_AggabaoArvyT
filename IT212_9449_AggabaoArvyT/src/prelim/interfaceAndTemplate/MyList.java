/**
 * Name: AGGABAO, Arvy T.
 * CLass Code & Course Number: IT212 - 9449
 *
 * An interface for a Linked List
 */

package prelim.interfaceAndTemplate;

import java.util.NoSuchElementException;

public interface MyList<T> {



    int getSize();
    void insert(T data) throws ListOverflowException;
    T getElement(T data) throws NoSuchElementException;
    boolean delete(T data); // returns false if the data is not deleted in the list
    int search(T data); // returns index of data, else -1 is return

    T getIndexElement(int index) throws NoSuchElementException;

} // end of interface