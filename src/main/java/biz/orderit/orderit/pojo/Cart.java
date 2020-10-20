package biz.orderit.orderit.pojo;

/*
→ Carts (inside the pojo, the entity):
    FoodieId: String
    cartId: String
    Pickup Time: Datetime Type
    Dishes: List<Dishes> Type
    Subtotal: Double Type
    Tax and Fees: Double
    Total: Double

 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document (collection = "cart")
public class Cart {
    @Id
    private String id;
    private String customerId;
    private LocalDateTime pickUpTime;
    private List<Dish> dishList;
    private Double subtotal, taxAndFees, total;

    public Cart(){

    }

    public Cart(String id, String customerId, Double taxAndFees) {
        this.id = id;
        this.customerId = customerId;
        this.dishList = new ArrayList<Dish>();
        this.subtotal = 0.00;
        this.taxAndFees = taxAndFees;
        this.total = subtotal*taxAndFees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalDateTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTaxAndFees() {
        return taxAndFees;
    }

    public void setTaxAndFees(Double taxAndFees) {
        this.taxAndFees = taxAndFees;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void addDishToCart(Dish dish) {
        this.dishList.add(dish);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", pickUpTime=" + pickUpTime +
                ", dishList=" + dishList +
                ", subtotal=" + subtotal +
                ", taxAndFees=" + taxAndFees +
                ", total=" + total +
                '}';
    }
}
