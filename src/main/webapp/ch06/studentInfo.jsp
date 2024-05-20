<%@ page language="java" contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentInfo</title>
</head>
<body>
    <table border="1">
    <tr>
        <th>id</th>
        <th>이름</th>
        <th>대학</th>
        <th>생일</th>
        <th>이메일</th>
    </tr>
    <c:forEach items="${students}" var="s">
    <tr>
        <td>${s.id}</td>
        <td>${s.username}</td>
        <td>${s.univ}</td>
        <td>${s.birth]</td>
        <td>${s.email}</td>
    </tr>
    </c:forEach>
    <form method="post" action="../studentControl?action=insert">
        <label>이름</label>
        <input type="text" name="username"><br>
        <label>대학</label>
        <input type="text" name="univ"><br>
        <label>생일</label>
        <input type="text" name="birth"><br>
        <label>이메일</label>
        <input type="text" name="email"><br>
        <button type="submit">등록</button>
    </form>
</body>
</html>