package org.example.rms_server.dao;

import org.example.rms_server.model.Ingredient;

import java.util.List;

public interface IngredientDao {

   public List<Ingredient> getIngredientsForRecipeId(int recipeId);

}
