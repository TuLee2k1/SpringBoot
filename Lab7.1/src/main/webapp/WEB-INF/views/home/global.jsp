<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<b>${uri}</b>
<c:forEach var="item" items="${categories}">
	<li>${item.name}</li>
</c:forEach>