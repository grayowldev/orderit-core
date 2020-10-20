package biz.orderit.orderit.sevice;

import biz.orderit.orderit.pojo.Cart;
import biz.orderit.orderit.pojo.Dish;
import biz.orderit.orderit.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart getCartByCustomerId(String customerId){
        return cartRepository.findCartByCustomerId(customerId);
    }

    public String addDishToCartByCustomerId(String customerId, Dish dish){
        // October 20, 2020 TODO: This would make sense in most scenarios. But this line of code will break if it tries to get a customerId that doesn't exist.
        Cart customerCart = cartRepository.findCartByCustomerId(customerId);
        customerCart.addDishToCart(dish);
        cartRepository.save(customerCart);
        return "Added dish successful";
    }

    /* October 20, 2020 TODO methods:
        • Update and Remove dish in cart by foodieId
    */
}
