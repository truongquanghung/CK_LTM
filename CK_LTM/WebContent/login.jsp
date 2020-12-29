<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (session.getAttribute("login") != null) {
	%>
	<h1 align="center">Hiện tại bạn vẫn đang đăng nhập</h1>
	<%
		} else {
	%>
	<form name="f1" action="xulilogin" method="POST">
		<h2 align="center">Login</h2>
		<table align="center">
			<tr>
				<td>Tên đăng nhập:</td>
				<td><input type="text" name="name" size=30></input></td>
			</tr>
			<tr>
				<td>Mật khẩu:</td>
				<td><input type="password" name="pass" size=30></input></td>
			</tr>
		</table>
		<%
			if (session.getAttribute("loi") != null) {
					session.setAttribute("loi", null);
		%>
		<p align='center'>Tài khoản hoặc mật khẩu không đúng!</p>
		<%
			}
		%>
		<table align="center">
			<tr>
				<td><input type="submit" name="s1" value="OK"></td>
				<td><input type="reset" name="s2" value="Reset"></td>
			</tr>
		</table>
	</form>
	<%
		}
	%>
</body>
</html>
