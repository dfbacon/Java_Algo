import java.util.*;

public class HomeworkM11Driver {

	public static void main(String[] args) {
		
		System.out.println("***************TESTING EQUALS AND HASHCODE METHOD IN STUDENT CLASS");
		Student testStudent = new Student(123, "Sam", "Studier", true);
		Set<Student> studentSet = new HashSet<>();
		Student equiv1 = new Student(123, "Sam", "Studier", true);
		Student equiv2 = new Student(Integer.valueOf(123), new String("Sam"), new String("Studier"), Boolean.valueOf(true));
		System.out.println("testStudent and equiv1 equivalent \ttrue: " + testStudent.equals(equiv1));
		System.out.println("testStudent and equiv2 equivalent \ttrue: " + testStudent.equals(equiv2));		
		System.out.println("Same hashCode test1 \t\t\ttrue: " + (testStudent.hashCode()== equiv1.hashCode()));
		System.out.println("Same hashCode test2 \t\t\ttrue: " + (testStudent.hashCode()==equiv2.hashCode()));
		System.out.println("Add testStudent \t\t\ttrue:  " + studentSet.add(testStudent));
		System.out.println("Add testStudent again \t\t\tfalse: " + studentSet.add(testStudent));
		System.out.println("Add equiv  \t\t\t\tfalse: " + studentSet.add(equiv1));
		System.out.println("Add equiv2 \t\t\t\tfalse: " + studentSet.add(equiv2));
		Student differentStudent = new Student(456, "Sam", "Studier", true);
		boolean same = testStudent.equals(differentStudent);
		if(same) {
			System.out.println("Your equals method says testStudent and a different student with the same name are the same.");
			System.out.println("Accordingly, they should have the same hashcode.");
			System.out.println("Same hashCode test3 \t\t\ttrue: " + (testStudent.hashCode()==differentStudent.hashCode()));
		} else {
			System.out.println("testStudent and different equivalent \tfalse: " + same);
		}
		differentStudent = new Student(123, "Pat", "Procrastinator", false);
		same = testStudent.equals(differentStudent);
		if(same) {
			System.out.println("Your equals method says testStudent and a different student with the same id are the same.");
			System.out.println("Accordingly, they should have the same hashcode.");
			System.out.println("Same hashCode test4 \t\t\ttrue: " + (testStudent.hashCode()==differentStudent.hashCode()));
		} else {
			System.out.println("testStudent and different equivalent \tfalse: " + same);
		}		
		
		int[] tableSizes = {5, 2, 10};
		for (int tableSize : tableSizes) {
			System.out.println("\n***************TESTING WITH TABLE SIZE " + tableSize);
			System.out.println("\n*****TESTING ADD TO VOTER HASHTABLE");
			Voter v1 = new Voter(912, "Delta Dem");
			Voter v2 = new Voter(670, "Rita Rep");
			Voter v3 = new Voter(381, "Ida Inde");
			Voter v4 = new Voter(497, "Greta Green");
			Voter v5 = new Voter(301, "Liz Libert");
			Voter v6 = new Voter(541, "Ursula Undec");

			Voter[] theVoters = { v1, v2, v3, v4, v5, v6 };

			VoterHashTableSeparateChaining voterTable = new VoterHashTableSeparateChaining(tableSize);
			System.out.println("Each voter should be added to the table- each should print true.");
			for (Voter v : theVoters) {
				System.out.println("Added " + v.getName() + "  \ttrue: " + voterTable.addVoter(v));
			}
			System.out.println("\nCompare your table to the location of where each voter should be. They should match.");
			System.out.println("\nHere is your table:");
			voterTable.printTable();
			System.out.println();

			System.out.println("The locations below should match the table above.");
			for (Voter v : theVoters) {
				System.out.println(v.getName() + "\tLocation " + voterTable.getHashTableLocation(v.getId()));
			}

//			 UNCOMMENT IF COMPLETING THE EXTRA CREDIT
			System.out.println("\n*****TESTING EXTRA CREDIT- NO ADDING DUPLICATES");
			System.out.println("These voters are duplicates and should not be added- each should print false.");
			System.out.println("Delta Dem added again?\t\t\tfalse: " + voterTable.addVoter(v1));
			System.out.println("Equivalent of Delta Dem added?\t\tfalse: " + voterTable.addVoter(new Voter(912, "Delta Dem")));
			System.out.println("Equivalent of Delta Dem added?\t\tfalse: " + voterTable.addVoter(new Voter(Integer.valueOf(912), new String("Delta Dem"))));
			System.out.println("Added Ursula Undec added again?\t\tfalse: " + voterTable.addVoter(v6));
			System.out.println("Equivalent of Ursula Undec again?\tfalse: " + voterTable.addVoter(new Voter(541, "Ursula Undec")));
			System.out.println("Equivalent of Ursula Undec again?\tfalse: " + voterTable.addVoter(new Voter(Integer.valueOf(541), new String("Ursula Undec"))));

			System.out.println("\n*****TESTING RETRIEVE FROM");
			System.out
					.println("Get these voters based on their ID. The voter retrieved should match what is asked for.");
			System.out.println("Retreived " + v1.getId() + " (Delta Dem) \t: " + voterTable.getVoter(v1.getId()));
			System.out.println("Retreived " + v2.getId() + " (Rita Rep) \t: " + voterTable.getVoter(v2.getId()));
			System.out.println("Retreived " + v3.getId() + " (Ida Inde) \t: " + voterTable.getVoter(v3.getId()));
			System.out.println("Retreived " + v4.getId() + " (Greta Green) \t: " + voterTable.getVoter(v4.getId()));
			System.out.println("Retreived " + v5.getId() + " (Liz Libert) \t: " + voterTable.getVoter(v5.getId()));
			System.out.println("Retreived " + v6.getId() + " (Ursula Undec) \t: " + voterTable.getVoter(v6.getId()));
			Voter v7 = new Voter(412, "Nancy NotAVoter");
			System.out.println("Retrieved Nancy NotAVoter? \tshould be null: " + voterTable.getVoter(v7.getId()));
		}
	}	
}
