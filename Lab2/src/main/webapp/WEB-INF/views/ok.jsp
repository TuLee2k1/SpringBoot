<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/ctrl/ok" method="post">
		<button>OK 1</button>
		<button formmethod="get">OK 2</button>
		<button formaction="/ctrl/ok?x">OK 3</button>
	</form>
	Kết quả: ${ok }
</body>
</html>