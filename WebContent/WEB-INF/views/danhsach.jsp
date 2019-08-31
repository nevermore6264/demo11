<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Danh sách sinh viên</title>
</head>
<body>
	<button>
		<a href="create">Thêm mới</a>
	</button>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>Mã sinh viên</td>
			<td>Họ và tên</td>
			<td>Giới tính</td>
			<td>Quê quán</td>
			<td>Khóa học</td>
		</tr>
		<c:forEach items="${listStudent}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.code}</td>
				<td>${student.fullname}</td>
				<td>${student.gender}</td>
				<td>${student.hometown}</td>
				<td>${student.course.name}</td>
				<td><a href="update?id=${student.id }">Cập nhật</a></td>
				<td><a href="delete?id=${student.id }">Xóa</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>