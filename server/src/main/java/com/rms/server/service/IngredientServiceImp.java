package com.rms.server.service;

import com.rms.server.dao.IngredientDao;
import com.rms.server.dao.RecipeDao;
import com.rms.server.model.FullRecipe;
import com.rms.server.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImp implements IngredientService{

   private final IngredientDao dao;
   private final RecipeDao recipeDao;

   public IngredientServiceImp(IngredientDao ingredientDao, RecipeDao recipeDao) {
      dao = ingredientDao;
      this.recipeDao = recipeDao;
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

   @Override
   public FullRecipe getFullRecipe(String name, Integer recipeId) {
      FullRecipe fullRecipe = new FullRecipe();
      if(name.equals("") && recipeId == null) {
         fullRecipe = null;
      } else if(recipeId != null) {
         fullRecipe.setRecipeName(recipeDao.getRecipeNameForId(recipeId));
         fullRecipe.setIngredientList(dao.getIngredientsForRecipeId(recipeId));
         fullRecipe.setDescription(dao.getDirectionsForId(recipeId));
      } else {
         fullRecipe.setRecipeName(name);
         fullRecipe.setIngredientList(dao.getIngredientsForRecipeName(name));
         fullRecipe.setDescription(dao.getDirectionsForName(name));
      }
      return fullRecipe;
   }
}
