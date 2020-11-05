package biz.orderit.orderit.apiController;

import biz.orderit.orderit.pojo.Cart;
import biz.orderit.orderit.pojo.Dish;
import biz.orderit.orderit.sevice.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Cart> getCartByCustomerId(@PathVariable String customerId){
        // October 20, 2020 TODO: This would make sense in most scenarios. But this line of code will break if it tries to get a customerId that doesn't exist.
        return new ResponseEntity<>(cartService.getCartByCustomerId(customerId), HttpStatus.OK);
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<String> addDishToCartByCustomerId(@PathVariable String customerId, @RequestBody Dish dish){
        // October 20, 2020 TODO: This would make sense in most scenarios. But this line of code will break if it tries to get a customerId that doesn't exist.
        return new ResponseEntity<>(cartService.addDishToCartByCustomerId(customerId, dish), HttpStatus.OK);
    }



}

/*
October 20, 2020 TODO:
    → Carts Controller:
    Update and Remove dish in cart by foodieId

    GET POST PUT DELETE PATCH*
 */
