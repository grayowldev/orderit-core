package biz.orderit.orderit.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Menu {

    @Id
    String id; // same as restaurant id

    List<MenuCategory> categories;

    public Menu() {
        categories = new ArrayList<MenuCategory>();
    }

    public Menu(String id){
        this.id = id;
        categories = new ArrayList<MenuCategory>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MenuCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<MenuCategory> categories) {
        this.categories = categories;
    }

    public void addMenuCategory(MenuCategory category){
        categories.add(category);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", categories=" + categories +
                '}';
    }
}
