import java.util.*;

public class ListDeque<T> implements DequeInterface<T> {

    private List<T> list;


    public ListDeque() {

        list = new ArrayList<>();
    }


    public void addToFront(T newEntry) {

        list.add(0, newEntry);
    }


    public void addToBack(T newEntry) {

        list.add(newEntry);
    }


    public T removeFront() {

        if (list.isEmpty()) {

            return null;
        }
        else {

            return list.remove(0);
        }
    }


    public T removeBack() {

        if (list.isEmpty()) {

            return null;
        }
        else {

            return list.remove(list.size() - 1);
        }
    }


    public T getFront() {

        if (list.isEmpty()) {

            return null;
        }
        else {

            return list.get(0);
        }
    }


    public T getBack() {

        if (list.isEmpty()) {

            return null;
        }
        else {

            return list.get(list.size() - 1);
        }
    }


    public boolean isEmpty() {

        return list.isEmpty();
    }


    public void clear() {

        list.clear();
    }
}