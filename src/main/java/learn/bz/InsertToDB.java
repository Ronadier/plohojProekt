package learn.bz;

import org.opensaml.xmlsec.signature.Y;

import java.sql.*;

public class InsertToDB {
    Connection conn;
  {
    try {
      conn = DriverManager.getConnection("jdbc:mysql://109.196.164.32:3306/learnqa?user=learnqa&password=learnqa");
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
  public void insertToDB(Order order) {
    Statement st = null;
    try {
      st = conn.createStatement();
      st.executeQuery("use learnqa_insert_update_delete");

      String query = " insert into learnqa_insert_update_delete.CatsOrders (id, name, paid, adds, cost) "
              + " values (?, ?, ?, ?, ?)";
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setInt (1, order.id);
      preparedStmt.setString (2, order.customer);
      preparedStmt.setString   (3, "Y");
      preparedStmt.setString(4, order.order);
      preparedStmt.setInt    (5, 5000);

      preparedStmt.execute();
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}

