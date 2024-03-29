package biz.orderit.orderit.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "restaurant")
public class MenuCategory {
    @Id
    String id;
    String name;
    List<Dish> dishList;

    public MenuCategory() {
    }

    public MenuCategory(String name) {
        this.name = name;
        this.dishList = new ArrayList<Dish>();
    }

    public MenuCategory(String name, String id) {
        this.name = name;
        this.id = id;
        this.dishList = new ArrayList<Dish>();
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

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public void addDish(Dish dish){
        dishList.add(dish);
    }

    @Override
    public String toString() {
        return "MenuCategory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dishList=" + dishList +
                '}';
    }
}
