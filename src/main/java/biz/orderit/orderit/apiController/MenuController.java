package biz.orderit.orderit.apiController;

import biz.orderit.orderit.pojo.Dish;
import biz.orderit.orderit.sevice.MenuCategoryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {



    @GetMapping("/{restaurantId}")
    public ResponseEntity<String> getMenu(@PathVariable("restaurantId") String restaurantId){
        return null;
    }

    @PostMapping("/{restaurantId}/{categoryId}")
    public ResponseEntity<String> addDishByCategory(@PathVariable("restaurantId") String restaurantId,@PathVariable("categoryId") String categoryId, @RequestBody Dish dish){
        return null;
    }

    @PutMapping("/{restaurantId}/{categoryId}")
    public ResponseEntity<String> updateDishByCategory(@PathVariable("restaurantId") String restaurantId,@PathVariable("categoryId") String categoryId, @RequestBody Dish dish){
        return null;
    }

    //TODO: Delete dish by id
}
