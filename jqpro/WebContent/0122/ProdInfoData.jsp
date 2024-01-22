<%@page import="kr.or.ddit.prod.vo.ProdVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

ProdVo prod = (ProdVo) request.getAttribute("prodInfo");
%>

{
	"prod_id" : "<%= prod.getProd_id() %>",
	"prod_name" : "<%= prod.getProd_name() %>",
	"prod_lgu" : "<%= prod.getProd_lgu() %>",
	"prod_buyer" : "<%= prod.getProd_buyer() %>",
	"prod_cost" : "<%= prod.getProd_cost() %>",
	"prod_price" : "<%= prod.getProd_price() %>"
}