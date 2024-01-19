<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.dao.IMemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// Controller 역활 : 클라이언트 전송 시 데이터 받기


// service 객체 얻기
IMemberService service = MemberServiceImpl.getService();

// service 메서드 호출 하기 - 결과값 받기
List<MemberVo> list = service.getAllMember();

//  결과값을 request에 저장
request.setAttribute("list", list);

// 결과값을 출력 - view 페이지로 이동(MemberView.jsp)
// 결과값을 공유해야함 - forward
request.getRequestDispatcher("/0119/MemberView.jsp").forward(request, response);






%>