<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.ZipVo"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

// 요청시 전송 데이터 받기
String dong = request.getParameter("dong");
System.out.println("[servlet] 요청 받은 데이터  " + dong);

// 서비스 객체 얻기
IMemberService service = MemberServiceImpl.getService();

// 서비스 메서드 호출 - 결과값 받기
List<ZipVo> postList = service.selectSearchPost(dong);

// 결과값을 request에 저장
request.setAttribute("postList", postList);

// data세팅 페이지로 이동
request.getRequestDispatcher("/member/searchPostData.jsp").forward(request, response);

%>