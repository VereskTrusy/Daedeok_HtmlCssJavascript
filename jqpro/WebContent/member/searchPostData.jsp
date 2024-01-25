<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.ZipVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

List<ZipVo> list = (List<ZipVo>) request.getAttribute("postList");

// list객체를 json 형태의 문자열로 직렬화하여 보내기

Gson gson = new GsonBuilder().setPrettyPrinting().create(); // 예쁘예쁘띠잉
String res = gson.toJson(list); // [{}, {}, {}] 의 형태로 만들어짐

out.print(res);
out.flush();

%>
