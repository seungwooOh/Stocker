<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stocker - ${page}</title>
<link rel="stylesheet" href="/css/common.css">
<c:forEach var="file_nm" items="${styles}">
	<link rel="stylesheet" href="/css/${file_nm}.css">
</c:forEach>
<link rel="stylesheet" href="/css/${page}.css">
</head>
<body>
	<div id="wrap">
		<header>
			<h1>
				<a href="/">Stocker</a>
			</h1>

			<jsp:include page="./${sessionScope.current_user != null ? 'nav_after' : 'nav_before'}.jsp" />
		</header>
		<main>
			<jsp:include page="../${page}.jsp"></jsp:include>
		</main>
	</div>
</body>
</html>