package biz.orderit.orderit.apiController;

import biz.orderit.orderit.pojo.Dish;
import biz.orderit.orderit.sevice.DishInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/DishList")
public class DishInventoryController {

    @Autowired
    private DishInventoryService dishInventoryService;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<List<Dish>> getDishInventory(@PathVariable String restaurantId){
        List<Dish> dishlist = dishInventoryService.getDishInventory(restaurantId);
        if (dishlist != null){
            return new ResponseEntity<>(
                    dishlist,
                    HttpStatus.OK
            );
        }else {
            return null;
        }
    }

    @GetMapping("/{dishId}")
    public ResponseEntity<Dish> getDishById(@PathVariable String dishId){
        Dish dish = dishInventoryService.getDishById(dishId);
        if (dish != null){
            return new ResponseEntity<>(
                    dish,
                    HttpStatus.OK
            );
        }else {
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<String> addDishToInverntory(@RequestBody Dish dish){
        String status = dishInventoryService.addDishToInventory(dish);
        if (status != null){
            return new ResponseEntity<>(
                    status,
                    HttpStatus.OK
            );
        }else {
            return null;
        }
    }

    @PutMapping
    public ResponseEntity<String> updateDish(@RequestBody Dish dish){
        String status = dishInventoryService.updateDish(dish);
        if (status != null){
            return new ResponseEntity<>(
                    status,
                    HttpStatus.OK
            );
        }else {
            return null;
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDishById(@RequestBody Dish dish){
        String status = dishInventoryService.deleteDishById(dish);
        if (status != null){
            return new ResponseEntity<>(
                    status,
                    HttpStatus.OK
            );
        }else {
            return null;
        }
    }


}
