package biz.orderit.orderit.repository;

import biz.orderit.orderit.pojo.Order;
import biz.orderit.orderit.sevice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderRepository {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<List<Order>> getOrdersByRestaurantId(@PathVariable String restaurantId){
        return null;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable String customerId){
        return null;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderByOrderId(@PathVariable String orderId){
        return null;
    }

    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody Order order){
        return null;
    }

    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        return null;
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrderByOrderId(@PathVariable String orderId) {
        return null;
    }
}
