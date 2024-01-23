<%@page import="kr.or.ddit.prod.vo.ProdVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.prod.service.IProdService"%>
<%@page import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%


String prod_id = request.getParameter("prod_id");

IProdService service = ProdServiceImpl.getInstance();

ProdVo prodInfo = service.selectByProdId(prod_id);

request.setAttribute("prodInfo", prodInfo);

request.getRequestDispatcher("/0122/ProdInfoData.jsp").forward(request, response);

%>