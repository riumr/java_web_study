package ch07;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

public class ListenerExam implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {

  public ListenerExam(){

  }

  public void contextInitialized(ServletContextEvent sce) {
    sce.getServletContext().log("ServletContext 시작됨");
  }


}
