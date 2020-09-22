package biz.orderit.orderit.repository;

import biz.orderit.orderit.pojo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
