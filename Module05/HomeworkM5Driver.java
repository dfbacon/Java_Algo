import java.util.Arrays;

public class HomeworkM5Driver {

	public static void main(String[] args) {

//		System.out.println("\n******TESTING QUESTION: PRINT AT INTERVAL");
//		Node<Integer> firstNode = new Node<Integer>(Integer.valueOf(3), new Node<Integer>(Integer.valueOf(8), new Node<Integer>(Integer.valueOf(6), new Node<Integer>(Integer.valueOf(12)))));
//		// sets up the chain 3 -> 8 -> 6 -> 12
//		System.out.println("Should print \n3 6");
//		printAtInterval(firstNode, 2);
//		System.out.println();
//
//		System.out.println("Should print \n3 12");
//		printAtInterval(firstNode, 3);
//		System.out.println();
//
//		firstNode = new Node<Integer>(Integer.valueOf(2), new Node<Integer>(Integer.valueOf(8),	new Node<Integer>(Integer.valueOf(10), new Node<Integer>(Integer.valueOf(4), new Node<Integer>(Integer.valueOf(3))))));
//		// sets up the chain 2 -> 8 -> 10 -> 4 -> 3
//		System.out.println("Should print \n2 10 3");
//		printAtInterval(firstNode, 2);
//		System.out.println();
//
//		firstNode = new Node<Integer>(Integer.valueOf(3), new Node<Integer>(Integer.valueOf(8), new Node<Integer>(Integer.valueOf(6), new Node<Integer>(Integer.valueOf(12), new Node<Integer>(Integer.valueOf(2), new Node<Integer>(Integer.valueOf(4), new Node<Integer>(Integer.valueOf(1), new Node<Integer>(Integer.valueOf(5)))))))));
//		// sets up the chain 3 -> 8 -> 6 -> 12 -> 2 -> 4 -> 1 ->5
//		System.out.println("Should print \n3 12 1");
//		printAtInterval(firstNode, 3);
//		System.out.println();
//
//		firstNode = new Node<Integer>(Integer.valueOf(3), new Node<Integer>(Integer.valueOf(8), new Node<Integer>(Integer.valueOf(6), new Node<Integer>(Integer.valueOf(12)))));
//		// sets up the chain 3 -> 8 -> 6 -> 12
//		System.out.println("Should print \n3");
//		printAtInterval(firstNode, 5);
//		System.out.println();
//
//		firstNode = null; // empty chain
//		System.out.println("Should print nothing (and not crash)");
//		printAtInterval(firstNode, 5);
//		System.out.println();
//
//		firstNode = new Node<Integer>(Integer.valueOf(3)); // singleton chain
//		System.out.println("Should print \n3");
//		printAtInterval(firstNode, 5);
//		System.out.println();
//
//
//		System.out.println("\n******TESTING QUESTION: LINKED BAG REMOVE ALL");
//		LinkedBag<Integer> numberBag = new LinkedBag<Integer>();
//
//		// testing on empty bag
//		System.out.println("Before removing 1, the bag contains " + Arrays.toString(numberBag.toArray()));
//		numberBag.removeAll(1);
//		System.out.println("After, the bag contains\n[]  \n" + Arrays.toString(numberBag.toArray()) +  "\nSize is 0: " + numberBag.getCurrentSize() +"\n");
//
//		// testing on singleton bag
//		numberBag.add(1);
//		System.out.println("Before removing 1, the bag contains " + Arrays.toString(numberBag.toArray()) );
//		numberBag.removeAll(1);
//		System.out.println("After, the bag contains\n[]  \n" + Arrays.toString(numberBag.toArray()) +  "\nSize is 0: " + numberBag.getCurrentSize()+"\n");
//		numberBag.add(1);
//		numberBag.add(1);
//		numberBag.add(1);
//
//		// testing on bag with all matches
//		System.out.println("Before removing 1, the bag contains " + Arrays.toString(numberBag.toArray()));
//		numberBag.removeAll(1);
//		System.out.println("After, the bag contains\n[]  \n" + Arrays.toString(numberBag.toArray()) +  "\nSize is 0: " + numberBag.getCurrentSize()+"\n");
//
//		// testing on bag with some matches
//		numberBag.add(1);
//		numberBag.add(1);
//		numberBag.add(2);
//		numberBag.add(4);
//		numberBag.add(1);
//		numberBag.add(5);
//		numberBag.add(1);
//		System.out.println("Before removing 1, the bag contains " + Arrays.toString(numberBag.toArray()) );
//		numberBag.removeAll(1);
//		// NOTE: this code is only here so that the results will be sorted so you can directly compare to what they should be
//		// don't worry too much about this, it's not part of what we're looking at this week!
//		//Comparable[] comparableResult = (Comparable[])numberBag.toArray();
//		Integer[] result = Arrays.copyOf(((Comparable[])numberBag.toArray()),numberBag.getCurrentSize(), Integer[].class);
//		Arrays.sort(result);
//		System.out.println("After, the bag contains\n[2, 4, 5] \n" + Arrays.toString(result) +  "\nSize is 3: " + numberBag.getCurrentSize()+"\n");
//
//		// testing on bag with some matches
//		numberBag.clear();
//		numberBag.add(1);
//		numberBag.add(1);
//		numberBag.add(3);
//		numberBag.add(1);
//		numberBag.add(1);
//		numberBag.add(4);
//		numberBag.add(1);
//		numberBag.add(5);
//		numberBag.add(1);
//		numberBag.add(1);
//		System.out.println("Before removing 1, the bag contains " + Arrays.toString(numberBag.toArray()));
//		numberBag.removeAll(1);
//		result = Arrays.copyOf(((Comparable[])numberBag.toArray()),numberBag.getCurrentSize(), Integer[].class);
//		Arrays.sort(result);
//		System.out.println("After, the bag contains\n[3, 4, 5] \n" + Arrays.toString(result) +  "\nSize is 3: " + numberBag.getCurrentSize()+"\n");
//
//		// testing on bag with some matches
//		System.out.println("Before removing 5, the bag contains " + Arrays.toString(numberBag.toArray()) );
//		numberBag.removeAll(5);
//		result = Arrays.copyOf(((Comparable[])numberBag.toArray()),numberBag.getCurrentSize(), Integer[].class);
//		Arrays.sort(result);
//		System.out.println("After, the bag contains\n[3, 4] \n" + Arrays.toString(result) +  "\nSize is 2: " + numberBag.getCurrentSize()+"\n");
//
//		// testing on bag with some matches
//		numberBag.add(4);
//		numberBag.add(5);
//		System.out.println("Before removing 4, the bag contains " + Arrays.toString(numberBag.toArray()) );
//		numberBag.removeAll(4);
//		result = Arrays.copyOf(((Comparable[])numberBag.toArray()),numberBag.getCurrentSize(), Integer[].class);
//		Arrays.sort(result);
//		System.out.println("After, the bag contains\n[3, 5] \n" + Arrays.toString(result) +  "\nSize is 2: " + numberBag.getCurrentSize()+"\n");
//
//		// testing on bag with no matches
//		System.out.println("Before removing 7, the bag contains " + Arrays.toString(numberBag.toArray()) );
//		numberBag.removeAll(7);
//		result = Arrays.copyOf(((Comparable[])numberBag.toArray()),numberBag.getCurrentSize(), Integer[].class);
//		Arrays.sort(result);
//		System.out.println("After, the bag contains\n[3, 5] \n" + Arrays.toString(result) +  "\nSize is 2: " + numberBag.getCurrentSize()+"\n");
//
//
//		System.out.println("\n******TESTING QUESTION: LLIST GET MAX");
//		LList<Integer> numbersList = new LList<Integer>();
//
//		// testing max in the middle
//		numbersList.add(1);
//		numbersList.add(2);
//		numbersList.add(1);
//		numbersList.add(4);
//		numbersList.add(3);
//		System.out.println("The max in the list is 4: " + numbersList.getMax());
//
//		// testing duplicate max
//		numbersList.add(4);
//		System.out.println("The max in the list is 4: " + numbersList.getMax());
//
//		// testing max at the end
//		numbersList.add(5);
//		System.out.println("The max in the list is 5: " + numbersList.getMax());
//
//		// testing max at the beginning
//		numbersList.add(1, 7);
//		System.out.println("The max in the list is 7: " + numbersList.getMax());
//
//		// testing singleton
//		numbersList.clear();
//		numbersList.add(1);
//		System.out.println("The max in the list is 1: " + numbersList.getMax());
//
//		// testing empty list
//		numbersList.clear();
//		System.out.println("Should either print null or throw an exception- but NOT a Null Pointer Exception");
//		System.out.println(numbersList.getMax());
//
//
//
//		System.out.println("\n******TESTING QUESTION: LLIST ADD ALL");
//		LList<String> produceList = new LList<String>();
//		produceList.addAll(new String[]{"peach"});
//		System.out.println("The list contains[peach] \n\t\t " + Arrays.toString(produceList.toArray()));
//		String[] stringArray = { "banana", "date", "grape", "eggplant",	"jicama", "grape" };
//		produceList.addAll(stringArray);
//		System.out.println("The list contains[peach, banana, date, grape, eggplant, jicama, grape] \n\t\t "
//						+ Arrays.toString(produceList.toArray()));
//		System.out.println("Size is 7: " + produceList.getLength());
//		produceList.addAll(new String[] {});
//		System.out.println("The list contains[peach, banana, date, grape, eggplant, jicama, grape] \n\t\t "
//				+ Arrays.toString(produceList.toArray()));
//		System.out.println("Size is 7: " + produceList.getLength());

		System.out.println("\n******TESTING QUESTION EXTRA CREDIT: DOUBLE NODE PALINDROME");
		DoubleNode<Integer> n3 = new DoubleNode<Integer>(4);
		DoubleNode<Integer> n2 = new DoubleNode<Integer>(3);
		DoubleNode<Integer> n1 = new DoubleNode<Integer>(4);
		n1.next = n2;
		n2.next = n3;
		n2.previous = n1;
		n3.previous = n2;
		// sets up the chain 4->3-> 4
		System.out.println("Should print true: " + isDoublyLinkedPalindromeList(n1, n3));

		DoubleNode<Integer> n4 = new DoubleNode<Integer>(4);
		n3 = new DoubleNode<Integer>(3);
		n2 = new DoubleNode<Integer>(3);
		n1 = new DoubleNode<Integer>(4);
		n1.next = n2;
		n2.next = n3;
		n2.previous = n1;
		n3.next = n4;
		n3.previous = n2;
		n4.previous = n3;
		// sets up the chain 4->3->-3->4
		System.out.println("Should print true: " + isDoublyLinkedPalindromeList(n1, n4));

		n4 = new DoubleNode<Integer>(1);
		n3 = new DoubleNode<Integer>(2);
		n2 = new DoubleNode<Integer>(3);
		n1 = new DoubleNode<Integer>(1);
		n1.next = n2;
		n2.next = n3;
		n2.previous = n1;
		n3.next = n4;
		n3.previous = n2;
		n4.previous = n3;
		// sets up the chain 1->3->-2->1
		System.out.println("Should print false: " + isDoublyLinkedPalindromeList(n1, n4));

		n4 = new DoubleNode<Integer>(4);
		n3 = new DoubleNode<Integer>(3);
		n2 = new DoubleNode<Integer>(4);
		n1 = new DoubleNode<Integer>(3);
		n1.next = n2;
		n2.next = n3;
		n2.previous = n1;
		n3.next = n4;
		n3.previous = n2;
		n4.previous = n3;
		// sets up the chain 3->4->-3->4
		System.out.println("Should print false: " + isDoublyLinkedPalindromeList(n1, n4));

		n1 = new DoubleNode<Integer>(3);
		// sets up the chain 3
		System.out.println("Should print true and not crash: " + isDoublyLinkedPalindromeList(n1, n1));

		n1 = null;
		System.out.println("Should print true and not crash: " + isDoublyLinkedPalindromeList(n1, n1));

	}

	/*
            Write a method to print the values at a given interval in a chain of
            integers, starting with the first node. The chain passed in should not
            be altered outside the method.
    */
	public static void printAtInterval(Node<Integer> firstNode, int interval) {
		if (firstNode != null && interval > 0) {
			Node nodePtr = firstNode;
			int counter = 0;

			while (nodePtr.getNextNode() != null) {
				if (counter % interval == 0) {
					System.out.printf("%d ", nodePtr.getData());
				}

				counter++;
				nodePtr = nodePtr.getNextNode();
			}

			if (counter % interval == 0) {
				System.out.print(nodePtr.getData());
			}

			System.out.println();
		}
	}

	/*
		Write a method to determine if a doubly-linked list is a "palindrome
		list"- meaning that the list contains equivalent elements front-to-back
		and back-to-front.
	 */
	public static boolean isDoublyLinkedPalindromeList(DoubleNode<Integer> firstNode, DoubleNode<Integer> lastNode)  {
		boolean isPalindrome = true;

		if (firstNode != null && lastNode != null) {
			DoubleNode forwardRunner = firstNode;
			DoubleNode backwardRunner = lastNode;

			while (forwardRunner.next != backwardRunner.previous) {
				if (!forwardRunner.data.equals(backwardRunner.data)) {
					isPalindrome = false;
				}

				forwardRunner = forwardRunner.next;
				backwardRunner = backwardRunner.previous;
			}
		}

		return isPalindrome;
	}

}
