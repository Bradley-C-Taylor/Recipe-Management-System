package com.rms.server.service;

import com.rms.server.model.FullRecipe;
import com.rms.server.model.Ingredient;

import java.util.List;

public interface IngredientService {
   List<Ingredient> getAllIngredients(String name, Integer recipeId);
   String getDirections(String name, Integer recipeId);

   FullRecipe getFullRecipe(String name, Integer id);
}
