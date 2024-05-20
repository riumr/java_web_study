<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
<body>
    <%!
        String[] members = {"a","b","c","d"};

        int calc(int num1, int num2) {
            return num1 + num2;
        }
    %>
    <%=calc(10, 10)%>
    <%@ include file="../hello.jsp"%>
    <ul>
    <%
        for (String name : members) {
    %>
        <li><%=name%></li>
    <%
        }
    %>
    </ul>
</body>
</html>
