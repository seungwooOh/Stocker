<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section id="content">
	<h2>Login page</h2>
	<p class="err_msg">${err_msg}</p>
	<form action="/login" method="post">
		<input type="email" name="email" id="email" value="아이디">
		<input type="password" name="pw" id="pw" value="비밀번호">
		<input type="submit" value="로그인">
	</form>
	
</section>

<script>
	// set test values
	email.value = 'test@email.com';
	pw.value = '123';
</script>