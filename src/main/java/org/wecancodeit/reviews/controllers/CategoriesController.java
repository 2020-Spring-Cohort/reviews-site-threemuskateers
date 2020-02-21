package org.wecancodeit.reviews.controllers;
// package controllers
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.Category;
import org.wecancodeit.reviews.CategoryStorage;

@Controller
public class CategoriesController {
    private CategoryStorage categoryStorage;

    public CategoriesController(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    @RequestMapping("/categories")
    public String displayCategories(Model model){
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "index";
    }

    @RequestMapping("/categories/{genre}")
    public String displaySingleCategory(@PathVariable String genre, Model model) {
        Category retrieveCategory = categoryStorage.findCategoryByGenre(genre);
        model.addAttribute("categories", retrieveCategory);
        return "category";
    }
}
