
public class Customer implements User{
    String id,name;
    Address address;



    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String generateId() {
        return null;
    }


    @Override
    public String setId(String id) {
        this.id =id;
        return id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String setName(String name) {
        this.name = name;
        return this.name;
    }


    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public Address setAddress(Address address) {
        this.address = address;
        return this.address;
    }

}
