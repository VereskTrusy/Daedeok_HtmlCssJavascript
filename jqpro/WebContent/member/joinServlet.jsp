<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

System.out.println("[servlet] 시작");

StringBuffer buf = new StringBuffer();
String line = null;

BufferedReader reader = request.getReader();

while((line = reader.readLine()) != null) {
	System.out.println("[servlet] line : " + line);
	buf.append(line);
}

String reqData = buf.toString();

// 역직렬화 - 객체 형태로 변환하기
Gson gson = new Gson();
MemberVo vo = gson.fromJson(reqData, MemberVo.class);

// 서비스 객체 얻어오기 
IMemberService service = MemberServiceImpl.getService();

// 서비스 객체 호출 -  결과값받기
int res = service.insertMember(vo);

// 결과 값을 request에 저장
request.setAttribute("res", res);

// 뷰페이지로 이동
request.getRequestDispatcher("/member/joinView.jsp").forward(request, response);

%>