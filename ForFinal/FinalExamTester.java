import java.util.*;

public class FinalExamTester {

	public static void main(String[] args) {

		System.out.println("***** TESTING LINKED QUEUE CONSECUTIVE DUPLICATES *****");
		LinkedQueue<Integer> numberQ = new LinkedQueue<Integer>();
		boolean consecutiveDups = numberQ.hasConsecutiveDuplicates();
		System.out.println("front [] back should be \tfalse:" + consecutiveDups);

		numberQ.enqueue(3);
		consecutiveDups = numberQ.hasConsecutiveDuplicates();
		System.out.println("front [3] back should be \tfalse:" + consecutiveDups);

		numberQ.clear(); numberQ.enqueue(1); numberQ.enqueue(2);
		consecutiveDups = numberQ.hasConsecutiveDuplicates();
		System.out.println("front [1, 2] back should be \tfalse:" + consecutiveDups);

		numberQ.enqueue(1);
		consecutiveDups = numberQ.hasConsecutiveDuplicates();
		System.out.println("front [1, 2, 1] back should be \tfalse:" + consecutiveDups);

		numberQ.enqueue(4); numberQ.enqueue(4);
		consecutiveDups = numberQ.hasConsecutiveDuplicates();
		System.out.println("front [1, 2, 1, 4, 4] back should be \ttrue:" + consecutiveDups);

		numberQ.clear(); numberQ.enqueue(3);numberQ.enqueue(3);
		consecutiveDups = numberQ.hasConsecutiveDuplicates();
		System.out.println("front [3, 3] back should be \t\ttrue:" + consecutiveDups);

		numberQ.clear(); numberQ.enqueue(5); numberQ.enqueue(5); numberQ.enqueue(3);
		consecutiveDups = numberQ.hasConsecutiveDuplicates();
		System.out.println("front [5, 5, 3] back should be \t\ttrue:" + consecutiveDups);

		numberQ.clear(); numberQ.enqueue(3);numberQ.enqueue(3); numberQ.enqueue(5);numberQ.enqueue(3);
		consecutiveDups = numberQ.hasConsecutiveDuplicates();
		System.out.println("front [3, 3, 5, 3] back should be \ttrue:" + consecutiveDups);

		numberQ.clear(); numberQ.enqueue(1);numberQ.enqueue(2); numberQ.enqueue(5);numberQ.enqueue(5);
		consecutiveDups = numberQ.hasConsecutiveDuplicates();
		System.out.println("front [1, 2, 5, 5] back should be \ttrue:" + consecutiveDups);

		numberQ.clear(); numberQ.enqueue(1);numberQ.enqueue(2); numberQ.enqueue(5);numberQ.enqueue(5); numberQ.enqueue(2);
		consecutiveDups = numberQ.hasConsecutiveDuplicates();
		System.out.println("front [1, 2, 5, 5, 2] back should be \ttrue:" + consecutiveDups);

		numberQ.clear(); numberQ.enqueue(1);numberQ.enqueue(2); numberQ.enqueue(5);numberQ.enqueue(5); numberQ.enqueue(2); numberQ.enqueue(1);
		consecutiveDups = numberQ.hasConsecutiveDuplicates();
		System.out.println("front [1, 2, 5, 5, 2, 1] back should be true:" + consecutiveDups);

		LinkedQueue<String> wordQ = new LinkedQueue<String>();
		wordQ.enqueue(new String("hi")); wordQ.enqueue(new String("hi"));
		consecutiveDups = wordQ.hasConsecutiveDuplicates();
		System.out.println("front [\"hi\", \"hi\"] back should be \ttrue:" + consecutiveDups);
		
		
		System.out.println("\n***** TESTING ARRAY STACK CONSECUTIVE DUPLICATES *****");
		ArrayStack<Integer> numberStack = new ArrayStack<Integer>();
		consecutiveDups = numberStack.hasConsecutiveDuplicates();
		System.out.println("bottom [] top should be \tfalse:" + consecutiveDups);

		numberStack.push(3);
		consecutiveDups = numberStack.hasConsecutiveDuplicates();
		System.out.println("bottom [3] top should be \tfalse:" + consecutiveDups);

		numberStack.clear(); numberStack.push(1); numberStack.push(2);
		consecutiveDups = numberStack.hasConsecutiveDuplicates();
		System.out.println("bottom [1, 2] top should be \tfalse:" + consecutiveDups);

		numberStack.push(1);
		consecutiveDups = numberStack.hasConsecutiveDuplicates();
		System.out.println("bottom [1, 2, 1] top should be \tfalse:" + consecutiveDups);

		numberStack.push(4); numberStack.push(4);
		consecutiveDups = numberStack.hasConsecutiveDuplicates();
		System.out.println("bottom [1, 2, 1, 4, 4] top should be \ttrue:" + consecutiveDups);

		numberStack.clear(); numberStack.push(3);numberStack.push(3);
		consecutiveDups = numberStack.hasConsecutiveDuplicates();
		System.out.println("bottom [3, 3] top should be \t\ttrue:" + consecutiveDups);

		numberStack.clear(); numberStack.push(5); numberStack.push(5); numberStack.push(3);
		consecutiveDups = numberStack.hasConsecutiveDuplicates();
		System.out.println("bottom [5, 5, 3] top should be \t\ttrue:" + consecutiveDups);

		numberStack.clear(); numberStack.push(3);numberStack.push(3); numberStack.push(5);numberStack.push(3);
		consecutiveDups = numberStack.hasConsecutiveDuplicates();
		System.out.println("bottom [3, 3, 5, 3] top should be \ttrue:" + consecutiveDups);

		numberStack.clear(); numberStack.push(1);numberStack.push(2); numberStack.push(5);numberStack.push(5);
		consecutiveDups = numberStack.hasConsecutiveDuplicates();
		System.out.println("bottom [1, 2, 5, 5] top should be \ttrue:" + consecutiveDups);

		numberStack.clear(); numberStack.push(1);numberStack.push(2); numberStack.push(5);numberStack.push(5); numberStack.push(2);
		consecutiveDups = numberStack.hasConsecutiveDuplicates();
		System.out.println("bottom [1, 2, 5, 5, 2] top should be \ttrue:" + consecutiveDups);

		numberStack.clear(); numberStack.push(1);numberStack.push(2); numberStack.push(5);numberStack.push(5); numberStack.push(2); numberStack.push(1);
		consecutiveDups = numberStack.hasConsecutiveDuplicates();
		System.out.println("bottom [1, 2, 5, 5, 2, 1] top should be true:" + consecutiveDups);

		ArrayStack<String> wordStack = new ArrayStack<String>();
		wordStack.push(new String("hi")); wordStack.push(new String("hi"));
		consecutiveDups = wordStack.hasConsecutiveDuplicates();
		System.out.println("bottom [\"hi\", \"hi\"] top should be \ttrue:" + consecutiveDups);


	}
	
	
	
	
}
