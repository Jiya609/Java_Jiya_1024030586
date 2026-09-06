package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.service.OrderService;
import food.utility.OrderUtility;

public class Main {

    public static void main(String[] args) {

        // Set restaurant name
        FoodOrder.setRestaurantName("Food Palace");

        // Create array of FoodOrder
        FoodOrder[] orders = new FoodOrder[6];

        // Create six orders

        orders[0] = new RegularOrder(
                101,
                "Rahul",
                500
        );

        orders[1] = new PremiumOrder(
                102,
                "Priya",
                1000
        );

        orders[2] = new RegularOrder(
                103,
                "Aman",
                750
        );

        orders[3] = new PremiumOrder(
                104,
                "Neha",
                1200
        );

        orders[4] = new RegularOrder(
                105,
                "Riya",
                900
        );

        orders[5] = new PremiumOrder(
                106,
                "Karan",
                1500
        );

        // Display restaurant details

        System.out.println("========================================");
        System.out.println("       ONLINE FOOD DELIVERY");
        System.out.println("       Restaurant: "
                + FoodOrder.getRestaurantName());
        System.out.println("========================================");

        // Validate orders

        for (FoodOrder order : orders) {

            if (!OrderUtility.validateAmount(order.getAmount())) {
                System.out.println(
                        "Invalid amount for Order ID: "
                                + order.getOrderId()
                );
            }

            if (!OrderUtility.validateCustomerName(
                    order.getCustomerName())) {

                System.out.println(
                        "Invalid customer name for Order ID: "
                                + order.getOrderId()
                );
            }
        }

        // Display bills

        OrderService service = new OrderService();

        service.displayBills(orders);

        // Display total orders

        FoodOrder.displayTotalOrders();
    }
}
