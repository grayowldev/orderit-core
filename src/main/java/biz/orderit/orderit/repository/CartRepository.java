package biz.orderit.orderit.repository;

import java.util.List;
import java.util.Optional;

import biz.orderit.orderit.pojo.Cart;
import biz.orderit.orderit.pojo.MenuCategoryList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {
    public Cart findCartByCustomerId(String customerId);
}
