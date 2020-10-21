package biz.orderit.orderit.apiController;

import biz.orderit.orderit.pojo.Dish;
import biz.orderit.orderit.pojo.Menu;
import biz.orderit.orderit.pojo.Restaurant;
import biz.orderit.orderit.sevice.MenuCategoryListService;
import biz.orderit.orderit.sevice.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {

    // return responseEntity : A list of menu category objects - getMenuByRestaurantId() from service
    @Autowired
    private MenuService menuService;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Menu> getMenu(@PathVariable("restaurantId") String restaurantId){
        Menu menu = menuService.getMenuByRestaurantId(restaurantId);
        if(menu != null){
            return new ResponseEntity<>(menu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> addDishToRestaurantMenu(@PathVariable("restaurantId") String restaurantId,@PathVariable("categoryId") String categoryId, @RequestBody Dish dish) {
        String dishAdded = menuService.addDishToRestaurantMenu(restaurantId, categoryId, dish);
        if(dishAdded != null){
            return new ResponseEntity<>(dishAdded, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //TODO: Delete dish by id

    //TODO deleteMenuById - Name: Abhimanyu

    //TODO updateMenuById - Name: Abhimanyu

    // return
    @PostMapping("/{restaurantId}/{categoryId}")
    public ResponseEntity<String> addDishByCategory(@PathVariable("restaurantId") String restaurantId,@PathVariable("categoryId") String categoryId, @RequestBody Dish dish){
        return null;
    }

    @PutMapping("/{restaurantId}/{categoryId}")
    public ResponseEntity<String> updateDishByCategory(@PathVariable("restaurantId") String restaurantId,@PathVariable("categoryId") String categoryId, @RequestBody Dish dish){
        return null;
    }
}
