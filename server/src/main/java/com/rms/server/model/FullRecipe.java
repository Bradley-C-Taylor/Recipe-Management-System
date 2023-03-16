package com.rms.server.model;

import java.util.List;
import java.util.Objects;

public class FullRecipe extends Recipe{

   private List<Ingredient> ingredientList;

   public List<Ingredient> getIngredients() {return ingredientList;}
   public void addToIngredients(Ingredient ingredient) {
      ingredientList.add(ingredient);
   }
   public void setIngredientList(List<Ingredient> ingredientList) {
      this.ingredientList = ingredientList;
   }

   @Override
   public String toString() {
      return "FullRecipe{" +
              "ingredientList=" + ingredientList +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      if (!super.equals(o)) return false;
      FullRecipe that = (FullRecipe) o;
      return ingredientList.equals(that.ingredientList);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), ingredientList);
   }
}
