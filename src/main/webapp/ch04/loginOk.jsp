<%@ page language="java" contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
<body>
<%! String id; %>
<% id = session.getAttribute("id").toString();
    out.println(session.getAttribute("id"));
    if (session.getAttribute("id").equals("")){
        out.println("id를 입력해주세요."); }
    else{ out.println(id + "님 안녕하세요.");
    }
%>
</body>
</html>