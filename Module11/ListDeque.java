import java.util.*;

public class ListDeque<T> implements DequeInterface<T> {

    private List<T> list;
    private Node firstNode, lastNode;


    public ListDeque() {

        firstNode = null;
        lastNode = null;
    }


    public void addToFront(T newEntry) {

        Node newNode = new Node(newEntry, null, null);

        if (isEmpty()) {

            lastNode = newNode;
        }
        else {

            newNode.setNextNode(firstNode);
            firstNode.setPreviousNode(newNode);
        }

        firstNode = newNode;
    }


    public void addToBack(T newEntry) {

        Node newNode = new Node(newEntry, null, null);

        if (isEmpty()) {

            firstNode = newNode;
        }
        else {

            lastNode.setNextNode(newNode);
            newNode.setPreviousNode(lastNode);
        }

        lastNode = newNode;
    }


    public T removeFront() {

        T front = getFront();

        if (front != null) {

            firstNode.setData(null);
            firstNode = firstNode.getNextNode();

            if (firstNode != null) {

                firstNode.previous.setNextNode(null);
                firstNode.setPreviousNode(null);
            } else {

                lastNode = null;
            }
        }

        return front;
    }


    public T removeBack() {

        T back = getBack();

        if (back != null) {

            lastNode.setData(null);
            lastNode = lastNode.getPreviousNode();

            if (lastNode != null) {

                lastNode.next.setPreviousNode(null);
                lastNode.setNextNode(null);
            } else {

                firstNode = null;
            }
        }

        return back;
    }


    public T getFront() {

        return isEmpty() ? null : firstNode.getData();
    }


    public T getBack() {

        return isEmpty() ? null : lastNode.getData();
    }


    public boolean isEmpty() {

        return firstNode == null && lastNode == null;
    }


    public void clear() {

        firstNode = null;
        lastNode = null;
    }


    public class Node {

        public T data;
        public Node next;
        public Node previous;


        private Node(T dataPortion) {

            data = dataPortion;
            next = null;
            previous = null;
        }


        private Node(T dataPortion, Node nextLink, Node previousLink) {

            data = dataPortion;
            next = nextLink;
            previous = previousLink;
        }


        private T getData() {
            return data;
        }


        private void setData(T newData) {
            data = newData;
        }


        private Node getNextNode() {
            return next;
        }


        private Node getPreviousNode() {
            return previous;
        }


        private void setNextNode(Node nextNode) {
            next = nextNode;
        }


        private void setPreviousNode(Node previousNode) {
            previous = previousNode;
        }
    }
}