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
 * (7 points) contains (T)
 * (7 points) indexOf(T)
 * (7 points) lastIndexOf(T)
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


    public void addFront(T newEntry) {
        checkIntegrity();
        ensureCapacity();

        for (int index = numberOfElements; index >= 0; index--) {
            listArray[index + 1] = listArray[index];
        }

        listArray[0] = newEntry;
        numberOfElements++;
    }


    public void addBack(T newEntry) {
        checkIntegrity();
        ensureCapacity();

        listArray[numberOfElements] = newEntry;
        numberOfElements++;
    }


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


    public void clear() {
        checkIntegrity();

        for (int index = 0; index < numberOfElements; index++) {
            listArray[index] = null;
        }

        numberOfElements = 0;
    }


    public T getEntry(int givenPosition) {
        T foundEntry = null;

        checkIntegrity();

        if (givenPosition >= 0 && givenPosition <= numberOfElements) {
            foundEntry = listArray[givenPosition];
        }

        return foundEntry;
    }


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
    public int indexOf(T anEntry) {
        int foundIndex = -1;

        if (!isEmpty()) {
            for (int index = 0; index < numberOfElements; index++) {
                if (getEntry(index).equals(anEntry)) {
                    foundIndex = index;
                    index = numberOfElements;
                }
            }
        }

        return foundIndex;
    }

    
    public int lastIndexOf(T anEntry) {
        int foundIndex = -1;

        checkIntegrity();
        if (!isEmpty()) {
            for (int forward = 0, backward = numberOfElements - 1;
                 forward <= backward; forward++, backward--) {

                if (listArray[backward].equals(anEntry)) {
                    foundIndex = backward;
                    backward = forward - 1;
                } else if (listArray[forward].equals(anEntry)) {
                    foundIndex = forward;
                }
            }
        }

        return foundIndex;
    }

    /**
     * Determines whether an entry is in the list.
     *
     * @param anEntry the object to search for in the list.
     * @return true if the list contains the entry, false otherwise
     */
    public boolean contains(T anEntry) {
        if (indexOf(anEntry) == -1) {
            return false;
        }
        else {
            return true;
        }
    }


    public int size() {
        return numberOfElements;
    }


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
        int newCapacity;

        if (numberOfElements >= capacity) {
            newCapacity = 2 * capacity;
            listArray = Arrays.copyOf(listArray, newCapacity);
        }
    }
}