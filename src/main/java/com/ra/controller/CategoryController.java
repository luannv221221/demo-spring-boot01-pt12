package com.ra.controller;

import com.ra.model.Category;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public String index(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        return "category";
    }
    @GetMapping("/add-category")
    public String add(Category category,Model model){
        model.addAttribute("category",category);
        return "add-category";
    }

    @PostMapping("/add-category")
    public String save(@ModelAttribute("category") Category category){
        // gọi service
        if(categoryService.save(category)){
            return "redirect:/category";
        }
        return "redirect:/add-category";
    }
}
