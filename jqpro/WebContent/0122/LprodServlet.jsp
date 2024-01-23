<%@page import="kr.or.ddit.prod.vo.ProdVo"%>
<%@page import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@page import="kr.or.ddit.prod.service.IProdService"%>
<%@page import="kr.or.ddit.lprod.vo.LprodVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.lprod.service.LprodServiceImpl"%>
<%@page import="kr.or.ddit.lprod.service.ILprodService"%>
<%@page import="java.awt.image.ImageProducer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// Controller 역활 : 요청 시 전송 데이터 받기

String menu = request.getParameter("menu");

// System.out.println(menu);

if(menu.equals("LprodServlet")){
	System.out.println("[모의 서블렛] LprodServlet 로직 시작");
	
	// service객체 생성
	ILprodService service = LprodServiceImpl.getInstance();

	// service 메서드 호울 -> List<LprodVo> 데이터형으로 결과값 받기 
	List<LprodVo> list = service.selectLprod();
	
	/* for(LprodVo item : list){
		System.out.println(item.toString());
	} */
	
	// 결과 값을 request에 저장
	request.setAttribute("list", list);

	// view로 이동한다.  - forward 사용 - LprodView.jsp
	request.getRequestDispatcher("/0122/LprodData.jsp").forward(request, response);
	
	System.out.println("LprodServlet 로직 끝");

} else if(menu.equals("ProdLguServlet")){
	System.out.println("[모의 서블렛] ProdLguServlet 로직 시작");
	
	
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
	
	System.out.println("ProdLguServlet 로직 끝");

} else if(menu.equals("ProdInfoServlet")){
	System.out.println("[모의 서블렛] ProdInfoServlet 로직 시작");
	
	String prod_id = request.getParameter("prod_id");

	IProdService service = ProdServiceImpl.getInstance();

	ProdVo prodInfo = service.selectByProdId(prod_id);

	request.setAttribute("prodInfo", prodInfo);

	request.getRequestDispatcher("/0122/ProdInfoData.jsp").forward(request, response);
	
	System.out.println("ProdInfoServlet 로직 끝");
}



%>
