import java.util.*;

public class DequeDriver {

    public static void main (String[] args) {

        DequeInterface<Integer> deque = new ListDeque<Integer>();

        System.out.println("deque is empty, true: " + deque.isEmpty());

        deque.addToFront(3);
        deque.addToFront(2);
        deque.addToFront(1);

        System.out.println("removing 1: " + deque.removeFront());
        System.out.println("removing 2: " + deque.removeFront());
        System.out.println("removing 3: " + deque.removeFront());

        deque.addToFront(3);
        deque.addToFront(2);
        deque.addToFront(1);
        deque.addToBack(4);
        deque.addToBack(5);
        deque.addToBack(6);

        System.out.println("removing 6: " + deque.removeBack());
        System.out.println("removing 5: " + deque.removeBack());
        System.out.println("removing 4: " + deque.removeBack());

        deque.clear();
        System.out.println("removing null: " + deque.removeFront());
        System.out.println("removing null: " + deque.removeBack());
        System.out.println("deque is empty, true: " + deque.isEmpty());
    }
}