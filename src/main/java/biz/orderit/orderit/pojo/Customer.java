package biz.orderit.orderit.pojo;

public class Customer implements User{
    private String id, name;
    private Address address;

// GETTERS
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

// SETTERS
    @Override
    public String setId(String id) {
        this.id =id;
        return id;
    }

    @Override
    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    @Override
    public Address setAddress(Address address) {
        this.address = address;
        return this.address;
    }

    @Override
    public String generateId() {
        return null;
    }

    public Customer(String id, String name, Address address)
    {
        this.id = id;
        this.name = name;
        this.address = address;
    }


}
