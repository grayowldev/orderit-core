package biz.orderit.orderit.sevice;

import biz.orderit.orderit.pojo.*;
import biz.orderit.orderit.repository.DishInventoryRepository;
import biz.orderit.orderit.repository.MenuCategoryListRepository;
import biz.orderit.orderit.repository.RestaurantRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {

    // get menu
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuCategoryListRepository menuCategoryListRepository;

    @Autowired
    private DishInventoryRepository dishInventoryRepository;

    public Menu getMenuByRestaurantId(String id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findRestaurantById(id);
        if(restaurantOptional.isEmpty()){
            return null;
        } else {
            return restaurantOptional.get().getMenu();
            // .get() returns the restaurant and then .getMenu() its menu
        }
    }

    public String addDishToRestaurantMenu(String restaurantId, String categoryId, Dish dish){

        Optional<MenuCategoryList> categoryListOp
                = menuCategoryListRepository.findMenuCategoryListByCategoryIdAndRestaurantId(categoryId,restaurantId);

        if (categoryListOp.isPresent()){
            MenuCategoryList category = categoryListOp.get();
            MenuCategory menuCategory = new MenuCategory(category.getName(),category.getCategoryId());

//            dishInventoryRepository.save(dish);
//            Dish databaseDish = dishInventoryRepository.findDishByName(dish.getName()).get();
            ObjectId dishId = new ObjectId();
            dish.setId(dishId.toString());
            menuCategory.addDish(dish);
            Optional<Restaurant> rest = restaurantRepository.findRestaurantById(restaurantId);

            if (rest.isPresent()) {
                Restaurant newRest = rest.get();
                newRest.addDish(menuCategory);
                restaurantRepository.save(newRest);
                return "Successfully Added\n" + rest.toString();
            } else {
                return "Failed to add :(";
            }

        } else {
            return "Menu doesn't exists !";
        }
    }

//    TODO deleteMenuById - Name: Abhimanyu
//    public String deleteMenu(String id) {
//        Optional<Restaurant> rest = restaurantRepository.findRestaurantById(id);
//        if (rest.isPresent()) {
//            rest.get().
//        }
//    }

    //TODO updateMenuById - Name: Abhimanyu
}
