<%@page import="dao.CustomerVO"%>
<%@page import="dao.CustomerDAOImpl"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp 내장 객체 테스트 (request 객체)</h1>
	<%
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		Date d = new Date();
		ArrayList list = null;
		CustomerDAO dao =  new CustomerDAOImpl();
		CustomerVO user = dao.login(id,pass);
		
	%>
	<h2>아이디 : <%=id%></h2>
	<h2>비밀번호 : <%=pass%></h2>
	<% if ( user != null) {%>
	<h2><%= user.getName() %>님 로그인 성공!</h2>
	<%} else { 
		response.sendRedirect("/serverweb/jspbasic/login.jsp");
	}%>
	

</body>
</html>