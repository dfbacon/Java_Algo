/*
Assume you have a class called Movie with instance data variables:

private String name;

private int year;

This class will now implement the Comparable interface.

Write the new class header for this class.
Write the complete compareTo method using the following logic:
movies are ordered first on year (smallest to largest) and then on name (ignoring capitalization)
in other words, if two movies have the same year, they will then be ordered based on their name
 */

public class Movie implements Comparable<Movie> {
    private String name;
    private int year;

    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }


    
    @Override
    public int compareTo(Movie obj) {

        if (this.year == obj.year) {
            return this.name.compareToIgnoreCase(obj.name);
        }

        return this.year - obj.year;
    }
}