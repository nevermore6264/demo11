<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="create" modelAttribute="student" method="post">
		<input type="hidden" name="id" value="${student.id }">
		<!-- thêm cái này để truyền bookId -->

		<table>
			<tr>
				<td>Mã sinh viên</td>
				<td><form:input path="code" /></td>
			</tr>

			<tr>
				<td>Tên sinh viên</td>
				<td><form:input path="fullname" /></td>
			</tr>
			<tr>
				<td>Chuyên ngành</td>
				<td><form:select path="course.id">
						<form:options items="${course }" itemValue="id" itemLabel="name"></form:options>
					</form:select></td>
			</tr>
			<tr>
				<td>Giới tính</td>
				<td><form:input path="gender" /></td>
			</tr>
			<tr>
				<td>Quê quán</td>
				<td><form:input path="hometown" /></td>
			</tr>

		</table>
		<button>Luu</button>
	</form:form>
</body>
</html>