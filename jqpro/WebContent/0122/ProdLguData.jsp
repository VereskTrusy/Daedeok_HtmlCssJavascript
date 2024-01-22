<%@page import="kr.or.ddit.prod.vo.ProdVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// controller에서 저장한 데이터 꺼내기
// 결과값타입 변수명 = request.getAttribute("name");
List<ProdVo> list = (List<ProdVo>) request.getAttribute("prodlist");


// 변수명을 이용하여 json형식의 배열 데이터를 생성
if(list != null && list.size() > 0 && !list.isEmpty()) {
// 데이터 있을 때 %>
	{
		"flag" : "OK",
		"datas" : 
			[
<%
				for(int i = 0; i < list.size(); i++){
					
					ProdVo vo = list.get(i);
					
					if(i > 0) out.print(","); // 배열의 0번째 요소 이후는 콤마로 구분
%>
						{
							"prod_id" : "<%= vo.getProd_id() %>",
							"prod_name" : "<%= vo.getProd_name() %>"
						}
<%
					}
%>
			]
	}
<% } else { // 데이터 없을 때 %> 
	{
		"flag" : "NO"
		"datas" : ""
	}
	
<%	
	}
%>
