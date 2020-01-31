package com.sprintflow.ksiazkakucharska.controller;

import com.sprintflow.ksiazkakucharska.model.Category;
import com.sprintflow.ksiazkakucharska.model.Recipe;
import com.sprintflow.ksiazkakucharska.service.CategoryService;
import com.sprintflow.ksiazkakucharska.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RecipeController {

    private RecipeService recipeService;
    private CategoryService categoryService;

    public RecipeController() {
    }

    @Autowired
    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String getRecipes(Model model, @RequestParam(name = "categoryId", required = false) Long categoryId){

        List<Category> allCategories = categoryService.getAllCategories();
        model.addAttribute("categories", allCategories);

        if (categoryId == null) {
            List<Recipe> allRecipes = recipeService.getAllRecipes();
            model.addAttribute("recipes", allRecipes);

        } else {
            List<Recipe> recipesByCategory = recipeService.getRecipesByCategory(categoryId);
            model.addAttribute("recipes", recipesByCategory);
        }

        return "home";
    }

    @GetMapping("/recipe")
    public String getRecipeDetails(@RequestParam("id") Long id, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeDetails(id));
        return "recipe";
    }

    @GetMapping("/addRecipe")
    public String addRecipe(Model model){
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("mode","add");
        return "addOrEditRecipe";
    }

    @PostMapping("/addRecipe")
    public String addRecipe(Recipe recipe){
        recipeService.addRecipe(recipe);
        return "redirect:/recipe?id=" + recipe.getId();
    }

}
