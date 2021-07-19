<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="kr.ac.kopo.kopo44.DAO.UserDAOImpl" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="user" class="kr.ac.kopo.kopo44.DTO.UserDTO" scope="page" />
<jsp:setProperty name="user" property="userID" />
<jsp:setProperty name="user" property="userPassword" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 웹 사이트</title>
</head>
<body>
	<%
	String userID = null;
			if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
			}
			if (userID != null) {//이미 로그인 되어 있는 상태면 로그인 불가
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 로그인이 되어있습니다.')");
		script.println("location.href='main.jsp'");
		script.println("</script>");
			}
			UserDAOImpl userDAO = new UserDAOImpl();
			int result = userDAO.login(user.getUserID(), user.getUserPassword());
			if (result == 1) {
		session.setAttribute("userID", user.getUserID());//세션값부여
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인 성공.')");
		script.println("location.href='main.jsp'");
		script.println("</script>");
			} else if (result == 0) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 틀립니다.')");
		script.println("history.back()");
		script.println("</script>");
			} else if (result == -1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지 않는 아이디입니다.')");
		script.println("history.back()");
		script.println("</script>");
			} else if (result == -2) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('데이터베이스 오류입니다.')");
		script.println("history.back()");
		script.println("</script>");
			}
	%>	
</body>
</html>