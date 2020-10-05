package biz.orderit.orderit.sevice;

import biz.orderit.orderit.pojo.Restaurant;
import biz.orderit.orderit.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurant(){
        return restaurantRepository.findAll();
    }

    public String createRestaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
        return "Restaurant Created";
    }

    public void updateRestaurant(){}

    public void deleteRestaurant(){}
}
