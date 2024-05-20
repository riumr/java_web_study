package ch07;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/news.nhn")
@MultipartConfig(maxFileSize = 1024*1024*2, location = "c:/Temp/img")
public class NewsController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private NewsDAO dao;
  private ServletContext ctx;

  private final String START_PAGE = "ch07/newsList.jsp";

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    dao = new NewsDAO();
    ctx = getServletContext();
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");

    if(action == null) {
      action = "list";
    }

    String view = null;
    switch (action) {
      case "listNews" : view = listNews(request); break;
      case "addNews" : view = addNews(request); break;
      case "delNews" : view = delNews(request, response);break;
      case "getNews" : view = getNews(request);break;
    }

    if (view.startsWith("redirect:/")) {
      String redirectPath = view.substring("redirect:/".length());
      response.sendRedirect(redirectPath);
    } else {
      RequestDispatcher dispatcher = request.getRequestDispatcher(view);
      dispatcher.forward(request, response);
    }
  }

  private String addNews(HttpServletRequest req) throws ServletException, IOException {
    News n = new News();
    try{
      Part part = req.getPart("file");
      String filename = part.getSubmittedFileName();
      if(filename != null & !filename.isEmpty()){
        part.write(filename);
      }
      BeanUtils.populate(n,req.getParameterMap());
      n.setImg("/img/"+filename);
      dao.addNews(n);
    } catch (Exception e) {
      e.printStackTrace();
      req.setAttribute("error","뉴스가 정상적으로 등록되지 않았습니다");
      return listNews(req);
    }
    return "redirect:/news.nhn?action=listNews";
  }

  private String delNews(HttpServletRequest req, HttpServletResponse resp) {
    return "redirect:/news.nhn?action=list";
  }

  private String listNews(HttpServletRequest req) throws ServletException, IOException {
    List<News> list;
    try {
      list = dao.getAll();
      req.setAttribute("newsList", list);
    } catch (Exception e) {
      e.printStackTrace();
      req.getServletContext().log("뉴스 목록 생성 과정에서 문제 발생", e);
      req.setAttribute("error", "뉴스 목록이 정상적으로 처리되지 않았습니다");
    }
    return "/ch07/newsList.jsp";
  }

  public String getNews(HttpServletRequest req){
    int aid = Integer.parseInt(req.getParameter("aid"));
    try {
      News n = dao.getNews(aid);
      req.setAttribute("news",n);
    } catch (SQLException e) {
      e.printStackTrace();
      req.setAttribute("error","뉴스를 정상적으로 가져오지 못했습니다");
    }
    return "ch07/newsView.jsp";
  }
}
