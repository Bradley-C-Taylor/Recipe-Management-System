package com.rms.server.dao;

import com.rms.server.model.User;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserDao implements UserDao {
   @Override
   public User findByUsername(String username) {
      return null;
   }

   @Override
   public boolean create(String username, String password) {
      return false;
   }
}
