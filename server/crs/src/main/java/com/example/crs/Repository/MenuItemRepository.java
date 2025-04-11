package com.example.crs.Repository;




import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

import com.example.crs.Model.MenuItem;

public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
    List<MenuItem> findByCategoryIgnoreCase(String category);
}

