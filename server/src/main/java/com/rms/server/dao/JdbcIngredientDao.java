package com.rms.server.dao;

import com.rms.server.model.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcIngredientDao implements IngredientDao{

   private JdbcTemplate jdbcTemplate;

   public JdbcIngredientDao(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }

   @Override
   public List<Ingredient> getIngredientsForRecipeId(int recipeId) {
      List<Ingredient> ingredients = new ArrayList<>();
      String sql = "SELECT ri.ingredientAmount, af.formatType, i.ingredientName, i.ingredientId " +
              "FROM recipe_ingredient ri " +
              "JOIN recipe r ON ri.recipeId = r.recipeId " +
              "JOIN ingredient i ON ri.ingredientId = i.ingredientId " +
              "JOIN amount_format af ON ri.formatId = af.formatId " +
              "WHERE r.recipeId = ?;";
      SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, recipeId);
      while(rowSet.next()) {
         ingredients.add(mapRowToIngredient(rowSet));
      }
      return ingredients;
   }

   @Override
   public List<Ingredient> getIngredientsForRecipeName(String name) {
      List<Ingredient> ingredients = new ArrayList<>();
      String sql = "SELECT ri.ingredientAmount, af.formatType, i.ingredientName, i.ingredientId " +
              "FROM recipe_ingredient ri " +
              "JOIN recipe r ON ri.recipeId = r.recipeId " +
              "JOIN ingredient i ON ri.ingredientId = i.ingredientId " +
              "JOIN amount_format af ON ri.formatId = af.formatId " +
              "WHERE r.recipeName ILIKE ?;";
      SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, name);
      while(rowSet.next()) {
         ingredients.add(mapRowToIngredient(rowSet));
      }
      return ingredients;
   }

   @Override
   public String getDirectionsForId(int recipeId) {
      String sql = "SELECT directions FROM recipe WHERE recipeId = ?;";
      return jdbcTemplate.queryForObject(sql, String.class, recipeId);
   }

   @Override
   public String getDirectionsForName(String name) {
      String sql = "SELECT directions FROM recipe WHERE recipeName ILIKE ?;";
      return jdbcTemplate.queryForObject(sql, String.class, name);
   }

   private Ingredient mapRowToIngredient(SqlRowSet rowSet) {
      Ingredient ingredient = new Ingredient();
      ingredient.setIngredientName(rowSet.getString("ingredientName"));
      ingredient.setIngredientId(rowSet.getInt("ingredientId"));
      ingredient.setIngredientAmount(rowSet.getDouble("ingredientAmount"));
      ingredient.setAmountFormat(rowSet.getString("formatType"));
      return ingredient;
   }
}
