import java.util.*;

public class ListTester {
    public static void main(String[] args) {

        List<String> wordList = new ArrayList<>();

        wordList.add("ocean");
        wordList.add("tree");
        wordList.add("bird");
        wordList.add("ocean");
        wordList.add("beach");

        System.out.println("1 : " + lastPosition(wordList, "tree"));
        System.out.println("2 : " + lastPosition(wordList, "bird"));
        System.out.println("3 : " + lastPosition(wordList, "ocean"));
        System.out.println("4 : " + lastPosition(wordList, "beach"));
        System.out.println("-1 : " + lastPosition(wordList, "none"));
        System.out.println("-1 : " + lastPosition(null, null));
        System.out.println("-1 : " + lastPosition(null, "sun"));
        System.out.println("-1 : " + lastPosition(wordList, null));
    }



    public static int lastPosition(List<String> wordList, String targetWord) {

        int first, last, firstFoundIndex = -1;

        if (wordList != null && targetWord != null &&
                wordList.contains(targetWord)) {

            firstFoundIndex = wordList.indexOf(targetWord);
            first = firstFoundIndex + 1;
            last = wordList.size() - 1;

            while (first <= last) {
                if (wordList.get(first).equals(targetWord)) {
                    firstFoundIndex = first;
                }

                if (wordList.get(last).equals(targetWord)) {
                    return last;
                }

                first++;
                last--;
            }
        }

        return firstFoundIndex;
    }



// ################################## HOMEWORK EXTRA CREDIT ##########################################

    /*
    Find the minimum value in a List and move that value to the front of the list.

    Notes:
        Do not make any assumptions about the length of the list!

        Your code should not crash with empty lists, one-element lists, or longer lists.

        If there is more than one copy of the minimum, you can move any of those copies to the front.

        You are not swapping values- but performing a shift by moving the minimum value to the front of the list.

        For full credit, do not use another data structure, such as ArrayList or an array.

        For full credit, take advantage of the methods provided in List rather than rewriting code yourself.
     */
    public static void prioritizeMinimumValue(List<Integer> numberList) {}
}