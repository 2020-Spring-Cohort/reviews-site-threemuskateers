package org.wecancodeit.reviews.controllers;
// package controllers
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Movie;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.MovieStorage;

@Controller
public class CategoriesController {
    private CategoryStorage categoryStorage;
    private MovieStorage movieStorage;

    public CategoriesController(CategoryStorage categoryStorage, MovieStorage movieStorage) {
        this.categoryStorage = categoryStorage;
        this.movieStorage = movieStorage;
    }

    @RequestMapping({"/categories", "/"})
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

    @PostMapping("/add-movie")
    public String addMovie(@RequestParam String movieName, String genre, Model model) {
        Category categoryToStore = categoryStorage.findCategoryByGenre(genre);
        Movie movieToStore = new Movie(movieName, categoryToStore);
        movieStorage.store(movieToStore);
        model.addAttribute("genre", genre);
        return "redirect:categories/"+ genre;
    }
}
