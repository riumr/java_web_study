<%@ page language="java" contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
<body>
    <form action="/login" method="post">
    id : <input type="text" size="10" name="id">
    pw : <input type="password" size="10" name="pw">
    <input type="submit" value=“로그인"/>
    <input type="reset" value=“재입력"/>
    </form>
</body>
</html>