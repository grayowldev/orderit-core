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

    // This generates the ID that........
    @Override
    public String generateId() {
        return null;
    }

}
