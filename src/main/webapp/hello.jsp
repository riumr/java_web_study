<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
<body>
<hr>
    <p>현재 날짜와 시간은</p>
    <%=java.time.LocalDateTime.now()%>
</body>
</head>