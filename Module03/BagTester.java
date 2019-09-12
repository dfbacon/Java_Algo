public class BagTester {
    public static void main(String[] args) {
        BagInterface<String> notSet = new ArrayBag<>(5);
        BagInterface<String> isSet = new ArrayBag<>(5);

        notSet.add("one");
        notSet.add("two");
        notSet.add("one");
        notSet.add("three");
        notSet.add("four");

        System.out.println("notSet size = " + notSet.getCurrentSize());

        isSet.add("one");
        isSet.add("two");
        isSet.add("three");
        isSet.add("four");
        isSet.add("five");

        System.out.println("isSet size = " + isSet.getCurrentSize());

        System.out.print("notSet (false): ");
        if (isSet(notSet))
            System.out.println("true");
        else
            System.out.println("false");

        System.out.println("notSet size is: " + notSet.getCurrentSize());

        System.out.println();
        System.out.print("isSet (true): ");
        if (isSet(isSet))
            System.out.println("true");
        else
            System.out.println("false");

        System.out.println("isSet size is: " + isSet.getCurrentSize());

    }

    public static boolean isSet(BagInterface<String> wordBag) {

        boolean isASet = true;

        BagInterface<String> tempBag = new ArrayBag<>(wordBag.getCurrentSize());

        while (!wordBag.isEmpty()) {
            String word = wordBag.remove();
            tempBag.add(word);

            if (wordBag.contains(word)) {
                isASet = false;
                break;
            }
        }

        while (!tempBag.isEmpty()) {
            wordBag.add(tempBag.remove());
        }

        return isASet;
    }
}