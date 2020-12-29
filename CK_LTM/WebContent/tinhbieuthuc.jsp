<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="f1" action="xulibieuthuc" method="post">
	<h2 align="center">Tính giá trị biểu thức</h2>
		<table align="center">
			<tr align="center">
				<td>Nhập biểu thức cần tính (bao gồm các phép +, -, *, /, số âm phải để trong ngoặc):</td>
				
			</tr>
			<tr>
				<td><input type="text" name="bt" size=100></input></td>
			</tr>
		</table>
		<%
			if (session.getAttribute("res") != null) {
		%>
		<p align='center'><%=session.getAttribute("res") %></p>
		<%
			session.setAttribute("res",null);
			}
		%>
		<table align="center">
			<tr>
				<td><input type="submit" name="s1" value="Tính biểu thức"></td>
			</tr>
		</table>
	</form>
</body>
</html>