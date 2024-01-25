<%@page import="org.apache.log4j.Logger"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 여기는 서블릿 역활을 하는 파일이다.
// controller가 하는 일을 명시하면 된다.

// 요청 시 전송데이터 받기 get방식으로 데이터 받을 때 사용
//String memId = request.getParameter("id");

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


String mem_id = vo.getMem_id();
System.out.println("[servlet] mem_id : " + mem_id);


IMemberService service = MemberServiceImpl.getService();

int idChk = service.selectIdChk(mem_id);

// 페이지, 세션, 리퀘스트, 어플리케이션 에 데이터를 저장가능하다
request.setAttribute("idChk", idChk);

request.getRequestDispatcher("/member/idData.jsp").forward(request, response);

System.out.println("[servlet] 끝");
%>