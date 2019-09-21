/**
 * You are given an interface for a type of list. The list works like this:
 *  entries can only be added to and removed from the beginning or end of the list
 *  entries can be accessed in any position
 *  entries begin at index 0
 *
 * Write a class that implements this interface. The class uses arrays to implement the list.
 *
 * You must implement every method from the interface. Make sure to account for special conditions such as empty lists
 *  and singleton lists. Your code should not crash under these conditions.
 *
 *  Your class must compile and have the following implemented methods. Follow the API descriptions from the interface
 *      file and the additional characteristics listed below.
 *
 * (3 points) constructor(int)
 * take an initial capacity in as a parameter
 * (12 points) addFront(T)
 * when the array is full, expand the array by doubling
 * (12 points) addBack(T)
 * when the array is full, expand the array by doubling
 * (12 points) removeFront()
 * (12 points) removeBack()
 * (7 points) contains (T)
 * (7 points) indexOf(T)
 * (7 points) lastIndexOf(T)
 * (7 points) getEntry(int)
 * review the interface to see what happens with invalid positions
 * (4 points) display()
 * see the tester program for the format of the output- your display must match this format!
 * the output must contain the size, the capacity, and a display of all elements in the list
 * (3 points) clear()
 * (2 points) isEmpty()
 * (2 points) size()
 * (10 points) Style
 * Your class should follow Java coding conventions and best practices.
 * Follow naming conventions for variables, classes, and methods.
 * Reduce duplicated code
 *
 *
 */

public class ArrayHeadTailList<T> implements HeadTailListInterface<T> {
    private T[] listArray;
    private int numberOfElements;
}