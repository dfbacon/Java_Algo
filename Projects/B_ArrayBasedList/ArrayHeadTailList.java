import java.util.Arrays;

/**
 * A class that describes a list by implementing an array.
 *
 * @author Daniel Bacon
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
            foundEntry = listArray[0];

            for (int index = 1; index < numberOfElements; index++) {
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