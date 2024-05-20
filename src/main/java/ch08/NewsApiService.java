package ch08;

import ch07.News;
import ch07.NewsDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/news")
public class NewsApiService {
  NewsAPIDAO dao;

  public NewsApiService() {
    dao= new NewsAPIDAO();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<News> getNewsList(){
    List<News> newsList = null;

    try{
      newsList = dao.getAll();
    } catch (Exception e){
      e.printStackTrace();
    }
    return newsList;
  }

  @GET
  @Path("{aid}")
  @Produces(MediaType.APPLICATION_JSON)
  public News getNews(@PathParam("aid") int aid){
    News news = null;

    try{
      news = dao.getNews(aid);
    } catch (Exception e){
      e.printStackTrace();
    }
    return news;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public String addNews(News news){
    try{
      dao.addNews(news);
    } catch (Exception e) {
      return "뉴스를 등록하는 과정에서 오류가 발생했습니다.";
    }
    return "뉴스 등록 성공";
  }

  @DELETE
  @Path("{aid}")
  public String deleteNews(@PathParam("aid") int aid){
    try {
      dao.delNews(aid);
    } catch (Exception e) {
      return "뉴스 삭제 오류";
    }
    return "뉴스가 정상적으로 삭제되었습니다.";
  }

}
