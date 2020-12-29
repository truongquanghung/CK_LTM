<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<BODY style="background-color: lightyellow;">
	<form name="f1" method="post">
		<table align="center">
			<tr>
				<td></td>
			</tr>
			<tr>
				<td><p align="center">Mục Lục</p></td>
			</tr>
			<tr>
				<td align="center"><a href="homepage.jsp" target="main"> Trang chủ </a></td>
			</tr>
			<tr>
				<td align="center"><a href="login.jsp" target="main"> Đăng nhập </a></td>
			</tr>
			<tr>
				<td align="center"><a href="xulidoimatkhau" target="main"> Đổi mật khẩu </a></td>
			</tr>
			<tr>
				<td align="center"><a href="xulidanhsach" target="main"> Danh sách Tài khoản </a></td>
			</tr>
			<% if (session.getAttribute("login")!=null && session.getAttribute("login").equals("admin")) {%>
			<tr>
				<td align="center"><a href="themtaikhoan.jsp" target="main"> Thêm tài khoản </a></td>
			</tr>
			<% }%>
			<tr>
				<td align="center"><a href="xulitinhbieuthuc" target="main"> Tính giá trị biểu thức </a></td>
			</tr>
			<tr>
				<td align="center"><a href="xulichuyenanh" target="main"> Chuyển đổi ảnh </a></td>
			</tr>
		</table>
	</form>
</BODY>
</html>