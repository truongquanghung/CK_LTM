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
		if (session.getAttribute("dspc") != null && session.getAttribute("dsgs") != null) {
	%>
	<h2 align="center">Đã tạo lịch thi thành công!</h2>
	<form name="f2" action="phancong" method="post">
		<p align="center">
			<input type="submit" value="Tải danh sách phân công!">
	</form>
	<form name="f3" action="giamsat" method="post">
		<p align="center">
			<input type="submit" value="Tải danh sách giám sát!">
	</form>
	<form name="f1" action="index.jsp" method="post">
		<p align="center">
			<input type="submit" value="Xếp lịch thi khác!">
	</form>
	<%
		} else {
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location","index.jsp"); 
		}
	%>
</body>
</html>