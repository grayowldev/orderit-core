package biz.orderit.orderit;

import biz.orderit.orderit.pojo.Address;
import biz.orderit.orderit.pojo.Customer;
import biz.orderit.orderit.pojo.RestaurantAuth;
import biz.orderit.orderit.repository.CustomerRepository;
import biz.orderit.orderit.sevice.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrderitCoreApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AuthService authService;

    public static void main(String[] args) {
        SpringApplication.run(OrderitCoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Customer c1 = new Customer("1", "Sam Smith",new Address("7", "Westminster Ave", "London",null,null));
        Customer c2 = new Customer("2", "Elon Musk", new Address("14","JFK Blvd","New York","NY","10001"));
        RestaurantAuth user = new RestaurantAuth("1","abc@email.com","123456");

        customerRepository.save(c1);
        customerRepository.save(c2);

        System.out.println("\n****************************\n");

        List<Customer> customers = customerRepository.findAll();

        for (Customer c: customers)
            System.out.println(c.toString());

        String s = authService.createRestaurantUser(user);
        System.out.println(s);


    }
}
