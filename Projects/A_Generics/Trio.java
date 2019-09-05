/**
 Your class must compile, use generics, and have the following:

 (10 points) two constructors:
    a second constructor takes in a single item and the Trio will then consist of three of these items
    for full credit, reduce duplicated code in the constructors and follow best practices for overloading constructors.

 (5 points) getters and setters for each item in the trio

 (5 points) a toString method that returns a text representation of the trio

 (10 points) a method called reset that takes in one item as a parameter and modifies the Trio to hold three copies of
    that item

 (15 points) a method called count that returns a count of how many times an item is in the Trio

 (15 points) a method called hasDuplicates that returns true if the at least two items within the Trio are the same as
    each other.
        Note this does not determine duplicates based on whether any of the items are aliases, but whether any of the
            items are equal- logically equivalent to each other.

 (20 points) an equals method that overrides the equals method of the Object class.
    The method returns true if the current Trio holds the same (logically equivalent) three items in any order as the
    Trio sent as a parameter and false otherwise.
    The equals method should not alter either the current Trio object or the Trio object passed in as a parameter.
    Be sure to test your method with different cases, particularly cases where the Trios have duplicate items!

 (10 points) Style: Your class should follow Java coding conventions and best practices. Follow naming conventions for variables, classes, and methods. Reduce duplicated code.
 */
public class Trio<T> {
    /**
     *  A Trio is a class representing a data structure that holds a group of three items. A Trio object has the following
     *  characteristics:
     *
     *     Trios hold three items of the same type.
     *         For example, a Trio could hold three Integers or it could hold three Strings or it could hold three Students,
     *         etc. A Trio could not, however, hold two Integers and a String.
     *     A Trio can contain duplicates.
     *     A Trio's items are unordered.
     *     The order doesn't matter. (This is like a set in mathematics. A Trio is different from a set, however, because a
     *      Trio can contain duplicates.)
     *         For example, the Trio (3, 4, 5) is considered the same as the Trio (4, 5, 3) and the Trio ("hi", "bye",
     *          "hello") is considered the same as the Trio ("hello", "hi", "bye").
     */
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
        return item1.toString() + "\t" + item2.toString() + "\t" + item3.toString();
    }


}