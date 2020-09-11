package biz.orderit.orderit.pojo;

public class Retailer implements User{
    private String id, name;
    private Address address;

    public Retailer(String id, String name, Address address)
    {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Retailer()
    {

    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public String setName(String name) {
        this.name = name;
        return name;
    }

    @Override
    public String setId(String id) {
        this.id = id;
        return id;
    }

    @Override
    public Address setAddress(Address address) {
        this.address = address;
        return address;
    }

    @Override
    public String generateId() {
        return null;
    }

}




/*
    Jonards Temporary Notes:
        If a customer wants to order a drink from a coffee shop (Retailer/Restaurant),
        The app will display the [name] of the restaurant on the front, along with the
        address.
        Each restaurant will have a unique ID because that is how each restaurant will be stored
        in the database. Think about it. A starbucks in Jersey City is different from the Starbucks in Union.
 */