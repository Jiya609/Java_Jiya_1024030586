package library.model;

public class Book extends LibraryResource implements Printable {

    // Constructor
    public Book(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    // Fine calculation
    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 5;
    }

    // Print details
    @Override
    public void printDetails() {

        System.out.println("----------------------------------------");
        System.out.println("Resource Type: Book");

        // Calling protected method
        displayBasicDetails();

        System.out.println("Fine Rate    : Rs. 5/day");
        System.out.println("----------------------------------------");
    }
}
