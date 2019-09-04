package Parcel;

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