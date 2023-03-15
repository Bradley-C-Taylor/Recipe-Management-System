package com.rms.server.dao;

import com.rms.server.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JdbcRecipeDao implements RecipeDao{

   private final JdbcTemplate jdbcTemplate;

   public JdbcRecipeDao(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }

   @Override
   public List<Recipe> getAllRecipes() {
      List<Recipe> recipes = new ArrayList<>();
      String sql = "SELECT recipeId, recipeName, directions FROM recipe;";
      SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
      while(rowSet.next()) {
         recipes.add(mapRowToRecipe(rowSet));
      }
      return recipes;
   }

   private Recipe mapRowToRecipe(SqlRowSet rowSet) {
      Recipe recipe = new Recipe();
      recipe.setRecipeId(rowSet.getInt("recipeId"));
      recipe.setRecipeName(rowSet.getString("recipeName"));
      recipe.setDescription(rowSet.getString("directions"));
      return recipe;
   }
}
