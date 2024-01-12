<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상태필터.jsp</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String userId = request.getParameter("id");
String userPass = request.getParameter("pass");
String userName = request.getParameter("name");

out.print("아이디 : " + userId);
out.print("패스워드 : " + userPass);
out.print("이름 : " + userName);

%>
</body>
</html>