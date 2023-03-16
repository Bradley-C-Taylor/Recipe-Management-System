package com.rms.server.dao;

import com.rms.server.model.User;

public interface UserDao {
   //CREATE
   boolean create(String username, String password);
   //READ
   User findByUsername(String username);

}
