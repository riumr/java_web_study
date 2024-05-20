package ch07;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/loginController")
public class LoginController extends HttpServlet {

  private UserDAO dao;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer userId = Integer.parseInt(req.getParameter("id"));
    String password = req.getParameter("password");
    String view = "";

  }

  public String success(){
    return "redirect:/ch07/loginSuccess.jsp";
  }

  public String failure(){
    return "redirect:/ch07/loginFailure.jsp";
  }
}
