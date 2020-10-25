package biz.orderit.orderit.repository;

import biz.orderit.orderit.pojo.Dish;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DishRepository extends MongoRepository<Dish, String> {
    Optional<Dish> findDishByName(String name);
}
