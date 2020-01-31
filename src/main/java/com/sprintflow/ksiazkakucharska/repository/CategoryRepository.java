package com.sprintflow.ksiazkakucharska.repository;

import com.sprintflow.ksiazkakucharska.model.Category;
import com.sprintflow.ksiazkakucharska.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}
