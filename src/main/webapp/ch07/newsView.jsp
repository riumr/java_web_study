<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
<body>
    <h2>${news.title}</h2>
    <img src="${news.img}" alt="news image">
    <div>
        <h4>${news.date}</h4>
        <p>${news.content}</p>
    </div>
</body>
</html>