package biz.orderit.orderit.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "order")
public class Order {

    @Id
    String id;
    private Date timeOrdered, timeDelivered;
    private List<Dish> dishList;
    private String type, paymentTye;
    private Double subTotal, total, taxAndFees;
    private Retailer retailerId;
    private Restaurant restaurantId;
    private Customer customer;
    private enum  retailerType{
        RESTAURANT
    };


    /**
     * ORDER CONSTRUCTOR
     * @param timeOrdered
     * @param dishList
     * @param subTotal
     * @param total
     * @param customer
     */
    public Order(Date timeOrdered, List<Dish> dishList, Double subTotal, Double total, Customer customer) {
        this.timeOrdered = timeOrdered;
        this.dishList = dishList;
        this.subTotal = subTotal;
        this.total = total;
        this.retailerId = retailerId;
        this.customer = customer;
    }

    /**
     * EMPTY CONSTRUCTOR
     */
    public Order() {
    }


    /**
     * GETTERS AND SETTERS
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTimeOrdered() {
        return timeOrdered;
    }

    public void setTimeOrdered(Date timeOrdered) {
        this.timeOrdered = timeOrdered;
    }

    public Date getTimeDelivered() {
        return timeDelivered;
    }

    public void setTimeDelivered(Date timeDelivered) {
        this.timeDelivered = timeDelivered;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaymentTye() {
        return paymentTye;
    }

    public void setPaymentTye(String paymentTye) {
        this.paymentTye = paymentTye;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Retailer getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(Retailer retailerId) {
        this.retailerId = retailerId;
    }

    public Restaurant getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurant restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTaxAndFees() {
        return taxAndFees;
    }

    public void setTaxAndFees(Double taxAndFees) {
        this.taxAndFees = taxAndFees;
    }



    /**
     * TO STRING
     */
    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", timeOrdered=" + timeOrdered +
                ", timeDelivered=" + timeDelivered +
                ", dishList=" + dishList +
                ", type='" + type + '\'' +
                ", paymentTye='" + paymentTye + '\'' +
                ", subTotal=" + subTotal +
                ", total=" + total +
                ", retailerId=" + retailerId +
                ", restaurantId=" + restaurantId +
                ", customer=" + customer +
                '}';
    }
}