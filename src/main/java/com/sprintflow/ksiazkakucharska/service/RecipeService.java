package com.sprintflow.ksiazkakucharska.service;

import com.sprintflow.ksiazkakucharska.model.Recipe;
import com.sprintflow.ksiazkakucharska.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeService() {
    }

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes(){

        return recipeRepository.findAll();
    }

    public List<Recipe> getRecipesByCategory(Long categoryId) {
        return recipeRepository.findByCategory(categoryId);
    }

    public Recipe getRecipeDetails(Long id) {
        Recipe recipeById = recipeRepository.findRecipeById(id);
        System.out.println(recipeById);
        return recipeRepository.findRecipeById(id);
    }

    public void addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
