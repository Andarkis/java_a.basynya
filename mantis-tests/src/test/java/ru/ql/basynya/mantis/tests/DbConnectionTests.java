package ru.ql.basynya.mantis.tests;

import org.testng.annotations.Test;
import ru.ql.basynya.mantis.model.UserData;
import ru.ql.basynya.mantis.model.Users;

import java.sql.*;

public class DbConnectionTests {

  @Test
  public void testDbConnection() {
    Connection conn = null;

    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracker?" +
              "user=root&password=&serverTimezone=UTC");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT id, username, email FROM mantis_user_table WHERE access_level != 90");
      Users users = new Users();
      while (rs.next()) {
        users.add(new UserData().withId(rs
                .getInt("id"))
                .withUsername(rs.getString("username"))
                .withEmail(rs.getString("email")));
      }
      rs.close();
      st.close();
      conn.close();

      System.out.println(users);

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}
