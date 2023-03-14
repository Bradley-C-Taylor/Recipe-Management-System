package com.rms.server.dao;

import com.rms.server.model.User;

public interface UserDao {
   User findByUsername(String username);

   boolean create(String username, String password);
}
