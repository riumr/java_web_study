<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%
    int n1 = Integer.parseInt(request.getParameter("n1"));
    int n2 = Integer.parseInt(request.getParameter("n2"));
    String op = request.getParameter("op");
    long result = 0L;
    switch (op) {
    case "+" : result = n1 + n2; break;
    case "-" : result = n1 - n2; break;
    case "*" : result = n1 * n2; break;
    case "/" : result = n1 / n2; break;
    }
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
    결과 <%=result%>
</html>