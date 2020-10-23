package biz.orderit.orderit.apiController;

import biz.orderit.orderit.pojo.Order;
import biz.orderit.orderit.sevice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<List<Order>> getOrdersByRestaurantId(@PathVariable String restaurantId){
        return new ResponseEntity<>(
                orderService.getOrdersByRestaurantId(restaurantId),
                HttpStatus.OK
        );
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable String customerId){
        return new ResponseEntity<>(
                orderService.getOrdersByCustomerId(customerId),
                HttpStatus.OK
        );
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderByOrderId(@PathVariable String orderId){
        return new ResponseEntity<>(
                orderService.getOrderByOrderId(orderId),
                HttpStatus.OK
        );
    }

    // TODO: 10/22/20 Rethink the way this function works, the function could return the whole order list.
    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody Order order){
        return new ResponseEntity<>(
                orderService.addOrder(order),
                HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        return new ResponseEntity<>(
                orderService.updateOrder(order),
                HttpStatus.OK
        );
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrder(@RequestBody Order order) {
        return new ResponseEntity<>(
                orderService.deleteOrder(order),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<String> deleteOrderByRestaurantId(@PathVariable String orderId, @PathVariable String restaurantId){
        return new ResponseEntity<>(
                orderService.deleteOrderByRestaurantId(orderId, restaurantId),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteOrderByCustomerId(@PathVariable String orderId, @PathVariable String customerId){
        return new ResponseEntity<>(
                orderService.deleteOrderByCustomerId(orderId, customerId),
                HttpStatus.OK
        );
    }
}
