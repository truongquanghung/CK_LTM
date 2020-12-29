<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="f1" action="xulimatkhau" method="POST">
		<h2 align="center">Đổi mật khẩu</h2>
		<table align="center">
			<tr>
				<td>Mật khẩu cũ:</td>
				<td><input type="password" name="oldpass" size=30></input></td>
			</tr>
			<tr>
				<td>Mật khẩu mới:</td>
				<td><input type="password" name="newpass" size=30></input></td>
			</tr>
			<tr>
				<td>Nhập lại mật khẩu mới:</td>
				<td><input type="password" name="passagain" size=30></input></td>
			</tr>
		</table>
		<%
			if (session.getAttribute("error") != null) {
		%>
		<p align='center'><%=session.getAttribute("error") %></p>
		<%
			session.setAttribute("error",null);
			}
		%>
		<table align="center">
			<tr>
				<td><input type="submit" name="s1" value="OK"></td>
				<td><input type="reset" name="s2" value="Reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>