package com.sprintflow.ksiazkakucharska.repository;

import com.sprintflow.ksiazkakucharska.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value= "SELECT * FROM Recipe r WHERE r.category_id = :categoryId", nativeQuery = true)
    List<Recipe> findByCategory(Long categoryId);

    Recipe findRecipeById(Long id);

}
