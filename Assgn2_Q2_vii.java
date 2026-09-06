package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.service.LibraryService;
import library.util.InputValidator;

public class Main {

    public static void main(String[] args) {

        // Set library name
        LibraryResource.setLibraryName(
                "Smart University Library"
        );

        // Create an array of LibraryResource
        LibraryResource[] resources =
                new LibraryResource[5];

        // Create five objects
        resources[0] =
                new Book(
                        101,
                        "Java Programming",
                        "James Gosling"
                );

        resources[1] =
                new DigitalResource(
                        102,
                        "Data Structures E-Book",
                        "Mark Allen"
                );

        resources[2] =
                new Book(
                        103,
                        "Operating Systems",
                        "Abraham Silberschatz"
                );

        resources[3] =
                new DigitalResource(
                        104,
                        "Database Systems",
                        "Raghu Ramakrishnan"
                );

        resources[4] =
                new Book(
                        105,
                        "Computer Networks",
                        "Andrew Tanenbaum"
                );

        // Overdue days for each resource
        int[] overdueDays = {
                3,
                5,
                2,
                10,
                4
        };

        // Validate Resource IDs
        for (LibraryResource resource : resources) {

            if (!InputValidator.validateResourceId(
                    resource.getResourceId())) {

                System.out.println(
                        "Invalid Resource ID: "
                                + resource.getResourceId()
                );
            }
        }

        // Display library information
        System.out.println("========================================");
        System.out.println("        SMART LIBRARY SYSTEM");
        System.out.println("        " + LibraryResource.getLibraryName());
        System.out.println("========================================");

        // Create service object
        LibraryService service =
                new LibraryService();

        // Display complete details
        System.out.println("\nRESOURCE DETAILS");

        service.displayResources(resources);

        // Display overdue days
        System.out.println("\nOVERDUE DETAILS");

        for (int i = 0; i < resources.length; i++) {

            System.out.println(
                    "Resource ID " +
                    resources[i].getResourceId() +
                    " : " +
                    overdueDays[i] +
                    " overdue days"
            );
        }

        // Calculate total fine
        double totalFine =
                service.calculateTotalFine(
                        resources,
                        overdueDays
                );

        System.out.println("\n========================================");
        System.out.println(
                "TOTAL FINE: Rs. " + totalFine
        );
        System.out.println("========================================");

        // Display total resources created
        LibraryResource.displayTotalResources();
    }
}
