package com.example.crs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.crs.Model.MenuItem;
import com.example.crs.Repository.MenuItemRepository;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "http://localhost:3000") 
public class MenuController {

    @Autowired
    private MenuItemRepository menuItemRepository;

   
    @GetMapping("/{category}")
    public ResponseEntity<List<MenuItem>> getMenuByCategory(@PathVariable String category) {
        List<MenuItem> items = menuItemRepository.findByCategoryIgnoreCase(category);
        if (items.isEmpty()) {
            return ResponseEntity.notFound().build(); 
        }
        return ResponseEntity.ok(items);
    }

    @PostMapping("/")
public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
    MenuItem savedItem = menuItemRepository.save(menuItem);
    return ResponseEntity.ok(savedItem);
}

}


