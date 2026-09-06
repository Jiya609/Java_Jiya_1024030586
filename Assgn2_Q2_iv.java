package library.model;

public class DigitalResource extends LibraryResource implements Printable {

    // Constructor
    public DigitalResource(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    // Fine calculation
    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2;
    }

    // Print details
    @Override
    public void printDetails() {

        System.out.println("----------------------------------------");
        System.out.println("Resource Type: Digital Resource");

        // Calling protected method
        displayBasicDetails();

        System.out.println("Fine Rate    : Rs. 2/day");
        System.out.println("----------------------------------------");
    }
}
