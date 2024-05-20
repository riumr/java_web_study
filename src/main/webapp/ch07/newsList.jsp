<%@ page language="java" contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
<body>
<h2>News List</h2>
<hr>
    <ul class="list-group">
        <c:forEach var="news" items="${newsList}" varStatus="status">
            <li class="list-group-item list-group-action d-flex justify-content-between align-item-center">
                [${status.count}]
                <a href="/news.nhn?action=getNews&aid=${news.aid}" class="text-decoration-none">${news.title}</a>
                ${news.date}
                <a href="/news.nhn?action=delNews&aid=${news.aid}"><span class="badge bg-secondary">&times;</span></a>
            </li>
        </c:forEach>
    </ul>
    <form method="post" action="/news.nhn?action=addNews" enctype="multipart/form-data">
        <label>제목</label>
        <input type="text" name="title">
        <label>이미지</label>
        <input type="file" name="file">
        <label>기사 내용</label>
        <textarea rows="5" name="content"></textarea>
        <button type="submit">저장</button>
    </form>
</body>
</html>