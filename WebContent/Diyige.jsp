<%@page import="pojo.Student"%>
<%@page import="java.util.List"%>
<%@page import="service.StudentServiceImpl"%>
<%@page import="service.IStudentService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="/java1711web/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<style type="text/css">
.align-center {
	width: 800px;
	margin: 10px auto;
}

.btn-info {
	margin: 0px 10px 0px 450px;
}
</style>
<script type="text/javascript">
	function delStudent(id) {
		var isDel = confirm("您确认要 删除么？");
		if (isDel) {
			location.href = "${pageContext.request.contextPath}/delete.do?id="
					+ id;
		}
	}
</script>
</head>
<body>
	<div class="align-center">
		<form action="${pageContext.request.contextPath}/findByName.do"
			method="post">
			姓名：<input type="text" name="name" /> <input type="submit" value="搜索" />
			<a class="btn btn-info" href="${pageContext.request.contextPath}/Earth.html">添加</a>
		</form>
		<br>
		<table
			class="table table-striped table-bordered table-hover table-condensed">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>地址</th>
				<th>删除</th>
				<th>修改</th>
			</tr>
			<c:forEach items="${list}" var="student">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.age}</td>
					<td>${student.gender}</td>
					<td>${student.address}</td>
					<%-- <td><a href="/java1711web/delete.do?id=<%=student.getId() %>">删除</a></td> --%>
					<td><a href="javascript:delStudent(${student.id})">删除</a></td>
					<td><a href="${pageContext.request.contextPath}/findupdate.do?id=${student.id}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>