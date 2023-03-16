package com.rms.server.controller;

import com.rms.server.dao.RecipeDao;
import com.rms.server.model.FullRecipe;
import com.rms.server.model.Ingredient;
import com.rms.server.model.Recipe;
import com.rms.server.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
ENDPOINTS:
/recipes -> gets all recipes
/full-recipe?name={recipeName} -> Gets recipe name, ingredients, and description
/full-recipe?id={recipeId} -> Gets recipe name, ingredients, and description
/ingredients?name={recipeName} -> List of ingredients for given recipe name
/ingredients?id={recipeId} -> List of ingredients for given recipe ID
/directions?name={recipeName} -> Directions string for given recipe name
/directions?id={recipeId} -> Directions string for given recipe ID
 */

@RestController
public class RecipeController {
   private static final String NOT_FOUND_MSG = "Recipe not found";

   private final IngredientService service;
   private final RecipeDao recipeDao;

   public RecipeController(IngredientService service, RecipeDao recipeDao) {
      this.service = service;
      this.recipeDao = recipeDao;
   }

   /**
    * GET @ /recipes -> returns a list with all the saved recipes
    * @return list of recipes
    */
   @GetMapping("/recipes")
   public List<Recipe> getAllRecipes() {
      return recipeDao.getAllRecipes();
   }

   /**
    * GET @ /full-recipe?name={name}&id={id} -> Gets recipe name,
    * ingredients, and description
    * @param name recipe name -> optional
    * @param id recipe id -> optional
    * @return FullRecipe containing name, ingredients, and directions
    */
   @GetMapping("/full-recipe")
   public FullRecipe getFullRecipe(@RequestParam(defaultValue = "") String name,
                                   @RequestParam(required = false) Integer id) {
      FullRecipe fullRecipe = service.getFullRecipe(name, id);
      if(fullRecipe == null) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MSG);
      }
      return fullRecipe;
   }
   /**
    * GET @ /ingredients?name={name}&id={id} -> Gets recipe's ingredients
    * @param name recipe name -> optional
    * @param id recipe id -> optional
    * @return list of ingredients
    */
   @GetMapping("/ingredients")
   public List<Ingredient> getAllIngredients(@RequestParam(defaultValue = "") String name,
                                             @RequestParam(required = false) Integer id) {
      List<Ingredient> ingredients = service.getAllIngredients(name, id);
      if(ingredients == null) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MSG);
      }
      return ingredients;
   }
   /**
    * GET @ /directions?name={name}&id={id} -> Gets recipe's directions
    * @param name recipe name -> optional
    * @param id recipe id -> optional
    * @return String representing the directions
    */
   @GetMapping("/directions")
   public String getDirections(@RequestParam(defaultValue = "") String name,
                               @RequestParam(required = false) Integer id) {
      String directions = service.getDirections(name, id);
      if(directions == null) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MSG);
      }
      return directions;
   }
}
