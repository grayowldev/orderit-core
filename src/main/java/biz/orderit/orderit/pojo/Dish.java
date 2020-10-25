package biz.orderit.orderit.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document(collection = "dish_inventory")
public class Dish {

    @Id
    String id;
    String name, description,image,originCategory,origin, restaurantId;
    Double price;
    Integer quantity;
    HashMap<String,Double> options;

    public Dish() {
    }

    public Dish(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOriginCategory() {
        return originCategory;
    }

    public void setOriginCategory(String originCategory) {
        this.originCategory = originCategory;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public HashMap<String, Double> getOptions() {
        return options;
    }

    public void setOptions(HashMap<String, Double> options) {
        this.options = options;
    }

    public String getRestauraantId() {
        return restaurantId;
    }

    public void setRestauraantId(String restauraantId) {
        this.restaurantId = restauraantId;
    }
}
