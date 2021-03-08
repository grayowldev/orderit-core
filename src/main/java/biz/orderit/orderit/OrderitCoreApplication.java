package biz.orderit.orderit;

import biz.orderit.orderit.pojo.*;
import biz.orderit.orderit.repository.*;
import biz.orderit.orderit.sevice.AuthService;
import biz.orderit.orderit.sevice.CartService;
import biz.orderit.orderit.sevice.MenuCategoryListService;
import biz.orderit.orderit.sevice.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class OrderitCoreApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestaurantAuthRepository restaurantAuthRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuCategoryListRepository menuCategoryListRepository;

    @Autowired
    private MenuCategoryListService menuCategoryListService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private MenuService menuService;


    public static void main(String[] args) {
        SpringApplication.run(OrderitCoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        // Generating Sample Restaurant
        Restaurant sumRamen = new Restaurant("100", "Sum Ramen", new Address("188", "Essex Street", "Millburn","NJ","07041"));
        Restaurant ziggs = new Restaurant("1","Zigg's",new Address("14","JFK Blvd","New York","NY","10001"));

        // Generate Sample Dishes
        Dish edamame,karaage,gyoza,misoRamen,beefRamen,seafoodRamen;
        edamame = new Dish("Edamame","Toasted edamame w/ sea salt and butter.",5.50);
        karaage = new Dish("Karaage Chicken Wings","Fried crispy chicken wing w/ sweet garlic soy sauce or spicy mayo.",9.00);
        gyoza = new Dish("Pork or Chicken Gyoza","Pan fried dumping w/ special garlic sauce.",8.00);
        misoRamen = new Dish("Miso Ramen","Pork chashu or chicken w/ bean sprouts, wood ear mushroom, scallion, Nori and fried onion Complemented by chicken broth.",15.00);
        beefRamen = new Dish("Beef Ramen","Slow cooked beef short ribs, spinach, bamboo shoots and leek. Complemented by beef broth.",17.00);
        seafoodRamen = new Dish("Seafood Ramen","Shrimp, calamari, clam and scallop grilled w/ butter and garlic. Served w/ spinach, corn and leeks.",20.00);

        // Generate Menu Categories
        MenuCategoryList appetizer = new MenuCategoryList(sumRamen.getId(),"Appetizer");
        MenuCategoryList ramen = new MenuCategoryList(sumRamen.getId(), "Ramen (House-made Broth)");
        menuCategoryListService.addCategoryToList(appetizer);
        menuCategoryListService.addCategoryToList(ramen);

        MenuCategory c1 = new MenuCategory(appetizer.getName());
        MenuCategory c2 = new MenuCategory(ramen.getName());

        c1.addDish(edamame);
        c1.addDish(karaage);
        c1.addDish(gyoza);
        c2.addDish(misoRamen);
        c2.addDish(beefRamen);
        c2.addDish(seafoodRamen);

        Menu sumRamenMenu = new Menu(sumRamen.getId());
        sumRamenMenu.addMenuCategory(c1);
        sumRamenMenu.addMenuCategory(c2);

        sumRamen.setMenu(sumRamenMenu);
        restaurantRepository.save(sumRamen);

//
//        menuService.addDishToRestaurantMenu("100","604552691e1ddb33c432b447",edamame);
//        menuService.addDishToRestaurantMenu("100","604552691e1ddb33c432b447",karaage);
//        menuService.addDishToRestaurantMenu("100", "604552691e1ddb33c432b447",gyoza);
//        menuService.addDishToRestaurantMenu("100","604552691e1ddb33c432b448",misoRamen);
//        menuService.addDishToRestaurantMenu("100","604552691e1ddb33c432b448",beefRamen);
//        menuService.addDishToRestaurantMenu("100","604552691e1ddb33c432b448",seafoodRamen);





        ArrayList<MenuCategoryList> categoryList = (ArrayList<MenuCategoryList>) menuCategoryListService.getCategoryListByRestaurantId(sumRamen.getId());

        for (MenuCategoryList category: categoryList){
            System.out.println(category);
        }

//        // Add sample category list
//        MenuCategoryList unassigned = new MenuCategoryList(ziggs.getId(), "Unassigned");
//        MenuCategoryList breakfast = new MenuCategoryList(ziggs.getId(), "Breakfast");
//        String r1 = menuCategoryListService.addCategoryToList(unassigned);
//        String r2 = menuCategoryListService.addCategoryToList(breakfast);
//        System.out.println(r1);
//        System.out.println(r2);
//
//        ArrayList<MenuCategoryList> categoryList = (ArrayList<MenuCategoryList>) menuCategoryListService.getCategoryListByRestaurantId(ziggs.getId());
//
//        for (MenuCategoryList cat : categoryList){
//            System.out.println(cat);
//        }


        Dish dish1 = new Dish("No.1 Shoyu",
                "classic chicken broth, shoyu tare, kakuni (pork belly), cabbage, chives, scallions, black garlic oil",
                13.00);
        MenuCategory cat = new MenuCategory("RAMEN BOWL $13");
        MenuCategory cat2 = new MenuCategory("Category 2");
        MenuCategory cat3 = new MenuCategory("Category 3");

        cat.addDish(dish1);
        cat2.addDish(dish1);
        cat3.addDish(dish1);

        Menu menu = new Menu(ziggs.getId());
        menu.addMenuCategory(cat);
        menu.addMenuCategory(cat2);
        menu.addMenuCategory(cat3);

        ziggs.setMenu(menu);
        restaurantRepository.save(ziggs);


        // _____________________________________
        // _____________________________________
        // _____________________________________

        // Since we want to test our cart, lets create a cart and add a dish to it
        Cart myCart = new Cart("12345", "54321", 0.00);
        List<Dish> testMyDish = new ArrayList<Dish>();
        testMyDish.add(dish1);
        myCart.setDishList(testMyDish);
        // Now we want to save this cart to our repository - so it technically saves to the MongoDB
        cartRepository.save(myCart);
        // Then in order to display the cart (because we want to see if its working)
        System.out.println(cartService.getCartByCustomerId("54321"));


        Dish dish2 = new Dish("Hamburger", "this is with lettuce tomato and no burgers actually. Ha.", 8.00);
        System.out.println(cartService.addDishToCartByCustomerId("54321", dish2));
        // _____________________________________
        // _____________________________________
        // _____________________________________
        Dish dish3 = new Dish("Halal", "Gyro", 9.00);
        System.out.println(menuService.addDishToRestaurantMenu("1", "5f8e6c1014ced779da3cbaeb", dish3));

        System.out.println("__________________________________________");
        System.out.println(menuService.getMenuByRestaurantId("1"));




    }
}
