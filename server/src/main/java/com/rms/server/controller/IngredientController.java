package com.rms.server.controller;

import com.rms.server.model.Ingredient;
import com.rms.server.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
ENDPOINTS:
/ingredients?name={recipeName} -> List of ingredients for given recipe name
/ingredients?id={recipeId} -> List of ingredients for given recipe ID
/directions?name={recipeName} -> Directions string for given recipe name
/directions?id={recipeId} -> Directions string for given recipe ID
 */


@RestController
public class IngredientController {

   private IngredientService service;

   public IngredientController(IngredientService service) {
      this.service = service;
   }

   @GetMapping("/ingredients")//name -> recipeName, id -> recipeId
   public List<Ingredient> getAllIngredients(@RequestParam(defaultValue = "") String name,
                                             @RequestParam(required = false) Integer id) {
      List<Ingredient> ingredients = service.getAllIngredients(name, id);
      if(ingredients == null) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found");
      }
      return ingredients;
   }

   @GetMapping("/directions")
   public String getDirections(@RequestParam(defaultValue = "") String name,
                               @RequestParam(required = false) Integer id) {
      String directions = service.getDirections(name, id);
      if(directions == null) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found");
      }
      return directions;
   }
}
