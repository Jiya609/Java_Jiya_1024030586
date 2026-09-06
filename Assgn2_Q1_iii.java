package food.model;

public class RegularOrder extends FoodOrder implements Discountable {

    // Constructor
    public RegularOrder(int orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    // Overriding abstract method
    @Override
    public double calculateDeliveryCharge() {
        return 80;
    }

    // Overriding interface method
    @Override
    public double applyDiscount() {
        return getAmount() * 0.10;
    }
}
