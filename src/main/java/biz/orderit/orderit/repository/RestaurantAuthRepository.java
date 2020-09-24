package biz.orderit.orderit.repository;

import biz.orderit.orderit.pojo.RestaurantAuth;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantAuthRepository extends MongoRepository<RestaurantAuth, String> {
    // public List<RestaurantAuth> findRestaurantAuthById(String id);
    public Optional<RestaurantAuth> findRestaurantAuthById(String id);
    public Optional<RestaurantAuth> findRestaurantAuthByEmailAndAndPassword(String email, String password);
}

