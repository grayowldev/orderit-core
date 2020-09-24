package biz.orderit.orderit.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurant_auth")
public class RestaurantAuth implements Auth {

    @Id
    String id;
    String email;
    String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RestaurantAuth(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public RestaurantAuth() {
    }

    @Override
    public int validateEmail() {
        return 0;
    }
}
