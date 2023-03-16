package com.rms.server.dao;

import com.rms.server.model.Ingredient;

import java.util.List;

public interface IngredientDao {
   //CREATE

   //READ
   List<Ingredient> getIngredientsForRecipeId(int recipeId);
   List<Ingredient> getIngredientsForRecipeName(String name);
   String getDirectionsForId(int recipeId);
   String getDirectionsForName(String name);
   //UPDATE

   //DELETE
}
