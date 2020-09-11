package biz.orderit.orderit.pojo;

public interface User {
    abstract String getId();
    abstract String generateId();
    abstract String setId(String id);
    abstract String getName();
    abstract String setName(String name);
    abstract Address getAddress();
    abstract Address setAddress(Address address);
}
