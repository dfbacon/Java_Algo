/**
 * Describes a Trio data structure that holds a group of three items.
 */
public class Trio<T> {

    static final int MAX_NUMBER_ITEMS = 3;

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
        return item1.toString() + "\t" + item2.toString() + "\t" +
                item3.toString();
    }


    // (20 points) an equals method that overrides the equals method of the Object class.
    //    The method returns true if the current Trio holds the same (logically equivalent) three items in any order as the
    //    Trio sent as a parameter and false otherwise.
    //    The equals method should not alter either the current Trio object or the Trio object passed in as a parameter.
    @Override
    public boolean equals(Object other) {
        if (other instanceof Trio<?>) {
            Trio<?> otherTrio = (Trio<?>) other;

            boolean sameItem1 = item1.equals(otherTrio.item1) ||
                    item1.equals(otherTrio.item2) || item1.equals(otherTrio.item3);
            boolean sameItem2 = item2.equals(otherTrio.item1) ||
                    item2.equals(otherTrio.item2) || item2.equals(otherTrio.item3);
            boolean sameItem3 = item3.equals(otherTrio.item1) ||
                    item3.equals(otherTrio.item2) || item3.equals(otherTrio.item3);

            return sameItem1 && sameItem2 && sameItem3;
        }

        return false;
    }


    public void reset(T item) {
        this.setItem1(item);
        this.setItem2(item);
        this.setItem3(item);
    }

    //(15 points) a method called count that returns a count of how many times an item is in the Trio
    public int count() {
        if (item1.equals(item2) && item1.equals(item3))
            return MAX_NUMBER_ITEMS;
        else if (this.hasDuplicates())
            return MAX_NUMBER_ITEMS - 1;
        else
            return 1;
    }



    // (15 points) a method called hasDuplicates that returns true if the at least two items within the Trio are the same as
    //    each other.
    //        Note this does not determine duplicates based on whether any of the items are aliases, but whether any of the
    //            items are equal- logically equivalent to each other.
    public boolean hasDuplicates() {
        if (item1.equals(item2) || item1.equals(item3) || item2.equals(item3))
            return true;
        else
            return false;
    }



}