import java.util.*;

public class HomeworkM6Driver {

	// I recommend changing these to smaller numbers to start with!
	// Then once you think you have a good solution, you can increase them for more robust testing.
	public static final int LIST_SIZE = 100;
	public static final int SINGLE_DUPLICATE_NUMBERS = 10; // minimum number of numbers on the list that will appear twice (have a "single duplicate"
	public static final int DOUBLE_DUPLICATE_NUMBERS = 5;  // minimum number of numbers on the list that will appear three times (have a "duplicate duplicate")
	
	
	public static void main(String[] args) {
		
		// set up an Integer list that is guaranteed to have some single and double duplicates
		List<Integer> numbers = new ArrayList<>();
		Random generator = new Random();
		int max = 5 * LIST_SIZE;
		int min = -1 * max;
		int randomRange = max - min + 1;
		
		// add the first round of numbers
		int originalNumbersToAdd = LIST_SIZE- SINGLE_DUPLICATE_NUMBERS - DOUBLE_DUPLICATE_NUMBERS;
		numbers.add(min); // adding the min and max number to help test for array out of bounds errors
		numbers.add(min);
		numbers.add(max);
		numbers.add(max);
		numbers.add(0);  // adding 0 as a special test case
		numbers.add(0); 
		originalNumbersToAdd-=6;
		for(int i=0; i<originalNumbersToAdd; i++) {
			numbers.add(generator.nextInt(randomRange) + min);			
		}
		
		// add duplicate numbers
		Collections.shuffle(numbers);
		for(int i=0; i<SINGLE_DUPLICATE_NUMBERS; i++) {
			numbers.add(numbers.get(i));
		}
		for(int i=0; i<DOUBLE_DUPLICATE_NUMBERS; i++) {
			numbers.add(numbers.get(i));
		}
		
		// print the list sorted (might help with testing)
		Collections.sort(numbers);
		System.out.println("The original list:");
		System.out.println(numbers);
		Collections.shuffle(numbers);
		
		// the results should be the same for both methods
		System.out.println("\nThe duplicate lists from both methods- these should match!");
		List<Integer> duplicateList = findDuplicatesBad(numbers);
		Collections.sort(duplicateList);
		System.out.println(duplicateList);
		
		duplicateList = findDuplicatesLinear(numbers);
		Collections.sort(duplicateList);
		System.out.println(duplicateList);


	}
	
	public static List<Integer> findDuplicatesBad(List<Integer> numbers) {
		List<Integer> duplicateList = new ArrayList<Integer>();
		for(int i=0; i<numbers.size(); i++) {
			int numberEvaluating = numbers.get(i);
			boolean duplicateFound = false;
			
			for(int j=i+1; j<numbers.size() && !duplicateFound; j++) {
				int numberChecking = numbers.get(j);
				
				if(numberEvaluating==numberChecking && !duplicateList.contains(numberEvaluating)) {
					duplicateFound = true; 
					
					for(int k=j; k<numbers.size(); k++) {
						if(numberChecking==Integer.valueOf(numbers.get(k))) {
							duplicateList.add(numberChecking);
						}
					}
				}
			}
		}
		return duplicateList;
	}
	
	/*
		For this question, write a new method to accomplish the same task in O(n)
		time.

		Before you begin to write your own code, carefully review the method below.
		Make sure you understand why that is the order of growth... it's not because
		of the three loops!
			You'll notice that the second and third loop will combine to only go
			through the list one time, so this is O(n) not O(n2). So where does that
			O(n3) come from?

		Write a new method to create a list of all duplicate integers found on a List.
			Note that you are not revising or fixing the method below.
			You are writing a new method.
			Your method should be linear O(n).

		Details about your method:
			The numbers in the integer list passed in as a parameter are in the range
			-5n to 5n, where n is the size of the list.

			Example: if the list is size 10, the numbers in the list are in the range
			-50 to 50.
			Example: if the list is size 100, the numbers are in the range -500 to 500

			If a duplicate number shows up more than once on the original list, it
			should also show up more than once on the duplicate list.

			Example: if the original list contains [1, 1, 1, 2, 2, 3, 4, 5, 5, 5], then
			the duplicates list should contain [1, 1, 2, 5, 5]

			The order of your duplicates list does not matter. For ease in
			testing/comparing, the driver program sorts the lists before printing.

		Hints:
			Remember that you can often improve efficiency by using more space!

			Take advantage of the fact that you know something about the range of
			the numbers on the list!

			Carefully check the Big-O of any methods you use (e.g., sorting methods,
			contains methods, remove methods, etc.). If any of those methods are worse
			than O(n), you should not use them!

			You can review a method's efficiency by reviewing the description on the API
			page for that class.
	 */
	public static List<Integer> findDuplicatesLinear(List<Integer> numbers) {
		List<Integer> duplicateList = new ArrayList<>();
		final int MAX_SIZE = (5 * numbers.size()) + 1;

		int positiveArray[] = new int[MAX_SIZE];
		int negativeArray[] = new int[MAX_SIZE];
		List<Integer> zeroList = new ArrayList<>();

		for (int index = 0; index < numbers.size(); index++) {
			int targetValue = numbers.get(index);

			if (targetValue == 0) {
				zeroList.add(0);
			}
			else if (targetValue > 0) {
				if (positiveArray[targetValue] != targetValue) {
					positiveArray[targetValue] = targetValue;
				}
				else {
					positiveArray[index] = targetValue;
				}
			}
			else {
				if (negativeArray[Math.abs(targetValue)] != Math.abs(targetValue)) {
					negativeArray[Math.abs(targetValue)] = Math.abs(targetValue);
				}
				else {
					negativeArray[index] = Math.abs(targetValue);
				}
			}
		}

		if (zeroList.size() > 1) {
			for (int index = 1; index < zeroList.size(); index++) {
				duplicateList.add(0);
			}
		}

		for (int index = 0; index < positiveArray.length; index++) {
			int targetValue = Math.abs(positiveArray[index]);

			if (positiveArray[targetValue] < 0) {
				duplicateList.add(targetValue);
			}
			else {
				positiveArray[targetValue] *= -1;
			}
		}

		for (int index = 0; index < negativeArray.length; index++) {
			int targetValue = Math.abs(negativeArray[index]);

			if (negativeArray[targetValue] < 0) {
				duplicateList.add(targetValue * -1);
			}
			else {
				negativeArray[targetValue] *= -1;
			}
		}

		return duplicateList;
	}
}
