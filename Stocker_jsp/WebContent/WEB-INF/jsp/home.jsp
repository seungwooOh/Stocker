<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="content">
	<c:forEach var="article" items="${list}">

		<div class="item" data-id="${article.id }">
			<img alt="Open model - ${article.getTitle()}"
				src="/images/${article.getFile_nm()}">
			<div>
				<strong>${article.getTitle()}</strong>
				<small>${article.getAuthor_nm()}</small>
			</div>
		</div>

	</c:forEach>
</section>

<article id="modal" class="hide">
	<div id="modal_inner"></div>
</article>

<script type="text/javascript" src="/js/modal.js"></script>