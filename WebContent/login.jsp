<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인 페이지</h2>
	<form action="recipe" method="post">
	<input type="hidden" name="command" value="login">
		<table>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="nickname" placeholder="닉네임을 입력하세요:)"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="password" placeholder="비밀번호를 입력하세요:)"></td>
			</tr>
			<tr>
				<td>
					<button type="submit">로그인하기:)</button> &nbsp;&nbsp;
					<button type="button" onclick="location.href='chefJoin.jsp'">회원가입하기:)</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>