/*
Write a complete method from the client perspective to create a new ListInterface object that contains all Strings on a
  wordList that contain a given character.

The method header is:

public static ListInterface<String> createWordListContainChar(ListInterface<String> wordList, char key)

Notes:
The relative order of the names in the returned list should match the order of the names in the parameter list.

The wordList parameter should be unchanged when the method completes.

You can use local objects of type ListInterface (initialized as AList).

For full credit, do not use another data structure, such as ArrayList or an array.

Post any questions about what you can and cannot use to the discussion board.

For full credit, do not invoke the toArray() method on wordList.
 */


public class ListInterfaceTester {

    public static void main(String[] args) {
        ListInterface<String> testList = new AList<>();
        ListInterface<String> emptyList = new AList<>();
        ListInterface<String> nullList = null;
        ListInterface<String> returnList;

        testList.add("one");
        testList.add("two");
        testList.add("three");
        testList.add("four");
        testList.add("five");

        System.out.println("list length is: " + testList.getLength());
        printListInterface(testList);

        returnList = createWordListContainChar(testList, 'o');
        printListInterface(returnList);
        printListInterface(testList);

        returnList = createWordListContainChar(testList, 'w');
        printListInterface(returnList);

        returnList = createWordListContainChar(testList, 'x');
        printListInterface(returnList);

        returnList = createWordListContainChar(emptyList, 'a');
        printListInterface(returnList);

        returnList = createWordListContainChar(nullList, 'a');
        printListInterface(returnList);
    }



    public static void printListInterface(ListInterface<String> aList) {
        System.out.print("List is: ");
        for (int i = 1; i < aList.getLength() + 1; i++) {
            System.out.print(aList.getEntry(i) + ", ");
        }
        System.out.println();
    }



    public static ListInterface<String> createWordListContainChar(ListInterface<String> wordList, char key) {

        String entry;
        ListInterface<String> containsCharList;

        if (wordList == null || wordList.isEmpty()) {
            containsCharList = new AList<>();
        }
        else {
            containsCharList = new AList<>(wordList.getLength());

            for (int i = 1; i < wordList.getLength() + 1; i++) {
                entry = wordList.getEntry(i);

                if (entry.contains(Character.toString(key))) {
                    containsCharList.add(entry);
                }
            }
        }

        return containsCharList;
    }
}