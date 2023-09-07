/**
 * Name: AGGABAO, Arvy T.
 * CLass Code & Course Number: IT212 - 9449
 *
 * Template for a node of a Linked List
 */

package prelim.interfaceAndTemplate;

public class LinkedListNodeAggabaoArvy<T> {
    private T data;
    private LinkedListNodeAggabaoArvy<T> next;


    /** Constructor with parameters*/
    public LinkedListNodeAggabaoArvy(T data, LinkedListNodeAggabaoArvy<T> next) {
        this.data = data;
        this.next = next;
    } // end of constructor

    public LinkedListNodeAggabaoArvy(T data) {
        this(data, null);
    } // end of constructor



    /** Getters and Setters */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedListNodeAggabaoArvy<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNodeAggabaoArvy<T> next) {
        this.next = next;
    }
} // end of class
