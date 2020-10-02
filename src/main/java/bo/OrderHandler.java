package bo;

import ui.OrderInfo;

import java.util.List;
import java.util.stream.Collectors;

public class OrderHandler {

    public static long placeOrder(OrderInfo orderInfo) {
        List<Product> products = orderInfo.getProducts().stream().map(productInfo -> new Product(productInfo.getName(), productInfo.getPrice())).collect(Collectors.toList());
        Order order = new Order(products, orderInfo.getUsername(), orderInfo.getTimestamp());
        return Order.PlaceOrder(order);
    }
}
