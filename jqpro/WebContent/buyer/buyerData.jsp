<%@page import="kr.or.ddit.buyer.vo.BuyerVo"%>
<%@page import="kr.or.ddit.lprod.vo.LprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// controller에서 저장한 데이터 꺼내기
// 결과값타입 변수명 = request.getAttribute("name");
List<BuyerVo> buyerList = (List<BuyerVo>) request.getAttribute("buyerList");

// 변수명을 이용하여 json형식의 배열 데이터를 생성
%>

<% // 배열 시작 %>
[
<%
for(int i = 0; i < buyerList.size(); i++){
	BuyerVo vo = buyerList.get(i);
	
	if(i > 0) out.print(","); // 배열의 0번째 요소 이후는 콤마로 구분
%>
		{
			"buyer_id" : "<%= vo.getBuyer_id() %>",
			"buyer_name" : "<%= vo.getBuyer_name() %>"
		}
<%
	}
%>

]
<% // 배열 끝 %>
