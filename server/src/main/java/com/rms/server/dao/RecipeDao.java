package com.rms.server.dao;

import com.rms.server.model.Recipe;

import java.util.List;

public interface RecipeDao {
   //CREATE

   //READ
   List<Recipe> getAllRecipes();
   String getRecipeNameForId(int id);
   //UPDATE

   //DELETE

}
