<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP : Java Server Page</h1>
	<%
	request.setCharacterEncoding("UTF-8");
	
	// 전송되는 화면에서 name="id"값에 해당하는 요소의 값을 전달 받음
	String userId = request.getParameter("id");
	String userName = request.getParameter("name");
	
	// 여기서 out.print();를 사용해서 테스트 확인을 해도 된다.
	%>
	
	<table border=1>
		<tr>
			<th>아이디</th>
			<td><%= userId %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%= userName %></td>
		</tr>
	</table>
</body>
</html>