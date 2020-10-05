package biz.orderit.orderit.repository;

import biz.orderit.orderit.pojo.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    public Optional<Restaurant> findRestaurantByAddress_City();
}
