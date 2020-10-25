package biz.orderit.orderit.repository;

import biz.orderit.orderit.pojo.Dish;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DishInventoryRepository extends MongoRepository<Dish, String> {
    Optional<Dish> findDishByName(String name);
    Optional<List<Dish>> findDishesByRestaurantId(String restaurantId);
    Optional<Dish> findDishById(String dishId);
}
