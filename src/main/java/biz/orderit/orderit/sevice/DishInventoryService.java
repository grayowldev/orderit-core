package biz.orderit.orderit.sevice;

import biz.orderit.orderit.pojo.Dish;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishInventoryService {


    public List<Dish> getDishInventory(String restaurantId){
        return null;
    }

    public Dish getDishById(String dishId){
        return null;
    }

    public String addDishToInventory(Dish dish){
        return null;
    }

    public String updateDish(Dish dish){
        return null;
    }

    public String deleteDishById(Dish dish){
        return null;
    }


}
