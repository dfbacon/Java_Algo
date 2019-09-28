import java.util.Arrays;

/**
 * You are given an interface for a type of list. The list works like this:
 *  entries can only be added to and removed from the beginning or end of the list
 *  entries can be accessed in any position
 *  entries begin at index 0
 *
 * Write a class that implements this interface. The class uses arrays to implement
 *  the list.
 *
 * You must implement every method from the interface. Make sure to account for
 *  special conditions such as empty lists and singleton lists. Your code should
 *  not crash under these conditions.
 *
 * Your class must compile and have the following implemented methods. Follow the
 *  API descriptions from the interface file and the additional characteristics
 *  listed below.
 *
 * (12 points) addFront(T)
 * when the array is full, expand the array by doubling
 *
 * (12 points) addBack(T)
 * when the array is full, expand the array by doubling
 *
 * (12 points) removeFront()
 * (12 points) removeBack()
 * (7 points) contains (T)
 * (7 points) indexOf(T)
 * (7 points) lastIndexOf(T)
 * (7 points) getEntry(int)
 * review the interface to see what happens with invalid positions
 *
 * (4 points) display()
 * see the tester program for the format of the output- your display must match this format!
 * the output must contain the size, the capacity, and a display of all elements in the list
 *
 * (3 points) clear()
 * (2 points) isEmpty()
 * (2 points) size()
 *
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
    private boolean integrityOK;


    public ArrayHeadTailList(int initialCapacity) {
        integrityOK = false;

        if (initialCapacity < 0) {
            throw new IllegalStateException("Attempt to create an array " +
                    "whose capacity is a negative value.");
        }

        @SuppressWarnings("unchecked")
        T[] tempArray = (T[])new Object[initialCapacity];

        listArray = tempArray;
        numberOfElements = 0;
        integrityOK = true;
    }

    /**
     * Adds a new entry to the beginning of the list.
     * Entries currently in the list are shifted down.
     * The list size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    public void addFront(T newEntry) {
        checkIntegrity();
        ensureCapacity();

        for (int index = numberOfElements; index >= 0; index--) {
            listArray[index + 1] = listArray[index];
        }

        listArray[0] = newEntry;
        numberOfElements++;
    }

    /**
     * Adds a new entry to the end of the list.
     * Entries currently in the list are unaffected.
     * The list size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    public void addBack(T newEntry) {
        checkIntegrity();
        ensureCapacity();

        listArray[numberOfElements + 1] = newEntry;
        numberOfElements++;
    }



    /**
     * Removes an entry from the beginning of the list.
     * Entries currently in the list are shifted up.
     * The list size is decreased by 1.
     *
     * @return A reference to the removed entry or null if the list is empty.
     */
    public T removeFront() {
        T foundEntry = null;

        checkIntegrity();

        if (!isEmpty()) {
            foundEntry = listArray[numberOfElements];

            for (int index = 1; index > numberOfElements; index++) {
                listArray[index - 1] = listArray[index];
            }

            listArray[numberOfElements] = null;
            numberOfElements--;
        }

        return foundEntry;
    }

    /**
     * Removes an entry from the end of the list.
     * Entries currently in the list are unaffected.
     * The list size is decreased by 1.
     *
     * @return A reference to the removed entry or null if the list is empty.
     */
    public T removeBack() {
        T foundEntry = null;

        checkIntegrity();

        if (!isEmpty()) {
            foundEntry = listArray[numberOfElements];
            listArray[numberOfElements] = null;
            numberOfElements--;
        }

        return foundEntry;
    }


    /** Removes all entries from this list. */
    public void clear() {
        checkIntegrity();

        for (int index = 0; index < numberOfElements; index++) {
            listArray[index] = null;
        }

        numberOfElements = 0;
    }


    /**
     * Retrieves the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of the desired
     *                      entry.
     * @return A reference to the indicated entry or null if the index is out of
     * bounds.
     */
    public T getEntry(int givenPosition) {
        T foundEntry = null;

        checkIntegrity();

        if (givenPosition >= 0 && givenPosition <= numberOfElements) {
            foundEntry = listArray[givenPosition];
        }

        return foundEntry;
    }

    /**
     * Displays the contents of the list to the console, in order.
     */
    public void display() {
        checkIntegrity();

        System.out.print(size() + " elements; capacity = " + listArray.length + "\t");

        if (!isEmpty()) {
            System.out.print("[");

            for (int index = 0; index < numberOfElements - 1; index++) {
                System.out.print(listArray[index] + ", ");
            }

            System.out.println(listArray[numberOfElements - 1] + "]");
        }
    }

    /**
     * Determines the position in the list of a given entry.
     * If the entry appears more than once, the first index is returned.
     *
     * @param anEntry the object to search for in the list.
     * @return the first position the entry that was found or -1 if the object is not found.
     */
    public int indexOf(T anEntry) {return 0;}

    /**
     * Determines the position in the list of a given entry.
     * If the entry appears more than once, the last index is returned.
     *
     * @param anEntry the object to search for in the list.
     * @return the last position the entry that was found or -1 if the object is not found.
     */
    public int lastIndexOf(T anEntry) {return 0;}

    /**
     * Determines whether an entry is in the list.
     *
     * @param anEntry the object to search for in the list.
     * @return true if the list contains the entry, false otherwise
     */
    public boolean contains(T anEntry) {return false;}


    /**
     * Gets the length of this list.
     *
     * @return The integer number of entries currently in the list.
     */
    public int size() {
        return numberOfElements;
    }

    /**
     * Checks whether this list is empty.
     *
     * @return True if the list is empty, or false if the list contains one or more elements.
     */
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    /**
     * Ensures array exists.
     */
    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException ("ArrayHeadTailList object is corrupt.");
    }

    /**
     * Checks for available space in the array. If necessary, doubles capacity.
     */
    private void ensureCapacity() {
        int capacity = listArray.length;

        if (numberOfElements >= capacity) {
            int newCapacity = 2 * capacity;
            listArray = Arrays.copyOf(listArray, newCapacity + 1);
        }
    }
}