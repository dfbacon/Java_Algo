/**
 * (10 points) Write a second class to implement HeadTailListInterface. (You
 *  also must complete the first class, above!)
 *
 * Instead of using an array, use a List object as your instance data variable.
 * Instantiate the List object to type ArrayList.
 *
 * Inside the methods of this class, invoke methods on the List object to
 *  accomplish the task. Note: some methods might look very simple... this
 *  does not mean they are wrong!
 *
 * There is one difference in how this class will work compared to the other:
 *  in this extra credit class, you do not have control over the capacity, so
 *  you should not print the capacity in display and the capacity does not have to be exactly doubled in the two add methods.
 *
 * For full credit:
 *
 * Pay close attention to what should happen in "failed" conditions as described
 *  by the HeadTailListInterface compared to List!
 *
 * Make sure your ListHeadTailList behaves as described in HeadTailListInterface.
 *
 * Use the methods of the List interface/ArrayList class when possible instead of
 *  re-writing the code yourself.
 */

public class ListHeadTailList<T> implements HeadTailListInterface<T> {
    List<T> list; // initialize to type ArrayList<T> in the ListHeadTailList constructor
}