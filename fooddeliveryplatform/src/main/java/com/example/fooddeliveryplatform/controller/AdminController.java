package com.example.fooddeliveryplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddeliveryplatform.model.Admin;
import com.example.fooddeliveryplatform.model.FoodItem;
import com.example.fooddeliveryplatform.service.FoodItemService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    FoodItemService foodItemService;
    
    @PostMapping("/food-items")
    public ResponseEntity<FoodItem> createFoodItem(@RequestBody FoodItem foodItem) {
        FoodItem createdFoodItem = foodItemService.createFoodItem(foodItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFoodItem);
    }

    @GetMapping("/food-items")
    public ResponseEntity<List<FoodItem>> getAllFoodItems() {
        List<FoodItem> foodItems = foodItemService.getAllFoodItems();
        return ResponseEntity.ok(foodItems);
    }

    @PutMapping("/food-items/{foodItemId}")
    public ResponseEntity<FoodItem> updateFoodItem(@PathVariable Long foodItemId, @RequestBody FoodItem foodItem) {
        FoodItem updatedFoodItem = foodItemService.updateFoodItem(foodItemId, foodItem);
        if (updatedFoodItem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFoodItem);
    }

    @DeleteMapping("/food-items/{foodItemId}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long foodItemId) {
        boolean deleted = foodItemService.deleteFoodItem(foodItemId);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

   

}
