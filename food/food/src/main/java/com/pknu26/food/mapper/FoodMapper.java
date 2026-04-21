package com.pknu26.food.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pknu26.food.dto.Food;

@Mapper
public interface FoodMapper {
    List<Food> selectAllFoods(@Param("offset") int offset, @Param("size") int size, 
                              @Param("keyword") String keyword, @Param("category") String category);
    long countFoods(@Param("keyword") String keyword, @Param("category") String category);
    void insertFood(Food food);
    Food selectFoodById(Long id);
    void updateFood(Food food);
    void deleteFood(Long id);
}