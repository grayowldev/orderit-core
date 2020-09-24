package biz.orderit.orderit.apiController;

import biz.orderit.orderit.pojo.RestaurantAuth;
import biz.orderit.orderit.sevice.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RestaurantAuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/restaurant")
    public String createRestaurant(@RequestBody RestaurantAuth restaurantAuth){
        System.out.println(restaurantAuth.getEmail());
        return authService.createRestaurantUser(restaurantAuth);

    }
}
