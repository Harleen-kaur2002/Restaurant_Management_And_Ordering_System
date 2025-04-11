package com.example.crs.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crs.Model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}