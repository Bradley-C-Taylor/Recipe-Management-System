package org.example.rms_server.dao;

import org.example.rms_server.model.Recipe;

import java.util.List;

public interface RecipeDao {

   List<Recipe> getAllRecipes();
}
