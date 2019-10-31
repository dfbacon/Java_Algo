public class MidtermPracticeQuestions {
    /*
    Question 1. Bag Trace
Trace the contents of the bag (implements BagInterface) after each statement:

System.out.println(nameBag.isEmpty());
nameBag.add("adam");
nameBag.add("brian");
nameBag.add("carl");
nameBag.add("adam");
nameBag.add("fred");
nameBag.add("carl");
nameBag.add("harry");
nameBag.add("hank");

// bag contents [adam, brian, carl, adam, fred, carl, harry, hank]

System.out.println(nameBag.remove("adam"));

// true
// bag contents [brian, carl, adam, fred, carl, harry, hank]

System.out.println(nameBag.getCurrentSize());

// 7

System.out.println(nameBag.remove("adam"));

// true
// [brian, carl, fred, carl, harry, hank]

System.out.println(nameBag.remove("adam"));

// false

System.out.println(nameBag.remove("ivan"));

// false

System.out.println(nameBag.getCurrentSize());

// 6

System.out.println(nameBag.getFrequencyOf("carl"));

// 2

System.out.println(nameBag.contains("ivan"));

// 0

System.out.println(nameBag.getFrequencyOf("ivan"));

// 0

nameBag.clear();
System.out.println(nameBag.getCurrentSize());

// 0

     */

    /*
    Question 2. ListInterface Trace
Trace the contents of the list (implements ListInterface) after each statement:

System.out.println(nameList.isEmpty());

// true

nameList.add("adam");
nameList.add("brian");
nameList.add("carl");
nameList.add("edgar");

// list contains: [adam, brian, carl, edgar]

nameList.add(3, "hank");

// list contains: [adam, brian, hank, carl, edgar]

nameList.add("lenny");
nameList.add(1, "mark");

// list contains: [mark, adam, brian, hank, carl, edgar, lenny]

System.out.println(nameList.getLength());

// 7

System.out.println(nameList.getEntry(3));

// brian

System.out.println(nameList.remove(2));

// adam
// list contains: [mark, brian, hank, carl, edgar, lenny]

System.out.println(nameList.getEntry(2));

// brian

System.out.println(nameList.remove(1));

// mark
// list contains: [brian, hank, carl, edgar, lenny]

System.out.println(nameList.remove(2));

// hank
// list contains: [brian, carl, edgar, lenny]

System.out.println(nameList.getLength());

// 4

System.out.println(nameList.replace(2, "peter"));

// carl
// list contains: [brian, peter, edgar, lenny]

System.out.println(nameList.getEntry(2));

// peter

System.out.println(nameList.getEntry(1));

// brian

System.out.println(nameList.getLength());

// 4

     */

    /*
    Question 3. List Trace
Trace the contents of the list (implements the Java List interface) after each statement:

System.out.println(nameList.isEmpty());
nameList.add("adam");
nameList.add("brian");
nameList.add("carl");
nameList.add("edgar");
nameList.add(3, "hank");
nameList.add("lenny");
nameList.add(1, "mark");
System.out.println(nameList.size());
System.out.println(nameList.get(3));
System.out.println(nameList.remove(2));
System.out.println(nameList.get(2));
System.out.println(nameList.remove(1));
System.out.println(nameList.remove(2));
System.out.println(nameList.size());
System.out.println(nameList.set(2, "peter"));
System.out.println(nameList.get(2));
System.out.println(nameList.get(1));
     */

    /*
    Question 4. Client Perspective on Bags and Lists
What does it mean to use a bag or list as a client (to use an interface)?
What can you access?

Complete the following without using the toArray method:
a. Write code at the client level that merges two lists by alternating the
    elements together. The method takes two ListInterface objects as parameters
    and returns the new ListInterface.  For example: List1 = {1, 2, 3},
    List2 = {4, 6, 8, 10}, return a new list: {1, 4, 2, 6, 3, 8, 10}. The original
    two lists should not be modified when your program ends.

b. Write code at the client level that merges two bags.

c. Write a containsDuplicates method for lists from the client perspective. The
    method takes a ListInterface as a parameter. The list should not be modified
    when the method ends.

d. Assume there is no getCurrentSize() method in BagInterface. Write a getSize method
    for bags from the client perspective. The method takes a bag as a parameter. The
    bag should not be modified when the method ends.
     */

    /*
    Question 5. Implementation Perspective on Bags and Lists
a. Write a getFrequencyOf method for AList or LList. The method should be efficient
    because you can access the underlying data structure. (Do not just use the same
    method as you would use from the client perspective.)

b. Assume there is no getCurrentSize() method and no direct access to numberOfEntries.
    Write a getSize method for ArrayBag or LinkedBag. The method should be efficient
    because you can access the underlying data structure. (Do not just use the same
    method as you would use from the client perspective.)
     */

    /*
    Question 6: Tracing Nodes A
What is printed by the code below?
Explain what the mystery method does. (Do not repeat what the code does, but explain in
words what it returns.)
Is there anything wrong with how this method is implemented? Will it ever crash?

list: 4 -> 6 -> 10 -> 12

Node nodeA = list.firstNode.next.next;
Node nodeB = list.firstNode.next;
Node nodeC = list.firstNode.next.next.next;
Node nodeD = nodeC.next;

System.out.println(nodeA.data);
System.out.println(nodeB.data);
System.out.println(nodeC.data);
System.out.println(nodeD.data);
System.out.println(mystery(list.firstNode, 9));
System.out.println(mystery(list.firstNode, 10));

public boolean mystery(Node firstNode, int target) {
   Node currentNode = firstNode;
   if(currentNode.next==null) {
      return false;
   } else {
      Node tmpNode = currentNode;
      currentNode = currentNode.next;
      while(currentNode!=null) {
         if(currentNode.data==target) {
            System.out.println(tmpNode.data);
              return true;
         } else {
            tmpNode = currentNode;
            currentNode = currentNode.next;
         }
      }
      return false;
   }
}
     */

    /*
    Question 7: Tracing Nodes B
What is printed by the pseudocode below?

Node firstNode = new Node(3);
firstNode.next = new Node(4);
firstNode.next.next = new Node(6);
firstNode.next.next.next new Node(8);
Node currentNode = firstNode;

print currentNode.data
print the chain headed by firstNode

currentNode = currentNode.next
print currentNode.data
print the chain headed by firstNode

currentNode.data = 7
print currentNode.data
print the chain headed by firstNode

currentNode.next = currentNode.next.next;
print currentNode.data
print the chain headed by firstNode

firstNode = firstNode.next;
print currentNode.data
print the chain headed by firstNode
     */

    /*
    Question 8: Other Questions about Bags and Lists
a. What are the underlying data structure and other instance data variables for
    each of the four classes (ArrayBag, LinkedBag, AList, and LList)? In general,
    how are these instance data variables affected by adds/removes (meaning where
    do adds/removes happen)?

b. What are the efficiencies of adding and removing for the two bag classes?

c. What are the efficiencies of adding to the front, adding to the back, removing
    from the front, and removing from the back for the two list classes? Is there
    anything you can do to improve the complexity of any of these methods for LList?

d. What are the advantages and disadvantages of implementing lists and bags with
    arrays vs linked nodes?

e. What special considerations must be taken into account for empty bags and lists?
    Are these the same considerations for array-based and node-based implementations?
    Are there things we need to think about for "full" data structures?
     */

    /*
    Question 9: Coding with Nodes
a. Write a complete method to traverse a linked list of Strings, headed by firstNode,
    and determine if each String contains a specific character.

b. Write a complete method to determine if a linked list of Integers, headed by
    firstNode, contains any two values repeated. For example, 4->2->2->3 would return
    true and 3->2->4->2 would return false.

c. Write a complete method that takes in a linked list of Integers (headed by firstNode)
    and an int array and merges them together into an array using an alternating merge
    (see Question 4 above).
     */

    /*
    Question 10: Comparison
a. When should you use == vs. equals?

b. Are there restrictions on what kind of objects can use equals?

c. When should you use compareTo vs < or >?

d. Are there restrictions on what kind of objects can use compareTo?

e. What values are returned from compareTo?
     */

    /*
Question 11: Calculating Complexity


a. What is the relationship between an algorithm's running time and its big-oh order of
    growth?

b. What are considered some "good" Big-Os and some "bad" Big-Os?

c. What are the Big-Os of the following algorithms?

Algorithm 1:

    statement1;

    if(condition1) {
       statement2;
    } else {
       for(int i=0; i<n; i++) {
          statement3;
        }
       statement4;
    }

Algorithm 2:

    i=0;
    while(i<n) {
       for(int j=i; j<n; j++) {
          statement1;
        }
       statement2;
       i++;
    }

Algorithm 3:

    for(int i=0; i<n; i++) {
       for(int j=0; j<n; j++) {
          if(condition1) {
             for(int k=0; k<10; k++) {
                  statement1;
               }
          } else {
             statement2;
          }
       }
    }

Algorithm 4:

    for(int i=0; i<=n; i++) {
       for(int j=0; j<=n; j++) {
          if(j%2==0) {
             statement1
          }
       }
    }

d. What are the Big-Os of the following algorithms?

Algortihm A:

    for(int i=0; i<n; i++)
       add i to the beginning of an array-based list

Algortihm B:

    for(int i=0; i<n; i++)
       add i to the end of an array-based list

Algortihm C:

    for(int i=0; i<n; i++)
       add i to the beginning of a linked list with only a head pointer

Algortihm D

    for(int i=0; i<n; i++)
       add i to the end of a linked list with only a head pointer
     */

    /*
    Question 12: Evaluating Recursive Methods
What is the output of the following recursive method calls? I recommend you
    do not simply run them! Instead, trace out what is happening by hand to
    make sure you understand.

Choice A:

    System.out.println(recMethod1(5, 1));

    recFactorial1(4);
    recFactorial2(4);

    public int recMethod1(int x, int y) {
       if(x==y) {
          return 0;
       } else {
          return recMethod1(x-1, y) +1;
        }
    }

    public int recFactorial1(int x) {
       System.out.print(x);
       if(x > 1) {
          return x * recFactorial1(x-1);
       } else {
          return 1;
       }
    }

    public int recFactorial2(int x) {
       if(x > 1) {
          int fac = x * recFactorial2(x-1);
          System.out.print(x);
          return fac;
       } else {
          return 1;
       }
    }

Choice B:

    int[] a = {6, 2, 4, 6, 2, 1, 6, 2, 5};

    System.out.println(recMethod2(a, 2, 0));
    System.out.println(recMethod2(a, 2, 9));

    System.out.println(recMethod3(a, 0));


    public int recMethod2(int[] arr, int b, int j) {
       if(j<arr.length) {
          if(arr[j] != b) {
             return recMethod2(arr, b, j+1);
           } else {
             return 1+recMethod2(arr, b, j+1);
           }
       } else {
         return 0;
        }
    }
    public int recMethod3(int[] arr, int n) {
       int sum = 0;
       if(n<arr.length-1) {
          recMethod3(arr, n+1);
       } else {
          sum = arr[n];
       }
       return sum;
    }

Choice C:

    chainA: 2 -> 3 -> 1 -> 6 -> 4
    chainB: 3 -> 5 -> 4 -> 2
    chainC: 4
    chainD: an empty chain

    call recMethod4 with each chain

    public void recMethod4(Node<Integer> current) {
       if(current.next!=null) {
           System.out.println(current.data);
           current.data = current.data+1;
           recMethod4(current.next);
           System.out.println(current.data);
       }
    }
     */

    /*
    Question 13: Properties of Recursive Methods
        1. What features must you have in all recursive methods?

        2. Are any of the methods in the question above missing any of
            these requirements (under all conditions or under only certain
            conditions)?

        3. What will happen if you invoke these methods under these conditions?
     */

    /*
    Question 14: Writing Recursive Methods
a. take three parameters (a String, a character, and an initial index) and return
    the number of times the character appears in the string starting at the initial index

b. take one Node parameter that represents the head of a list and returns a count for how
    many elements are in the chain

c. take an array of integers and an integer key and return the number of elements in the
    array that are greater than the key
     */
}