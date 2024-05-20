package ch07;

import java.sql.*;

public class UserDAO {
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost/user?serverTimezone=Asia/Seoul";
  public Connection open(){
    Connection conn = null;
    try{
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(JDBC_URL, "root","1111");
    } catch (Exception e){
      e.printStackTrace();
    }
    return conn;
  }

  public User getUser() throws SQLException {
    Connection conn = open();
    String sql = "select * from user";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();
    User user = new User();

    try {
      user.setId(rs.getInt(1));
      user.setPassword((rs.getString(2)));
      System.out.println("success");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }
}
