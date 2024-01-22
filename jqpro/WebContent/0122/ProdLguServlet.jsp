<%@page import="kr.or.ddit.prod.vo.ProdVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@page import="kr.or.ddit.prod.service.IProdService"%>
<%@page import="java.awt.image.ImageProducer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// Controller 역활 : 요청 시 전송 데이터 받기

// data로 받은 값
String lgu = request.getParameter("lprod_gu");

// service객체 생성
IProdService service = ProdServiceImpl.getInstance();

// service 메서드 호울 -> List<LprodVo> 데이터형으로 결과값 받기 
List<ProdVo> prodlist = service.selectByLguList(lgu);

// 결과 값을 request에 저장
request.setAttribute("prodlist", prodlist);

// view로 이동한다.  - forward 사용 - LprodView.jsp
request.getRequestDispatcher("/0122/ProdLguData.jsp").forward(request, response);

%>
