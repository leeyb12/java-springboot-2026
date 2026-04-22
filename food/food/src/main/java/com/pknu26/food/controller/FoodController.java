package com.pknu26.food.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu26.food.dto.Food;
import com.pknu26.food.dto.PageResponse;
import com.pknu26.food.mapper.FoodMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodMapper foodMapper;

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(required = false) String keyword,
                       @RequestParam(required = false) String category, Model model) {
        int size = 10;
        int offset = (page - 1) * size;
        
        List<Food> foods = foodMapper.selectAllFoods(offset, size, keyword, category);
        long totalCount = foodMapper.countFoods(keyword, category);
        
        model.addAttribute("pageResponse", new PageResponse<>(foods, page, size, totalCount));
        model.addAttribute("keyword", keyword);
        model.addAttribute("category", category);


        return "food/list"; 
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("food", new Food());
        return "food/addForm"; 
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("food", foodMapper.selectFoodById(id));
        return "food/editForm"; 
    }

    @PostMapping("/add")
    public String add(Food food) { 
        foodMapper.insertFood(food);
        return "redirect:/food/list"; 
    }

    @PostMapping("/edit")
    public String edit(Food food) {
        foodMapper.updateFood(food);
        return "redirect:/food/list"; 
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        foodMapper.deleteFood(id);
        return "redirect:/food/list";
    }
}