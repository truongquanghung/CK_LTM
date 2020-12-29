<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
img {
	max-width: 100%;
}
</style>
</head>
<body>
	<%
		session.setAttribute("gv", null);
		session.setAttribute("pt", null);
		session.setAttribute("ca", null);
		session.setAttribute("dspc", null);
		session.setAttribute("dsgs", null);
	%>
	<form name="f1" action="xulifile" method="post"
		enctype="multipart/form-data">
		<h2 align="center">Tạo lịch thi</h2>
		<p align="center">
			Số ca thi (nhỏ hơn hoặc bằng 5): <input type="text" name="ca">
		<p align="center">
			Danh sách giảng viên: <input type="file" name="gv">
		<p align="center">
			Danh sách phòng thi: <input type="file" name="pt">
		<p align="center">
			<input type="submit" value="Xếp phòng thi">
	</form>
</body>
</html>