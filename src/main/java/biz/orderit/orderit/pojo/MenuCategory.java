package biz.orderit.orderit.pojo;

import java.util.List;

public class MenuCategory {
    String id,name;
    List<Dish> dishList;

    public MenuCategory() {
    }

    public MenuCategory(String id, String name, List<Dish> dishList) {
        this.id = id;
        this.name = name;
        this.dishList = dishList;
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
}
