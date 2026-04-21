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

        // 수정: "redirect:/food/list" -> 무한 루프에 빠질 수 있음
        return "food/list"; // src/main/resources/templates/food/list.html 을 실행
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("food", new Food());
        // 수정: "redirect:/food/addForm" -> "food/addForm"
        return "food/addForm"; // templates/food/addForm.html 을 보여줌
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("food", foodMapper.selectFoodById(id));
        // 수정: "redirect:/food/editForm" -> "food/editForm"
        return "food/editForm"; // templates/food/editForm.html 을 보여줌
    }

    // 등록, 수정, 삭제 후 목록으로 돌아갈 때는 redirect가 맞습니다.
    @PostMapping("/add")
    public String add(Food food) { 
        foodMapper.insertFood(food);
        return "redirect:/food/list"; // 처리가 끝난 후 목록 주소로 이동
    }

    // 수정 화면에서 [수정 완료] 버튼을 눌렀을 때 실행되는 메서드
    @PostMapping("/edit")
    public String edit(Food food) {
        foodMapper.updateFood(food); // XML의 <update id="updateFood"> 호출
        return "redirect:/food/list"; // 수정 후 목록으로 이동
    }

    // (참고) 삭제 기능도 없다면 아래 코드를 추가하세요
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        foodMapper.deleteFood(id);
        return "redirect:/food/list";
    }
}