package com.rms.server.model;

import java.util.Objects;

public class Recipe {

   private int recipeId;
   private String recipeName;
   private String description;

   @Override
   public String toString() {
      return "Recipe{" +
              "recipeId=" + recipeId +
              ", recipeName='" + recipeName + '\'' +
              ", description='" + description + '\'' +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Recipe recipe = (Recipe) o;
      return recipeId == recipe.recipeId && recipeName.equals(recipe.recipeName) && description.equals(recipe.description);
   }

   @Override
   public int hashCode() {
      return Objects.hash(recipeId, recipeName, description);
   }

   public int getRecipeId() {
      return recipeId;
   }

   public void setRecipeId(int recipeId) {
      this.recipeId = recipeId;
   }

   public String getRecipeName() {
      return recipeName;
   }

   public void setRecipeName(String recipeName) {
      this.recipeName = recipeName;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
}