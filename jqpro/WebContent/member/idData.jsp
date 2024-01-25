<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
int idChk = (int)request.getAttribute("idChk");

if(idChk > 0){ 
%>

	{
		"flag" : "사용불가 ID"
	}

<% } else { %>

	{
		"flag" : "사용가능 ID"
	}

<% } %>