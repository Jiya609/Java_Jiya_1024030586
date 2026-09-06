package library.service;

import library.model.LibraryResource;
import library.model.Printable;
import library.util.InputValidator;

public class LibraryService {

    // Display all resource details
    public void displayResources(LibraryResource[] resources) {

        for (LibraryResource resource : resources) {

            if (resource != null) {

                Printable printable = (Printable) resource;

                printable.printDetails();
            }
        }
    }

    // Calculate total fine
    public double calculateTotalFine(
            LibraryResource[] resources,
            int[] overdueDays) {

        double totalFine = 0;

        for (int i = 0; i < resources.length; i++) {

            if (resources[i] != null) {

                if (InputValidator.validateFineDays(overdueDays[i])) {

                    double fine =
                            resources[i].calculateFine(overdueDays[i]);

                    totalFine = totalFine + fine;
                }
            }
        }

        return totalFine;
    }
}
