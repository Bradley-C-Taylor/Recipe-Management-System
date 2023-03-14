package com.rms.server.dao;

import com.rms.server.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;

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
