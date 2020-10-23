package biz.orderit.orderit.repository;


import biz.orderit.orderit.pojo.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {
}
