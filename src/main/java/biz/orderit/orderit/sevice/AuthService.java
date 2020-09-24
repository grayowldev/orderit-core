package biz.orderit.orderit.sevice;

import biz.orderit.orderit.pojo.RestaurantAuth;
import biz.orderit.orderit.repository.RestaurantAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private RestaurantAuthRepository restaurantAuthRepository;


    //TODO
    public String createRestaurantUser(RestaurantAuth restaurantAuth){
        restaurantAuthRepository.save(restaurantAuth);
        return "saved";
    }

    //TODO
    public String createCustomerUser(){
        return null;
    }

    //TODO
    public String authenticateRestaurantUser(){
        return null;
    }

    //TODO
    public String getRestaurantUser(RestaurantAuth restaurantAuth){
        Optional<RestaurantAuth> theRestaurant = restaurantAuthRepository.findRestaurantAuthByEmailAndAndPassword(restaurantAuth.getEmail(), restaurantAuth.getPassword());
        if(theRestaurant.isEmpty())
            return null;
        else
            return theRestaurant.get().getId();
    }



}
