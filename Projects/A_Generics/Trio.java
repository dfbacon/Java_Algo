import java.util.*;

/**
 * Describes a Trio data structure that holds a group of three items.
 */
public class Trio<T> {

    private T item1, item2, item3;



    public Trio(T item1, T item2, T item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public Trio(T item) {
        this(item, item, item);
    }

    public T getItem1() {
        return item1;
    }

    public T getItem2() {
        return item2;
    }

    public T getItem3() {
        return item3;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public void setItem2(T item2) {
        this.item2 = item2;
    }

    public void setItem3(T item3) {
        this.item3 = item3;
    }



    @Override
    public String toString() {
        return item1.toString() + ", " + item2.toString() + ", " +
                item3.toString();
    }



    @Override
    public boolean equals(Object other) {
        if (other instanceof Trio<?>) {

            Trio<?> otherTrio = (Trio<?>) other;

            ArrayList<T> itemsCheckList = new ArrayList<>();
            itemsCheckList.add(item1);
            itemsCheckList.add(item2);
            itemsCheckList.add(item3);

            if (itemsCheckList.contains(otherTrio.item1))
                itemsCheckList.remove(otherTrio.item1);

            if (itemsCheckList.contains(otherTrio.item2))
                itemsCheckList.remove(otherTrio.item2);

            if (itemsCheckList.contains(otherTrio.item3))
                itemsCheckList.remove(otherTrio.item3);

            return itemsCheckList.isEmpty();
        }

        return false;
    }



    public void reset(T item) {
        this.setItem1(item);
        this.setItem2(item);
        this.setItem3(item);
    }



    public int count(T item) {
        int itemCount = 0;

        if (item1.equals(item))
            itemCount++;

        if (item2.equals(item))
            itemCount++;

        if (item3.equals(item))
            itemCount++;

        return itemCount;
    }



    public boolean hasDuplicates() {
        return item1.equals(item2) || item1.equals(item3) || item2.equals(item3);
    }
}