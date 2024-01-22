<%@page import="kr.or.ddit.lprod.vo.LprodVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.lprod.service.LprodServiceImpl"%>
<%@page import="kr.or.ddit.lprod.service.ILprodService"%>
<%@page import="java.awt.image.ImageProducer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// Controller 역활 : 요청 시 전송 데이터 받기


// service객체 생성
ILprodService service = LprodServiceImpl.getInstance();

// service 메서드 호울 -> List<LprodVo> 데이터형으로 결과값 받기 
List<LprodVo> list = service.selectLprod();

// 결과 값을 request에 저장
request.setAttribute("list", list);

// view로 이동한다.  - forward 사용 - LprodView.jsp
request.getRequestDispatcher("/0119/LprodData.jsp").forward(request, response);

%>
