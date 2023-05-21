package com.example.fooddeliveryplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddeliveryplatform.model.FoodItem;
import com.example.fooddeliveryplatform.service.FoodItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/food")
public class FoodController {
    

    @Autowired
    FoodItemService foodItemService;

    @GetMapping("/getAll")
    public ResponseEntity<List<FoodItem>> getAllFoodItems() {
        List<FoodItem> foodItems = foodItemService.getAllFoodItems();
        return ResponseEntity.ok(foodItems);
    }

    // @PostMapping("/addFood")
    // public String createFoodItem( @RequestBody FoodItem foodItem) {
    //     foodItemService.createFoodItem(foodItem);
    //     return "Food item saved";
    // }

    @GetMapping("/getById/{foodItemId}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long foodItemId) {
        FoodItem foodItem = foodItemService.getFoodItemById(foodItemId);
        if (foodItem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foodItem);
    }

    // @PutMapping("/update/{foodItemId}")
    // public ResponseEntity<FoodItem> updateFoodItem(@PathVariable Long foodItemId, @Validated @RequestBody FoodItem foodItem) {
    //     FoodItem updatedFoodItem = foodItemService.updateFoodItem(foodItemId, foodItem);
    //     if (updatedFoodItem == null) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.ok(updatedFoodItem);
    // }

    // @DeleteMapping("/delete/{foodItemId}")
    // public ResponseEntity<Void> deleteFoodItem(@PathVariable Long foodItemId) {
    //     boolean deleted = foodItemService.deleteFoodItem(foodItemId);
    //     if (!deleted) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.noContent().build();
    // }
}
