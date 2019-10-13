/**
 * Use the same nested Node class that is used in LList. I have provided a shell file for you.
 *
 * Note: You must use a head and tail reference! For full credit, do not add any additional instance data variables. In particular, do not add a counter variable! (The purpose of this project is to get more practice with  nodes, not keeping count!)
 *
 * For full credit, implement an efficient solution when possible. All of the methods in the class should be O(1) or O(n). O(n2) methods will not receive full credit.
 *
 * Your class must compile and have the following implemented methods. Follow the API descriptions from the interface file and the additional characteristics listed below. You can choose whether or not to include a constructor.
 *
 * (12 points) addFront(T)
 * (12 points) addBack(T)
 * (12 points) removeFront()
 * (12 points) removeBack()
 * (6 points) contains(T)
 * (6 points) indexOf(T)
 * (6 points) lastIndexOf(T)
 * (6 points) getEntry(int)
 * (4 points) display()
 * see the tester program for the format of the output
 * the output should list the contents plus the value of head and tail (when the list is not empty)
 * (2 points) clear()
 * (2 points) isEmpty()
 * (5 points) size()
 * (15 points) Style and Efficiency
 * Use a head and tail reference.
 * Do not use additional instance data variables other than head and tail.
 * Ensure that methods are O(1) or O(n).
 * Your class should follow Java coding conventions and best practices.
 * Follow naming conventions for variables, classes, and methods.
 * Reduce duplicated code.
 */

public class LinkedHeadTailList<T> implements HeadTailListInterface<T> {

	private Node head, tail;
   
   // YOUR CLASS HERE!


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
