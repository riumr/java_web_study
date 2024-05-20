package ch07;

import ch06.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost/news?serverTimezone=Asia/Seoul";
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

  public void addNews(News n) throws Exception{
    Connection conn = open();
    String sql = "insert into news(title,img, date, content) values(?,?,CURRENT_TIMESTAMP(),?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,n.getTitle());
      pstmt.setString(2,n.getImg());
      pstmt.setString(3,n.getContent());
      pstmt.executeUpdate();
    } finally {
      conn.close();
      pstmt.close();
    }
  }

  public List<News> getAll() throws Exception{
    Connection conn = open();
    List<News> newsList = new ArrayList<>();

    String sql = "select aid,title,date_format(date,'%Y-%m-%d %h-%m-%s') as cdate from news";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();

    try {
      while (rs.next()){
        News n = new News();
        n.setAid(rs.getInt("aid"));
        n.setTitle(rs.getString("title"));
        n.setDate(rs.getString("cdate"));

        newsList.add(n);
      }
    } finally {
      conn.close();
      pstmt.close();
    }
    return newsList;
  }

  public News getNews(int aid) throws SQLException {
    Connection conn = open();
    News n = new News();
    String sql = "select aid,title,img, date_format(date,'%Y-%m-%d %h-%m-%s') as cdate,content from news where aid=?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1,aid);
    ResultSet rs = pstmt.executeQuery();

    rs.next();

    try {
      n.setAid(rs.getInt("aid"));
      n.setTitle(rs.getString("title"));
      n.setImg(rs.getString("img"));
      n.setDate(rs.getString("cdate"));
      n.setContent(rs.getString("content"));
      pstmt.executeQuery();
      return n;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void delNews(int aid) throws SQLException {
    Connection conn = open();

    String sql = "delete from news where aid=?";
    PreparedStatement pstmt = conn.prepareStatement(sql);

    try{
      pstmt.setInt(1,aid);
      if(pstmt.executeUpdate()==0){
        throw new SQLException("DB에러");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
