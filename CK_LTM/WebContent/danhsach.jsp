<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		List<String> ds = (ArrayList<String>) request.getAttribute("danhsach");
	%>
	<form name="f1" action="xulixoataikhoan" method="POST">
		<h2 align="center">Danh sách Account của hệ thống</h2>
		<table align="center" border="1">
			<tr>
				<th>STT</th>
				<th>Tên tài khoản</th>
				<%
					if (session.getAttribute("login") != null && session.getAttribute("login").equals("admin")) {
				%>
				<th>Xóa tài khoản</th>
				<%
					}
				%>
			</tr>
			<%
				for (int i = 1; i < ds.size(); i++) {
			%>
			<tr>
				<td><%=i%></td>
				<td><%=ds.get(i)%></td>
				<%
					if (session.getAttribute("login") != null && session.getAttribute("login").equals("admin")) {
				%>
				<td align="center"><input type='checkbox' name='name'
					value='<%=ds.get(i)%>'></input></td>
				<%
					}
				%>
			</tr>
			<%
				}
			%>
		</table>
		<%
			if (session.getAttribute("login") != null && session.getAttribute("login").equals("admin")) {
		%>
		<p align="center">
			<input type="submit" name="s1" value="Xóa các mục đã chọn"></input>
		</p>
		<%
			}
		%>
	</form>
</body>
</html>