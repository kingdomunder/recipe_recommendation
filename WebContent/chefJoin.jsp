<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChefJoin</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="recipe" method="post">
	<input type="hidden" name="command" value="addChef">
		<table>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="nickname" placeholder="4글자 이상 입력하세요:)"></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" placeholder="4글자 이상 입력하세요:)"></td>
			</tr>
			
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="password2" placeholder="비밀번호를 한 번 더 입력하세요:)"></td>
			</tr>
			
			<tr>
				<td>
					<button type="submit">가입하기:)</button> &nbsp;&nbsp;
					<button type="reset">취소하기:(</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>