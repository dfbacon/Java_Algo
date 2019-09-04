/**
 Write the follow for the child overnight parcel class:
     the child class header
    the instance data variables
    one constructor that takes in all three pieces of information that describe an overnight parcel
 */

public class OvernightParcel extends Parcel {

    private boolean signatureRequired;

    public OvernightParcel (String newId, double newWeight, boolean doesNeedSignature) {
        super(newId, newWeight);
        doesNeedSignature = setSignatureRequired(doesNeedSignature);
    }


    public void setSignatureRequired(boolean doesNeedSignature) {
        signatureRequired = doesNeedSignature;
    }
}