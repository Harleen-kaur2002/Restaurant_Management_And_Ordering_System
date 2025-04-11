package com.example.crs.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crs.Model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
}