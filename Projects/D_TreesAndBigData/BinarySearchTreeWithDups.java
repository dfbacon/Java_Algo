import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = newEntry;
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
		} else {
			addEntryHelperNonRecursive(newEntry);
		}
		return result;
	}
	
	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	private void addEntryHelperNonRecursive(T newEntry) {

		BinaryNode<T> currentNode = getRootNode();
		int comparison;
		boolean inserted = false;

		while (!inserted) {

			comparison = newEntry.compareTo(currentNode.getData());
			if (comparison <= 0) {

				if (currentNode.hasLeftChild()) {

					currentNode = currentNode.getLeftChild();
				}
				else {

					currentNode.setLeftChild(new BinaryNode<>(newEntry));
					inserted = true;
				}
			}
			else {

				if (currentNode.hasRightChild()) {

					currentNode = currentNode.getRightChild();
				}
				else {

					currentNode.setRightChild(new BinaryNode<>(newEntry));
					inserted = true;
				}
			}
		}
	}


	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countEntriesNonRecursive(T target) {

		int count = 0;
		int comparison;
		BinaryNode<T> currentNode = getRootNode();

		while (currentNode != null) {

			comparison = target.compareTo(currentNode.getData());
			if (comparison == 0) {

				count++;
			}

			if (comparison <= 0) {

				currentNode = currentNode.getLeftChild();
			}
			else {

				currentNode = currentNode.getRightChild();
			}
		}

		return count;
	}

	// YOUR CODE HERE! MUST BE RECURSIVE! YOU ARE ALLOWED TO CREATE A PRIVATE HELPER.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterRecursive(T target) {

		int count = 0;
		BinaryNode<T> rootNode = getRootNode();

		if (rootNode != null) {

			while (rootNode.hasRightChild() && target.compareTo(rootNode.getData()) > 0) {

				rootNode = rootNode.getRightChild();
			}

			count = countHelper(rootNode, target);
		}
		
		return count;
	}


	private int countHelper(BinaryNode<T> node, T target) {

		if (node == null) {

			return 0;
		}

		int comparison = target.compareTo(node.getData());
		int count = 0;

		if (comparison < 0) {

			count++;
		}

		count += countHelper(node.getLeftChild(), target) + countHelper(node.getRightChild(), target);

		return count;
	}
		
	// YOUR CODE HERE! MUST USE A STACK!! MUST NOT BE RECURSIVE! 
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterWithStack(T target) {

		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();

		if (rootNode != null) {

			while (rootNode.hasRightChild() && target.compareTo(rootNode.getData()) > 0) {

				rootNode = rootNode.getRightChild();
			}
		}

		while (rootNode != null || nodeStack.size() > 0) {

			while (rootNode != null) {

				nodeStack.push(rootNode);
				rootNode = rootNode.getLeftChild();
			}

			rootNode = nodeStack.pop();

			if (target.compareTo(rootNode.getData()) < 0) {

				count++;
			}

			rootNode = rootNode.getRightChild();
		}

		return count;
	}
		
	// YOUR EXTRA CREDIT CODE HERE! THIS METHOD MUST BE O(n). 
	// YOU ARE ALLOWED TO USE A HELPER METHOD. THE METHOD CAN BE ITERATIVE OR RECURSIVE. 
	public int countUniqueValues() {

		BinaryNode<T> rootNode = getRootNode();
		int count = 0;

		if (rootNode != null) {

			List<T> uniqueValueList = new ArrayList<>();
			count = countUniqueHelper(rootNode, uniqueValueList);
		}

		return count;
	}

	private int countUniqueHelper(BinaryNode<T> node, List<T> uniqueValues) {

		if (node == null) {

			return 0;
		}

		if (!uniqueValues.contains(node.getData())) {

			uniqueValues.add(node.getData());
		}

		countUniqueHelper(node.getLeftChild(), uniqueValues);
		countUniqueHelper(node.getRightChild(), uniqueValues);

		return uniqueValues.size();
	}


	
	
	public int getLeftHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasLeftChild()) {
			return 0;
		} else {
			return rootNode.getLeftChild().getHeight();
		}
	}

	public int getRightHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasRightChild()) {
			return 0;
		} else {
			return rootNode.getRightChild().getHeight();
		}
	}
}