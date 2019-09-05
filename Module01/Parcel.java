/**
 In the following questions, you will write a parent class that describes a
 parcel (like a package, as shown below) and a child class that describes an
 overnight parcel.

 A parcel is described by:

 id (which might contain numbers and letters)
 weight (described as the number of pounds; a parcel could be less than 1 pound)
 An overnight parcel is described by id and weight and also:

 whether or not a signature is required upon delivery.


 Write code that would go inside the main method of a driver/tester program.
    Create two parcel objects. Use both constructors.
    Invoke the method you wrote above on the first object using 'x', 'm', and 2 as parameters; store the returned result in a local variable.
    Print a text representation of the second object to the console.
 */

public class Parcel {

    static final double DEFAULT_WEIGHT = 1;

    private String id;
    private double weight;


    public Parcel(String newId) {
        this(newId, DEFAULT_WEIGHT);
    }


    public Parcel(String newId, double newWeight) {
        setId(newId);
        setWeight(newWeight);
    }


    public double getWeight() {
        return weight;
    }


    public String getId() {
        return id;
    }


    public void setWeight(double newWeight) {
        try {
            if (newWeight > 0)
                weight = newWeight;

            else {
                weight = DEFAULT_WEIGHT;

                throw new IllegalArgumentException("Parcel weight must be greater than zero. " +
                        "Setting to default weight.");
            }
        }

        catch (IllegalArgumentException e) {
            System.out.println("ERROR CREATING PACKAGE: " + e.getMessage());
        }
    }


    public void setId(String newId) {
        id = newId.toLowerCase();
    }


    public String toString() {
        return "The parcel's id is: " + getId() + ".\nThe parcel's weight is: " + getWeight() + " pounds.";
    }


    public boolean equals(Parcel otherParcel) {
        return getId() == otherParcel.getId();
    }


    public boolean IdMeetsCriteria(char first, char second, int numberTimesSecond) {
        String searchId = getId();
        int characterCount = 0;

        if (searchId.contains(Character.toString(first)) &&
                searchId.contains(Character.toString(second))) {

            for (int index = searchId.indexOf(first); index < searchId.length(); index++)
                if (searchId.charAt(index) == second)
                    characterCount++;

            if (characterCount == numberTimesSecond)
                return true;
        }

        return false;
    }
}
