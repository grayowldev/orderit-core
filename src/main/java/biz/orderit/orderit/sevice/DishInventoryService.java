package biz.orderit.orderit.sevice;

import biz.orderit.orderit.pojo.Dish;
import biz.orderit.orderit.pojo.Restaurant;
import biz.orderit.orderit.repository.DishInventoryRepository;
import biz.orderit.orderit.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishInventoryService {

    @Autowired
    private DishInventoryRepository dishInventoryRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Dish> getDishInventory(String restaurantId){
        Optional<List<Dish>> dishesOpt  = dishInventoryRepository.findDishesByRestaurantId(restaurantId);
        if (dishesOpt != null){
            List<Dish> dishes = dishesOpt.get();
            return dishes;
        } else {
            return null;
        }

    }

    public Dish getDishById(String dishId){
        Optional<Dish> dish = dishInventoryRepository.findDishById(dishId);
        if (dish != null){
            return dish.get();
        }else
            return null;
    }

    public Dish getDishByDishName(String dishName){
        Optional<Dish> dish = dishInventoryRepository.findDishByName(dishName);
        if (dish != null){
            return dish.get();
        }else
            return null;
    }

    public String addDishToInventory(Dish dish, String restaurantId){
        Optional<Restaurant> restaurant = restaurantRepository.findRestaurantById(restaurantId);
        if(restaurant.isEmpty()){
            return null;
        }
        dish.setRestaurantId(restaurantId);
        dishInventoryRepository.save(dish);
        return "Dish was successfully added to inventory";

    }

    public String updateDish(Dish dish){
        dishInventoryRepository.save(dish);
        return "dish updated";
    }

    public String deleteDishById(Dish dish){
        dishInventoryRepository.deleteById(dish.getId());
        return "dish deleted";
    }


}
