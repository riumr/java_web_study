package ch06;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/studentControl")
public class StudentController extends HttpServlet {
  private static final long serialVersionId = 1L;

  StudentDAO dao;
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    dao = new StudentDAO();
  }

  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    String action = req.getParameter("action");
    String view = "";
    if(action==null){
      getServletContext().getRequestDispatcher("/studentControl?action=list")
          .forward(req,resp);
    } else {
      switch (action) {
        case "list" : view = list(req,resp); break;
        case "insert" : view = insert(req,resp); break;
      }
      getServletContext().getRequestDispatcher("/ch06/"+view).forward(req,resp);
    }
  }

  public String list(HttpServletRequest req, HttpServletResponse resp){
    req.setAttribute("students",dao.getAll());
    return "studentInfo.jsp";
  }

  public String insert(HttpServletRequest req, HttpServletResponse resp){
    Student s = new Student();
    try {
      BeanUtils.populate(s, req.getParameterMap());
    } catch (Exception e){
      e.printStackTrace();
    }
    dao.insert(s);
    return list(req, resp);
  }
}
