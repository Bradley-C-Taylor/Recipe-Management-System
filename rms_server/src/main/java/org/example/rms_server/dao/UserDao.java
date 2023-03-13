package org.example.rms_server.dao;

import org.example.rms_server.model.User;

public interface UserDao {
   User findByUsername(String username);

   boolean create(String username, String password);
}
