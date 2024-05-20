package ch05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calcControl")
public class CalcController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int n1 = Integer.parseInt(req.getParameter("n1"));
    int n2 = Integer.parseInt(req.getParameter("n2"));
    String op = req.getParameter("op");

    Calculator calc = new Calculator();
    calc.setN1(n1);
    calc.setN2(n2);
    calc.setOp(op);
    long result = calc.calc();
    //System.out.println(result);
    req.setAttribute("result", result);
    getServletContext().getRequestDispatcher("/ch05/calcResult.jsp").forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
