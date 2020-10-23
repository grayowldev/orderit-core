package biz.orderit.orderit.sevice;

import biz.orderit.orderit.pojo.Order;
import biz.orderit.orderit.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getOrdersByRestaurantId(String restaurantId){
        return null;
    }

    public List<Order> getOrdersByCustomerId(String customerId){
        return null;
    }

    public Order getOrderByOrderId(String orderId){
        return null;
    }

    public String addOrder(Order order){
        return null;
    }

    public Order updateOrder(Order order){
        return null;
    }

    public String deleteOrderByRestaurantId(String orderId,String restaurantId){
        return null;
    }

    public String deleteOrderByCustomerId(String orderId, String customerId){
        return null;
    }

    public String deleteOrder(Order order){
        return null;
    }
}
