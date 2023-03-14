package com.rms.server.model;

public class Ingredient {

   private int ingredientId;
   private String ingredientName;
   private double ingredientAmount;
   private String amountFormat;

   public double getIngredientAmount() {
      return ingredientAmount;
   }

   public void setIngredientAmount(double ingredientAmount) {
      this.ingredientAmount = ingredientAmount;
   }

   public String getAmountFormat() {
      return amountFormat;
   }

   public void setAmountFormat(String amountFormat) {
      this.amountFormat = amountFormat;
   }

   public int getIngredientId() {
      return ingredientId;
   }

   public void setIngredientId(int ingredientId) {
      this.ingredientId = ingredientId;
   }

   public String getIngredientName() {
      return ingredientName;
   }

   public void setIngredientName(String ingredientName) {
      this.ingredientName = ingredientName;
   }
}
