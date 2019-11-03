import java.util.*;
import java.lang.Math;

public class ExamTester {

	public static void main(String[] args) {
//		System.out.println("***** TESTING LINKEDBAG DUPLICATE METHOD *****");
//		// duplicate 1, 2, 3
		LinkedBag<Integer> bag1 = new LinkedBag<Integer>();
//		bag1.add(1); 		bag1.add(2); 		bag1.add(3);
//		bag1.duplicateContents();
		Integer[] results = getSortedResults(bag1.toArray());
//		System.out.println("Should print\n[1, 1, 2, 2, 3, 3]\n" + Arrays.toString(results));
//
//		// duplicate 1, 1, 2, 2, 3, 3
//		bag1.duplicateContents();
//		results = getSortedResults(bag1.toArray());
//		System.out.println("Should print\n[1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]\n" + Arrays.toString(results));
//
//		// duplicate an empty bag
//		bag1.clear();
//		bag1.duplicateContents();
//		results = getSortedResults(bag1.toArray());
//		System.out.println("Should print\n[]\n" + Arrays.toString(results));
//
//		// duplicate a singleton bag
//		bag1.add(4);
//		bag1.duplicateContents();
//		results = getSortedResults(bag1.toArray());
//		System.out.println("Should print\n[4, 4]\n" + Arrays.toString(results));
//
		System.out.println("\n***** TESTING LISTINTERFACE CLIENT ROTATE METHOD *****");
		// rotate 1, 2, 3, 4, 5, 6 by 3
		ListInterface<Integer> list1 = new AList<Integer>();
		list1.add(1); list1.add(2);	list1.add(3); list1.add(4); list1.add(5); list1.add(6);
		rotate(list1, 3);
		results = getResults(list1.toArray());
		System.out.println("Should print\n[4, 5, 6, 1, 2, 3]\n" + Arrays.toString(results));

		// rotate an empty list
		list1.clear();
		rotate(list1, 5);
		results = getResults(list1.toArray());
		System.out.println("Should print\n[]\n" + Arrays.toString(results));

		// rotate 1, 2, 3, 4, 5, 6 by 10
		list1.clear();
		list1.add(1); list1.add(2);	list1.add(3); list1.add(4); list1.add(5); list1.add(6);
		rotate(list1, 10);
		results = getResults(list1.toArray());
		System.out.println("Should print\n[3, 4, 5, 6, 1, 2]\n" + Arrays.toString(results));

		// rotate 1, 2, 3, 4, 5 by -4
		list1.clear();
		list1.add(1); list1.add(2);	list1.add(3); list1.add(4); list1.add(5);
		rotate(list1, -4);
		results = getResults(list1.toArray());
		System.out.println("Should print\n[5, 1, 2, 3, 4]\n" + Arrays.toString(results));

		// rotate an object initialized with LList instead of AList
		ListInterface<Integer> list2 = new LList<Integer>();
		list2.add(1); list2.add(2);	list2.add(3); list2.add(4); list2.add(5); list2.add(6);
		rotate(list2, 3);
		results = getResults(list2.toArray());
		System.out.println("Should print\n[4, 5, 6, 1, 2, 3]\n" + Arrays.toString(results));

//
//		System.out.println("\n***** TESTING ALIST ADDTOFRONT METHOD *****");
//		// add chain 10, 11, 12 to the front of list 1, 2, 3, 4, 5
//		AList<Integer> list3 = new AList<Integer>();
//		list3.add(1); list3.add(2); list3.add(3); list3.add(4); list3.add(5);
//		ANode<Integer> chainToAdd1 = new ANode<Integer>(10, new ANode<Integer>(11, new ANode<Integer>(12)));
//		list3.addToFront(chainToAdd1);
//		results = getResults(list3.toArray());
//		System.out.println("Should print\n[10, 11, 12, 1, 2, 3, 4, 5]\n" + Arrays.toString(results));
//
//		// add chain 10, 11, 12, 13 to the front of list 1, 2, 3, 4
//		list3.clear();
//		list3.add(1); list3.add(2); list3.add(3); list3.add(4);
//		chainToAdd1 = new ANode<Integer>(10, new ANode<Integer>(11, new ANode<Integer>(12, new ANode<Integer>(13))));
//		list3.addToFront(chainToAdd1);
//		results = getResults(list3.toArray());
//		System.out.println("Should print\n[10, 11, 12, 13, 1, 2, 3, 4]\n" + Arrays.toString(results));
//
//		// add chain 10, 11, 12, 13 to empty list
//		list3.clear();
//		chainToAdd1 = new ANode<Integer>(10, new ANode<Integer>(11, new ANode<Integer>(12, new ANode<Integer>(13))));
//		list3.addToFront(chainToAdd1);
//		results = getResults(list3.toArray());
//		System.out.println("Should print\n[10, 11, 12, 13]\n" + Arrays.toString(results));
//
//		// add empty chain to list 1, 2, 3, 4
//		list3.clear();
//		list3.add(1); list3.add(2); list3.add(3); list3.add(4);
//		chainToAdd1 = null;
//		list3.addToFront(chainToAdd1);
//		results = getResults(list3.toArray());
//		System.out.println("Should print\n[1, 2, 3, 4]\n" + Arrays.toString(results));
//
//		// add empty chain to empty list
//		list3.clear();
//		chainToAdd1 = null;
//		list3.addToFront(chainToAdd1);
//		results = getResults(list3.toArray());
//		System.out.println("Should print\n[]\n" + Arrays.toString(results));

	}


	/*
	In other words, if the oldIndex of the element is x, after the rotation the
	newIndex of the element is (x + distance) % size.
	 */
	public static void rotate(ListInterface<Integer> list, int distance) {

		// requires java.lang.Math for abs()

		if (!list.isEmpty() && distance != 0) {

			int d = distance;
			int currentValue;

			while (Math.abs(d) > list.getLength()) {

				d %= list.getLength();
			}

			if (d > 0) {
				for (int index = 0; index < d; index++) {

					currentValue = list.remove(list.getLength());
					list.add(1, currentValue);
				}
			}
			else {

				for (int index = d; index < 0; index++) {

					currentValue = list.remove(1);
					list.add(currentValue);
				}
			}
		}
	}

	/*
	 * don't worry about these methods- they are just here so that the generics work
	 * correctly and we can print results for comparison!
	 */
	private static Integer[] getSortedResults(Object[] array) {
		return getResults(array, true);
	}

	private static Integer[] getResults(Object[] array) {
		return getResults(array, false);
	}

	private static Integer[] getResults(Object[] array, boolean sorted) {
		Integer[] results = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			results[i] = (Integer) array[i];
		}
		if (sorted) {
			Arrays.sort(results);
		}
		return results;

	}

}
