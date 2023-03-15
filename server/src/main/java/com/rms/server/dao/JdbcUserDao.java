package com.rms.server.dao;

import com.rms.server.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserDao implements UserDao {

   public JdbcTemplate jdbcTemplate;

   public JdbcUserDao(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }

   @Override
   public User findByUsername(String username) {
      if (username == null) throw new IllegalArgumentException("Username cannot be null");

      String sql = "SELECT userId, username, password_hash FROM rms_user WHERE username = ?;";
      SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
      if (rowSet.next()) {
         return mapRowToUser(rowSet);
      }
      throw new UsernameNotFoundException("User " + username + " was not found.");
   }

   @Override
   public boolean create(String username, String password) {
      String sql = "INSERT INTO rms_user (username, password_hash) VALUES (?, ?) RETURNING userId";
      String password_hash = new BCryptPasswordEncoder().encode(password);
      Integer newUserId;
      newUserId = jdbcTemplate.queryForObject(sql, Integer.class, username, password_hash);
      if (newUserId == null) return false;
      return true;
   }

   private User mapRowToUser(SqlRowSet rs) {
      User user = new User();
      user.setId(rs.getInt("userId"));
      user.setUsername(rs.getString("username"));
      user.setPassword(rs.getString("password_hash"));
      user.setActivated(true);
      user.setAuthorities("USER");
      return user;
   }
}
