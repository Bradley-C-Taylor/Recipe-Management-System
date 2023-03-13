package org.example.rms_server.dao;

import org.example.rms_server.model.Recipe;

import java.util.List;

public class JdbcRecipeDao implements RecipeDao{

   //private final JdbcTemplate jdbcTemplate;

   public JdbcRecipeDao() {

   }

   @Override
   public List<Recipe> getAllRecipes() {
      return null;
   }
}
