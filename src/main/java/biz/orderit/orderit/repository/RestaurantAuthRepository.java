package biz.orderit.orderit.repository;

import biz.orderit.orderit.pojo.RestaurantAuth;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RestaurantAuthRepository extends MongoRepository<RestaurantAuth, String> {
    Optional<RestaurantAuth> findAll(RestaurantAuth restaurantAuth);
}
