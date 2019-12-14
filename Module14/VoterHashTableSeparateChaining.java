import java.util.Objects;

public class VoterHashTableSeparateChaining {

	private Node<Voter>[] hashTable;
	private int tableSize;

	public VoterHashTableSeparateChaining(int size) {
		hashTable = (Node<Voter>[]) new Node[size];
		tableSize = size;
	}

	public int getHashTableLocation(int voterID) {

		return voterID % tableSize;
	}

	// Extra credit implemented
	public boolean addVoter(Voter voterToAdd) {

		boolean voterAdded = false;

		if (voterToAdd != null) {

			Node<Voter> newVoter = new Node<>(voterToAdd);
			int index = getHashTableLocation(voterToAdd.getId());

			if (hashTable[index] == null) {

				hashTable[index] = newVoter;
				voterAdded = true;

			} else {

				Node<Voter> currentEntry = hashTable[index];

				while (currentEntry.getNextNode() != null) {

					if (equalVotingObject(currentEntry.getData(), voterToAdd)) {

						return voterAdded;
					}

					currentEntry = currentEntry.getNextNode();
				}

				if (!equalVotingObject(currentEntry.getData(), voterToAdd)) {

					currentEntry.setNextNode(newVoter);
					voterAdded = true;
				}
			}
		}

		return voterAdded;
	}

	public Voter getVoter(int voterID) {

		Voter voterFound = null;
		int index = getHashTableLocation(voterID);

		if (hashTable[index] != null) {

			Node<Voter> currentEntry = hashTable[index];

			while (currentEntry != null) {

				if (currentEntry.getData().getId() == voterID) {

					voterFound = currentEntry.getData();
					break;
				}

				currentEntry = currentEntry.getNextNode();
			}
		}

		return voterFound;
	}

	private boolean equalVotingObject(Voter firstVoter, Voter secondVoter) {

		return firstVoter.getId() == secondVoter.getId()
				&& firstVoter.getName().equals(secondVoter.getName());
	}

	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				System.out.print("Location " + i + ": ");
				Node<Voter> current = hashTable[i];
				while (current != null && current.next != null) {
					System.out.print(current.data.getName() + " -> ");
					current = current.next;
				}
				System.out.println(current.data.getName());
			}
		}
	}

}
