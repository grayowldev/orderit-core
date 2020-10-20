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

    // TODO: 10/18/20
    public String addCategoryToList(MenuCategoryList menuCategoryList){
        Optional<MenuCategoryList> category =  menuCategoryListRepository.findMenuCategoryListByRestaurantIdAndAndName(menuCategoryList.getRestaurantId(),menuCategoryList.getName());
        if (category.isEmpty()){
            menuCategoryListRepository.save(menuCategoryList);
            return "added\n" + menuCategoryList.toString();
        } else {
            return "category in list";
        }


    }

    // TODO: 10/18/20
    public List<MenuCategoryList> getCategoryListByRestaurantId(String restaurantId){
        return  menuCategoryListRepository.findMenuCategoryListsByRestaurantId(restaurantId);
    }

    // TODO: 10/19/20 Add delete category

    // TODO: 10/19/20 Update category in list

}
