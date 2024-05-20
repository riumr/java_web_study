package ch04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(description = "My First Servlet", urlPatterns = "/hello")
public class HelloWorld extends HttpServlet {

  public HelloWorld() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=utf-8");
    PrintWriter out = resp.getWriter();
    out.append("<html><head></head><body>")
        .append("<h2>hello from servlet</h2><hr>")
        .append("현재 날짜와 시간은 : " + java.time.LocalDateTime.now())
        .append("/<body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
