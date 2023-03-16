package com.rms.server.service;

import com.rms.server.dao.RecipeDao;

public class RecipeServiceImp implements RecipeService{

   private final RecipeDao dao;

   public RecipeServiceImp(RecipeDao dao) {
      this.dao = dao;
   }


}
