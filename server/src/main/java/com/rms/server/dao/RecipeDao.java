package com.rms.server.dao;

import com.rms.server.model.Recipe;

import java.util.List;

public interface RecipeDao {

   List<Recipe> getAllRecipes();
}
