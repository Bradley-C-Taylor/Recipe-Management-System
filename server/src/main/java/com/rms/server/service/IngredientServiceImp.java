package com.rms.server.service;

import com.rms.server.dao.IngredientDao;
import com.rms.server.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImp implements IngredientService{

   private IngredientDao dao;

   public IngredientServiceImp(IngredientDao ingredientDao) {
      dao = ingredientDao;
   }

   @Override
   public List<Ingredient> getAllIngredients(String name, Integer recipeId) {
      List<Ingredient> ingredients;
      if(name.equals("") && recipeId == null) {
         ingredients = null;
      } else if(recipeId != null) {
         ingredients = dao.getIngredientsForRecipeId(recipeId);
      } else {
         ingredients = dao.getIngredientsForRecipeName(name);
      }
      return ingredients;
   }

   @Override
   public String getDirections(String name, Integer recipeId) {
      String directions;
      if(name.equals("") && recipeId == null) {
         directions = null;
      } else if(recipeId != null) {
         directions = dao.getDirectionsForId(recipeId);
      } else {
         directions = dao.getDirectionsForName(name);
      }
      return directions;
   }
}
