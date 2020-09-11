package biz.orderit.orderit.pojo;

public class Address {
    private String houseNo, street, city, state, zip;

// GETTERS
    public String getHouseNo() {
        return houseNo;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

// Setters
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

// METHODS
    @Override
    public String toString() {
        return houseNo + " " +street+ "\n"+ city + " "+street + "\n"+city+state+"\n"+zip;
    }

    public Address(String houseNo, String street, String city, String state, String zip) {
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
