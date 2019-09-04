import Parcel.*;

public class ParcelTester {
    public static void main (String[] args) {
        System.out.println("Testing new parcel...");
        Parcel newParcel = new Parcel("dc4x1m43m2", 1.356);
        System.out.println(newParcel.toString());
    }
}