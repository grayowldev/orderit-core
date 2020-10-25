package biz.orderit.orderit.repository;

import biz.orderit.orderit.pojo.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findCartByCustomerId(String customerId);
}
