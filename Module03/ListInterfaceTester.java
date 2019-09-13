import java.util.*;

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
        /*
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
         */

        ListInterface<Integer> sameListInterface = new AList<>(5);
        ListInterface<Integer> diffNumListInterface = new AList<>(2);
        ListInterface<Integer> diffValListInterface = new AList<> (4);
        ListInterface<Integer> nullListInterface = null;

        List<Integer> sameList = new ArrayList<>(5);
        List<Integer> diffNumList = new ArrayList<>(3);
        List<Integer> diffValList = new ArrayList<>(4);
        List<Integer> nullList = null;

        sameListInterface.add(0);
        sameListInterface.add(1);
        sameListInterface.add(2);
        sameListInterface.add(3);
        sameListInterface.add(4);

        sameList.add(0);
        sameList.add(1);
        sameList.add(2);
        sameList.add(3);
        sameList.add(4);

        diffNumListInterface.add(0);
        diffNumListInterface.add(1);

        diffNumList.add(0);
        diffNumList.add(1);
        diffNumList.add(2);

        diffValListInterface.add(0);
        diffValListInterface.add(1);
        diffValListInterface.add(2);
        diffValListInterface.add(3);

        diffValList.add(10);
        diffValList.add(11);
        diffValList.add(12);
        diffValList.add(13);

        System.out.println("true : " + equivalentLists(sameListInterface, sameList));
        System.out.println("false : " + equivalentLists(sameListInterface, diffNumList));
        System.out.println("false : " + equivalentLists(diffNumListInterface, sameList));
        System.out.println("false : " + equivalentLists(diffValListInterface, diffValList));
        System.out.println("false : " + equivalentLists(nullListInterface, sameList));
        System.out.println("false : " + equivalentLists(sameListInterface, nullList));
        System.out.println("false : " + equivalentLists(nullListInterface, nullList));
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


    /*
    Write a complete method from the client perspective to determine if a ListInterface and List of numbers have
    equivalent contents- meaning the same numbers in the same order.

    Notes:
        Neither parameter list should be changed when the method completes.

        Do not assume anything about the size of the lists!

        For full credit, do not convert either list to an array.

        For full credit, do not use another data structure, such as ArrayList, AList, or an array.

        Post any questions about what you can and cannot use to the discussion board.
     */
    public static boolean equivalentLists(ListInterface<Integer> numberListInterface, List<Integer> numberList) {

        int index = 1;

        if ((numberListInterface != null && numberList != null) &&
                numberList.size() == numberListInterface.getLength()) {

            for (Integer number : numberList) {
                if (numberListInterface.getEntry(index) != number) {
                    return false;
                }

                index++;
            }

            return true;
        }

        return false;
    }

}