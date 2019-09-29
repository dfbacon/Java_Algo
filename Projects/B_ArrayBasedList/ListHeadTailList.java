import java.util.List;
import java.util.ArrayList;

/**
 * A class that describes a list by implementing an ArrayList.
 *
 * @author Daniel Bacon
 */


public class ListHeadTailList<T> implements HeadTailListInterface<T> {
    List<T> list;
    private int numberOfElements;
    private boolean integrityOK;


    public ListHeadTailList(int initialCapacity) {
        integrityOK = false;

        if (initialCapacity < 0) {
            throw new IllegalStateException("Attempt to create a list " +
                    "whose capacity is a negative value.");
        }

        ArrayList<T> tempList = new ArrayList<>(initialCapacity);
        list = tempList;
        numberOfElements = 0;
        integrityOK = true;
    }


    public void addFront(T newEntry) {
        checkIntegrity();

        list.add(0, newEntry);
        numberOfElements++;
    }


    public void addBack(T newEntry) {
        checkIntegrity();

        list.add(newEntry);
        numberOfElements++;
    }


    public T removeFront() {
        checkIntegrity();

        try {
            numberOfElements--;
            return list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }


    public T removeBack() {
        checkIntegrity();

        try {
            numberOfElements--;
            return list.remove(numberOfElements);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }


    public void clear() {
        checkIntegrity();

        list.clear();
        numberOfElements = 0;
    }


    public T getEntry(int givenPosition) {
        checkIntegrity();

        try {
            return list.get(givenPosition);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }


    public void display() {
        checkIntegrity();

        System.out.print(size() + " elements; capacity N/A" + "\t");

        if (!isEmpty()) {
            System.out.print("[");

            for (int index = 0; index < numberOfElements - 1; index++) {
                System.out.print(getEntry(index) + ", ");
            }

            System.out.println(getEntry(numberOfElements - 1) + "]");
        }
    }


    public int indexOf(T anEntry) {
        checkIntegrity();
        return list.indexOf(anEntry);
    }


    public int lastIndexOf(T anEntry){
        checkIntegrity();
        return list.lastIndexOf(anEntry);
    }


    public boolean contains(T anEntry) {
        checkIntegrity();
        return list.contains(anEntry);
    }


    public int size() {
        return numberOfElements;
    }


    public boolean isEmpty() {
        return list.isEmpty();
    }


    /**
     * Ensures array exists.
     */
    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException ("ListHeadTailList object is corrupt.");
    }
}