/**
 * A class that describes a list made up of linked nodes.
 *
 * @author Daniel Bacon
 */
public class LinkedHeadTailList<T extends Comparable<? super T>> implements
		HeadTailListInterface<T>, Comparable<LinkedHeadTailList<T>> {

	private Node head, tail;


	public LinkedHeadTailList() {
		head = null;
		tail = null;
	}



	public void addFront(T newEntry) {
		Node newNode = new Node(newEntry);

		if (isEmpty()) {
			head = newNode;
			tail = head;
		}
		else {
			newNode.setNextNode(head);
			head = newNode;
		}
	}


	public void addBack(T newEntry) {
		Node newNode = new Node(newEntry);

		if (isEmpty()) {
			head = newNode;
			tail = head;
		}
		else {
			tail.setNextNode(newNode);
			tail = newNode;
		}
	}


	public T removeFront() {
		Node tempNode = head;

		if (!isEmpty()) {
			if (size() > 1) {
				head = head.getNextNode();
				tempNode.setNextNode(null);
			}
			else {
				head = null;
				tail = null;
			}

			return tempNode.getData();
		}

		return null;
	}


	public T removeBack() {
		Node tempNode = head;

		if (!isEmpty()) {
			if (size() > 1) {
				while (tempNode.getNextNode() != tail) {
					tempNode = tempNode.getNextNode();
				}

				tail = tempNode;
				tempNode = tempNode.getNextNode();
				tail.setNextNode(null);
			}
			else {
				head = null;
				tail = null;
			}

			return tempNode.getData();
		}

		return null;
	}


	public void clear() {
		if (!isEmpty()) {
			Node tempNode = head;

			while (tempNode.getNextNode() != null) {
				head = head.getNextNode();

				tempNode.setData(null);
				tempNode.setNextNode(null);
				tempNode = head;
			}

			tempNode.setData(null);
			tempNode = null;
			head = null;
			tail = null;
		}
	}


	public T getEntry(int givenPosition) {
		Node target = head;

		if (givenPosition < 0) {
			return null;
		}

		for (int index = 0; index < givenPosition; index++) {
			if (target.getNextNode() != null) {
				target = target.getNextNode();
			}
			else {
				return null;
			}
		}

		return target.getData();
	}



	public void display() {
		Node currentNode = head;

		System.out.print("[");

		while (currentNode != null) {
			System.out.print(currentNode.getData());

			if (currentNode.getNextNode() != null) {
				System.out.print(", ");
			}

			currentNode = currentNode.getNextNode();
		}

		System.out.print("]");

		if (!isEmpty()) {
			System.out.println("\thead=" + head.getData() + " tail=" + tail.getData());
		}
	}


	public int indexOf(T anEntry) {
		Node currentNode = head;
		int index = 0;

		while (currentNode != null) {
			if (currentNode.getData().equals(anEntry)) {
				return index;
			}

			index++;
			currentNode = currentNode.getNextNode();
		}

		return -1;
	}


	public int lastIndexOf(T anEntry) {
		Node currentNode = head;
		int index = 0;
		int firstFound = -1, lastFound = -1;


		while (currentNode != null) {
			if (currentNode.getData().equals(anEntry)) {
				if (firstFound == -1) {
					firstFound = index;
				}
				else {
					lastFound = index;
				}
			}

			index++;
			currentNode = currentNode.getNextNode();
		}

		if (firstFound != -1) {
			if (lastFound > firstFound) {
				return lastFound;
			}
		}

		return firstFound;
	}


	public boolean contains(T anEntry) {
		Node currentNode = head;

		if (!isEmpty()) {
			while (currentNode != null) {
				if (currentNode.getData().equals(anEntry)) {
					return true;
				}

				currentNode = currentNode.getNextNode();
			}
		}

		return false;
	}


	public int size() {
		Node tempNode = head;
		int count = 0;

		while (tempNode != null) {
			count++;
			tempNode = tempNode.getNextNode();
		}

		return count;
	}


	public boolean isEmpty() {
		if (head == null) {
			return true;
		}

		return false;
	}


	/**
	 * Compares two LinkedHeadTailList objects in the following manner.
	 * 	- Compare the lists element-by-element.
	 * 	- The first time you find an element that doesn't match, compare the
	 * 		lists based on that element.
	 *	- If you do not find any mismatched elements and reach the end of one
	 *		or both lists, compare based on size (shorter list is smaller).
	 *
	 * @param otherList The other LinkedHeadTailList object.
	 * @return A negative value if the calling object is less than the other
	 * 	object, a positive value if the opposite is true, or zero if they are
	 * 	the same.
	 */
	@Override
	public int compareTo(LinkedHeadTailList<T> otherList) {
		Node currentNode = this.head;
		Node otherCurrentNode = otherList.head;

		while (currentNode != null && otherCurrentNode != null) {
			if (!currentNode.getData().equals(otherCurrentNode.getData())) {
				return currentNode.getData().compareTo(otherCurrentNode.getData());
			}

			currentNode = currentNode.getNextNode();
			otherCurrentNode = otherCurrentNode.getNextNode();
		}

		return this.size() - otherList.size();
	}


	private class Node {
		private T data; 
		private Node next; 

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
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

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} 
	} 
}
