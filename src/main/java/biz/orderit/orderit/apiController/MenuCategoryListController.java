package biz.orderit.orderit.apiController;
import biz.orderit.orderit.pojo.MenuCategoryList;
import biz.orderit.orderit.sevice.MenuCategoryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/categoryList")
public class MenuCategoryListController {

    @Autowired
    MenuCategoryListService menuCategoryListService;

    // TODO: 10/19/20 Get all categories by restaurant id
    @GetMapping("/{restaurantId}")
    public ResponseEntity<List<MenuCategoryList>> getCategoryListById(@PathVariable String restaurantId){
        return new ResponseEntity<List<MenuCategoryList>>(
                menuCategoryListService.getCategoryListByRestaurantId(restaurantId),
                HttpStatus.OK
        );
    }

    // TODO: 10/19/20 Get all categories by restaurant name and address
    public ResponseEntity<List<MenuCategoryList>> getCategoryListByNameAndAddress(String restaurantName, String restaurantAddress){
        return null;
    }

    // TODO: 10/19/20 Add category by restaurant id
    @PostMapping("/{restaurantId}")
    public ResponseEntity<String> addCategory(@PathVariable String restaurantId, @RequestParam String categoryName){
        MenuCategoryList menuCategoryList = new MenuCategoryList();
        menuCategoryList.setRestaurantId(restaurantId);
        menuCategoryList.setName(categoryName);
        return new ResponseEntity<>(
                menuCategoryListService.addCategoryToList(menuCategoryList),
                HttpStatus.OK
        );
    }

    // TODO: 10/19/20 Update category by restaurant id and category id - 16 days ago lul
    @PutMapping("/{restaurantId}/{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable String restaurantId, @PathVariable String categoryId){
        return null;

    }


    @DeleteMapping("/{restaurantId}/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable String restaurantId, @PathVariable String categoryId){

        List<MenuCategoryList> menuCategoryLists = menuCategoryListService.getCategoryListByRestaurantId(restaurantId);
        String returnStr = null;
        if(menuCategoryLists != null){
            boolean present = false;
            for (MenuCategoryList categoryList: menuCategoryLists ){
                if (categoryList.getCategoryId().equals(categoryId)){
                    present = true;
                    returnStr = menuCategoryListService.deleteCategoryListByCategoryId(categoryId);
                    break;
                }
            }
            if (!present){
                returnStr = "Category not in list";
            }
        }
        return new ResponseEntity<>(
                returnStr,
                HttpStatus.OK
        );
    }
}
