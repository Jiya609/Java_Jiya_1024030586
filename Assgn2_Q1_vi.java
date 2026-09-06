package food.service;

import food.model.FoodOrder;
import food.utility.OrderUtility;

public class OrderService {

    public void displayBills(FoodOrder[] orders) {

        for (FoodOrder order : orders) {

            if (order != null) {
                OrderUtility.generateOrderSummary(order);
            }
        }
    }
}
