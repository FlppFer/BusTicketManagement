package com.FellippoFerreira.BusTicketsManagement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class DatabaseConnection {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  public void testConnection() {
    try {
      String sql = "SELECT 1";
      Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
      assertNotNull(result, "Connection should be successful and return result");
      System.out.println("Connection Successful: " + result);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Connection to the database failed: " + e.getMessage());
    }
  }
}
