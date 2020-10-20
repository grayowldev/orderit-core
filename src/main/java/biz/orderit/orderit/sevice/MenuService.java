package biz.orderit.orderit.sevice;

import biz.orderit.orderit.pojo.Menu;
import biz.orderit.orderit.pojo.Restaurant;
import biz.orderit.orderit.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {

    // get menu
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Menu getMenuByRestaurantId(String id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findRestaurantById(id);
        if(restaurantOptional.isEmpty()){
            return null;
        } else {
            return restaurantOptional.get().getMenu();
            // .get() returns the restaurant and then .getMenu() its menu
        }
    }

    //TODO addMenu - Name: Abhimanyu

    //TODO deleteMenuById - Name: Abhimanyu

    //TODO updateMenuById - Name: Abhimanyu
}
