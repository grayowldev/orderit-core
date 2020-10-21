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

        Restaurant ziggs = new Restaurant("1","Zigg's",new Address("14","JFK Blvd","New York","NY","10001"));

        // Add sample category list

        MenuCategoryList unassigned = new MenuCategoryList(ziggs.getId(), "Unassigned");
        MenuCategoryList breakfast = new MenuCategoryList(ziggs.getId(), "Breakfast");
        String r1 = menuCategoryListService.addCategoryToList(unassigned);
        String r2 = menuCategoryListService.addCategoryToList(breakfast);
        System.out.println(r1);
        System.out.println(r2);

        ArrayList<MenuCategoryList> categoryList = (ArrayList<MenuCategoryList>) menuCategoryListService.getCategoryListByRestaurantId(ziggs.getId());

        for (MenuCategoryList cat : categoryList){
            System.out.println(cat);
        }


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
//
//        Restaurant restaurant = new Restaurant("1","Joes",new Address());
//        restaurant.setMenu(menu);
//        restaurantRepository.save(restaurant);
//
//
//
//
//
//        Customer c1 = new Customer("1", "Sam Smith",new Address("7", "Westminster Ave", "London",null,null));
//        Customer c2 = new Customer("2", "Elon Musk", new Address("14","JFK Blvd","New York","NY","10001"));
//        RestaurantAuth user = new RestaurantAuth("1","abc@email.com","123456");
////
//        customerRepository.save(c1);
//        customerRepository.save(c2);
////
//        System.out.println("\n****************************\n");
////
//        List<Customer> customers = customerRepository.findAll();
////
//        for (Customer c: customers)
//            System.out.println(c.toString());
//
//        String s = authService.createRestaurantUser(user);
//        System.out.println(s);
//
//
//
//
//        // ______________________________________________
//        System.out.println("\n");
//        Optional<RestaurantAuth> name = restaurantAuthRepository.findRestaurantAuthById("877393");
//        System.out.println(name.toString());
//
//        // ______________________________________________
//        System.out.println("\n");
//        Optional<RestaurantAuth> name2 = restaurantAuthRepository.findRestaurantAuthByEmailAndAndPassword("email@email.com", "password123456");
//        System.out.println(name2);
//        System.out.println(name2.toString());
//        if(name2.isEmpty())
//            System.out.println("this is empty");
//
//
//
//        Optional<Restaurant> r = restaurantRepository.findById("1");
//
//        if (!r.isEmpty()){
//            Restaurant x = r.get();
//            for (MenuCategory menuCategory : x.getMenu().getCategories()){
//                System.out.println(menuCategory);
//            }
////            System.out.println(x.getMenu());
//        }


    }
}
