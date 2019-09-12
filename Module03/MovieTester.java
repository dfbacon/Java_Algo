public class MovieTester {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Gone with the Wind", 1943);
        Movie movie2 = new Movie("Animal House", 1943);

        System.out.println(movie1.compareTo(movie2));
        System.out.println(movie2.compareTo(movie1));
    }
}