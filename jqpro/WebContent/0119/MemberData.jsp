<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// controller에서 저장한 데이터 꺼내기
List<MemberVo> list = (List<MemberVo>) request.getAttribute("list");


//데이터 만들기 - json object의 배열을 생성
%>

[
	<%
	for(int i=0; i<list.size(); i++){
		MemberVo vo = list.get(i);
		
		if(i > 0) out.print(",");
	%>
		{
			"mem_id" : "<%= vo.getMem_id() %>",
			"mem_name" : "<%= vo.getMem_name() %>", 
			"mem_hp" : "<%= vo.getMem_hp() %>"
		}
	<%
	}
	%>
]