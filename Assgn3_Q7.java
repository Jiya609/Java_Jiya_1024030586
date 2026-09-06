import java.util.ArrayList;
import java.util.Scanner;

class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String message) {
        super(message);
    }
}

class InvalidQuantityException extends Exception {

    public InvalidQuantityException(String message) {
        super(message);
    }
}

class EmptyCartException extends Exception {

    public EmptyCartException(String message) {
        super(message);
    }
}

class PaymentFailedException extends Exception {

    public PaymentFailedException(String message) {
        super(message);
    }
}

class Product {

    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart {

    ArrayList<Product> cart = new ArrayList<>();

    Product[] products = {

        new Product(101, "Laptop", 50000),

        new Product(102, "Mouse", 800),

        new Product(103, "Keyboard", 1500),

        new Product(104, "Headphones", 2500),

        new Product(105, "Monitor", 12000)
    };

    // Search product
    Product searchProduct(int id)
            throws ProductNotFoundException {

        for (Product p : products) {

            if (p.id == id) {
                return p;
            }
        }

        throw new ProductNotFoundException(
            "Product with ID " + id + " not found."
        );
    }

    // Add product
    void addProduct(int id, int quantity)
            throws ProductNotFoundException,
                   InvalidQuantityException {

        if (quantity <= 0) {

            throw new InvalidQuantityException(
                "Quantity must be greater than zero."
            );
        }

        Product product = searchProduct(id);

        for (int i = 0; i < quantity; i++) {

            cart.add(product);
        }

        System.out.println(
            product.name + " added to cart."
        );
    }

    // Remove product
    void removeProduct(int id)
            throws ProductNotFoundException,
                   EmptyCartException {

        if (cart.isEmpty()) {

            throw new EmptyCartException(
                "Cart is empty."
            );
        }

        Product product = searchProduct(id);

        if (!cart.remove(product)) {

            throw new ProductNotFoundException(
                "Product is not present in cart."
            );
        }

        System.out.println(
            product.name + " removed from cart."
        );
    }

    // Display cart
    void displayCart()
            throws EmptyCartException {

        if (cart.isEmpty()) {

            throw new EmptyCartException(
                "Cart is empty."
            );
        }

        double total = 0;

        System.out.println("\n----- CART -----");

        for (Product p : cart) {

            System.out.println(
                p.id + "  "
                + p.name + "  Rs. "
                + p.price
            );

            total += p.price;
        }

        System.out.println(
            "Total: Rs. " + total
        );
    }

    // Payment
    void makePayment(double amount)
            throws EmptyCartException,
                   PaymentFailedException {

        if (cart.isEmpty()) {

            throw new EmptyCartException(
                "Cannot make payment. Cart is empty."
            );
        }

        double total = 0;

        for (Product p : cart) {

            total += p.price;
        }

        if (amount < total) {

            throw new PaymentFailedException(
                "Payment failed. Insufficient amount."
            );
        }

        System.out.println(
            "Payment successful!"
        );

        System.out.println(
            "Amount paid: Rs. " + amount
        );

        System.out.println(
            "Change: Rs. " + (amount - total)
        );

        cart.clear();
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ShoppingCart shoppingCart =
                new ShoppingCart();

        try {

            // Search
            System.out.print(
                "Enter product ID to search: "
            );

            int searchId = sc.nextInt();

            Product product =
                    shoppingCart.searchProduct(searchId);

            System.out.println(
                "Product found: "
                + product.name
                + " - Rs. "
                + product.price
            );

            // Add
            System.out.print(
                "\nEnter product ID to add: "
            );

            int addId = sc.nextInt();

            System.out.print(
                "Enter quantity: "
            );

            int quantity = sc.nextInt();

            shoppingCart.addProduct(
                addId,
                quantity
            );

            // Display
            shoppingCart.displayCart();

            // Remove
            System.out.print(
                "\nEnter product ID to remove: "
            );

            int removeId = sc.nextInt();

            shoppingCart.removeProduct(
                removeId
            );

            // Display again
            shoppingCart.displayCart();

            // Payment
            System.out.print(
                "\nEnter payment amount: "
            );

            double payment = sc.nextDouble();

            shoppingCart.makePayment(payment);

        }
        catch (ProductNotFoundException e) {

            System.out.println(
                "Product Error: "
                + e.getMessage()
            );
        }
        catch (InvalidQuantityException e) {

            System.out.println(
                "Quantity Error: "
                + e.getMessage()
            );
        }
        catch (EmptyCartException e) {

            System.out.println(
                "Cart Error: "
                + e.getMessage()
            );
        }
        catch (PaymentFailedException e) {

            System.out.println(
                "Payment Error: "
                + e.getMessage()
            );
        }
        finally {

            System.out.println(
                "\nShopping application completed."
            );

            sc.close();
        }
    }
}
