package biz.orderit.orderit.sevice;


import biz.orderit.orderit.pojo.MenuCategory;
import biz.orderit.orderit.pojo.MenuCategoryList;
import biz.orderit.orderit.repository.MenuCategoryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuCategoryListService {

    @Autowired
    MenuCategoryListRepository menuCategoryListRepository;

    public String addCategoryToList(MenuCategoryList menuCategoryList){
        // Optional - when mongoDB doesn't find a record (so it doesn't break)
        //TODO need to ignore case / compare both values by lowercase
        Optional<MenuCategoryList> category =  menuCategoryListRepository.findMenuCategoryListByRestaurantIdAndAndName(menuCategoryList.getRestaurantId(),menuCategoryList.getName());
        if (category.isEmpty()){
            menuCategoryListRepository.save(menuCategoryList);
            return "added\n" + menuCategoryList.toString();
        } else {
            return "category in list";
        }
    }

    public List<MenuCategoryList> getCategoryListByRestaurantId(String restaurantId){
        return  menuCategoryListRepository.findMenuCategoryListsByRestaurantId(restaurantId);
    }

    // TODO: 10/19/20 Add delete category
    public String deleteCategoryListByCategoryId(String categoryId){
        menuCategoryListRepository.deleteById(categoryId);
        return "Category with id "+ categoryId + " was deleted successfully";
    }

    // TODO: 10/19/20 Update category in list
    public String updateCategoryListByCategoryId(String restaurantId, String categoryId, MenuCategoryList menuCategoryList){
        return null;
    }


}
