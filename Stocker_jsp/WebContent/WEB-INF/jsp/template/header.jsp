<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header>
	<h1>
		<a href="/">Stocker</a>
	</h1>
	
	<nav>
		<ul>
			<li><a href="/home">Home</a></li>
			<li><a href="/explore">Explore</a></li>
			<li><a href="/artist">Artist</a></li>
			<li><a href="/login">${current_user.nm}</a></li>
			<li><a href="/logout">Logout</a></li>
		</ul>
	</nav>
</header>