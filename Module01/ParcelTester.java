public class ParcelTester {
    public static void main (String[] args) {
        System.out.println("Testing new parcel...");
        Parcel firstParcel = new Parcel("dc4x1m43m2", -0.277);
        System.out.println(firstParcel.toString());

        // Create multiple Parcel objects
        Parcel secondParcel = new Parcel("dc4x1m43m2", -0.277);
        Parcel thirdParcel = new Parcel("mdc4x1m43m", 13.7883);
        Parcel fourthParcel = new Parcel("mdc4x1m43s", 4);
        Parcel fifthParcel = new Parcel("ddc4x1m4mm");
        Parcel sixthParcel = new Parcel("ddc4x1m4xm5", 6.2);
        Parcel seventhParcel = new Parcel("kdc2m1m4rv", 7.77);

        // Test equals() method
        if (firstParcel.equals(secondParcel))
            System.out.println("The two parcels are the same.");
        else
            System.out.println("The parcels are different.");

        if (firstParcel.equals(fourthParcel))
            System.out.println("The two parcels are the same.");
        else
            System.out.println("The parcels are different.");

        // Test IdMeetsCriteria() method
        if (firstParcel.IdMeetsCriteria('x', 'm', 2))
            System.out.println("Yes.");
        else
            System.out.println("No.");

        if (thirdParcel.IdMeetsCriteria('x', 'm', 2))
            System.out.println("Yes.");
        else
            System.out.println("No.");

        if (fourthParcel.IdMeetsCriteria('x', 'm', 2))
            System.out.println("Yes.");
        else
            System.out.println("No.");

        if (fifthParcel.IdMeetsCriteria('x', 'm', 2))
            System.out.println("Yes.");
        else
            System.out.println("No.");

        if (sixthParcel.IdMeetsCriteria('x', 'm', 2))
            System.out.println("Yes.");
        else
            System.out.println("No.");

        if (seventhParcel.IdMeetsCriteria('x', 'm', 2))
            System.out.println("Yes.");
        else
            System.out.println("No.");
    }
}