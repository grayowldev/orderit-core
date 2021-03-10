package biz.orderit.orderit.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menu_category_list")
public class MenuCategoryList {

    @Id
    String categoryId;
    String restaurantId;
    String name;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuCategoryList(String restaurantId, String name) {
        this.restaurantId = restaurantId;
        this.name = name;
    }

    public MenuCategoryList(String restaurantId, String name, String categoryId){
        this.restaurantId = restaurantId;
        this.name = name;
        this.categoryId = categoryId;
    }

    public MenuCategoryList() {
    }



    @Override
    public String toString() {
        return "MenuCategoryList{" +
                "restaurantId='" + restaurantId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
