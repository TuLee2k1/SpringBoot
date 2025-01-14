<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REPORT</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container mt-3">
	<h4>TỒN KHO THEO LOẠI</h4>
	<table class="table mt-3 table-hover table-bordered">
		<tr class="bg-info mt-3">
			<th>Loại hàng</th>
			<th>Tổng giá</th>
			<th>Số sản phẩm</th>
		</tr>
		<c:forEach var="item" items="${items}">
			<tr>
				<td>${item.group.name}</td>
				<td>${item.sum}</td>
				<td>${item.count}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>