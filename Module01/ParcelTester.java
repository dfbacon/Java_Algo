/**
 *  Write code that would go inside the main method of a driver/tester program.
 *     Create two parcel objects. Use both constructors.
 *     Invoke the method you wrote above on the first object using 'x', 'm', and 2 as parameters; store the returned result in a local variable.
 *     Print a text representation of the second object to the console.
 */
public class ParcelTester {
    public static void main (String[] args) {

        boolean criteriaCheck;

        Parcel firstParcel = new Parcel("dc4x1m43m2", -0.277);
        Parcel secondParcel = new Parcel("mdc4x1m43m");

        criteriaCheck = firstParcel.IdMeetsCriteria('x', 'm', 2);
        System.out.println(secondParcel.toString());
    }
}