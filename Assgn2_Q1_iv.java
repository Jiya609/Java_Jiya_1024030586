package food.model;

public class PremiumOrder extends FoodOrder implements Discountable {

    // Constructor
    public PremiumOrder(int orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    // Overriding abstract method
    @Override
    public double calculateDeliveryCharge() {
        return 50;
    }

    // Overriding interface method
    @Override
    public double applyDiscount() {
        return getAmount() * 0.15;
    }
}
