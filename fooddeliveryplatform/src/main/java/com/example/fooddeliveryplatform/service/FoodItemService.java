package com.example.fooddeliveryplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryplatform.dao.FoodRepository;
import com.example.fooddeliveryplatform.model.FoodItem;

@Service
public class FoodItemService {
    
    @Autowired
    FoodRepository foodItemRepository;

    
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public FoodItem getFoodItemById(Long foodItemId) {
        return foodItemRepository.findById(foodItemId).orElse(null);
    }

    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public FoodItem updateFoodItem(Long foodItemId, FoodItem foodItem) {
        FoodItem existingFoodItem = foodItemRepository.findById(foodItemId).orElse(null);
        if (existingFoodItem != null) {
            existingFoodItem.setFoodName(foodItem.getFoodName());
            existingFoodItem.setFoodPrice(foodItem.getFoodPrice());
            return foodItemRepository.save(existingFoodItem);
        }
        return null;
    }

    public boolean deleteFoodItem(Long foodItemId) {
        if (foodItemRepository.existsById(foodItemId)) {
            foodItemRepository.deleteById(foodItemId);
            return true;
        }
        return false;
    }
}
