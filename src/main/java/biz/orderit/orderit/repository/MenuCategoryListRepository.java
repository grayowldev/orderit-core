package biz.orderit.orderit.repository;

import biz.orderit.orderit.pojo.MenuCategoryList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MenuCategoryListRepository extends MongoRepository<MenuCategoryList,String> {
    public List<MenuCategoryList> findMenuCategoryListsByRestaurantId(String restaurantId);
    public Optional<MenuCategoryList> findMenuCategoryListByRestaurantIdAndAndName(String restaurantId, String name);
    public Optional<MenuCategoryList> findMenuCategoryListByCategoryIdAndRestaurantId(String categoryId, String restaurantId);

}
