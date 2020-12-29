<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: lightyellow;">
	Họ và tên: Trương Quang Hùng
	<br> MSSV: 102170022
	<br> Lớp sinh hoạt: 17T1
	<br> Lớp học phần: 17N10
	<br>
	<%
		if (session.getAttribute("login") == null) {
	%>
	<form name="f1" method="POST">
		<p align="center">Chưa có tài khoản đăng nhập</p>
	</form>
	<%
		} else {
	%>
	<p align='center'>
		Tài khoản:
		<%=(String) session.getAttribute("login")%>
	<form name="f1" method="POST" action="logout.jsp">
		<p align="center">
			<input type="submit" name="s1" value="Đăng xuất">
		</p>
	</form>
	<%
		}
	%>
</body>
</html>
