package Parcel;

/**
 In the following questions, you will write a parent class that describes a
 parcel (like a package, as shown below) and a child class that describes an
 overnight parcel.

 A parcel is described by:

 id (which might contain numbers and letters)
 weight (described as the number of pounds; a parcel could be less than 1 pound)
 An overnight parcel is described by id and weight and also:

 whether or not a signature is required upon delivery.

 Questions:


 Write a toString method. The text representation of a parcel should include the id and weight.

 Override the equals method inherited from object. Two parcels are the same (logically equivalent) if they have the
 same id (ignoring capitalization).

 Sometimes an id can contain characters that represent some information.

 Write a method to determine whether a Parcel's id meets some criteria. The criteria is described by three pieces of
 data, passed in as parameters: char first, char second, int numberTimesSecond. In order for a parcel's id to meet the
 criteria, the id must contain the first character and then the second character must appear that number of times after
 the first character.

 Write code that would go inside the main method of a driver/tester program.
    Create two parcel objects. Use both constructors.
    Invoke the method you wrote above on the first object using 'x', 'm', and 2 as parameters; store the returned result in a local variable.
    Print a text representation of the second object to the console.

 Write the follow for the child overnight parcel class:
    the child class header
    the instance data variables
    one constructor that takes in all three pieces of information that describe an overnight parcel


 */

public class Parcel {

    static final double DEFAULT_WEIGHT = 1;

    private String id;
    private double weight;


    public Parcel(String newId) {
        Parcel(newId, DEFAULT_WEIGHT);
    }


    public Parcel(String newId, double newWeight) {
        id = setId(newId);
        weight = setWeight(newWeight);
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

            else
                throw new IllegalArgumentException("Parcel weight must be greater than zero.");
        }

        catch (IllegalArgumentException e) {
            System.out.println("ERROR CREATING PACKAGE: " + e.getMessage());
        }
    }


    public void setId(String newId) {
        id = newId;
    }


    public String toString() {
        return "The parcel's id is: " + getId() + ".\nThe parcel's weight is: " + getWeight() + " pounds.";
    }
}
