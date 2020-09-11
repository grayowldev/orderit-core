public interface User {
    abstract String getId();
    abstract String generateId();
    abstract String setId(String id);
    abstract String getName();
    abstract String setName();
    abstract Address getAddress();
    abstract Address setAddress();
}
