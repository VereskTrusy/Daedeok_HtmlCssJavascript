<%@page import="kr.or.ddit.buyer.vo.BuyerVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.buyer.service.IBuyerService"%>
<%@page import="kr.or.ddit.buyer.service.BuyerServiceImpl"%>
<%@page import="kr.or.ddit.buyer.dao.BuyerDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
System.out.println("[모의 서블렛] buyer List 조회 로직 시작");

System.out.println("[모의 서블렛] BuyerServiceImpl.getInstance() 호출");
IBuyerService service = BuyerServiceImpl.getInstance();

System.out.println("[모의 서블렛] service.selectBuyerList() 호출");
List<BuyerVo> buyerList = service.selectBuyerList();

System.out.println("[모의 서블렛] request.setAttribute() 호출");
request.setAttribute("buyerList", buyerList);

System.out.println("[모의 서블렛] request.getRequestDispatcher() 호출");
request.getRequestDispatcher("/buyer/buyerData.jsp").forward(request, response);

System.out.println("[모의 서블렛] buyer List 조회 로직 종료");
%>