<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재료 선택하기</title>
</head>
<body>

		<form action="/step12_miniproject/recipe">
			<input type="hidden" name="command" value="selectIngredient">
			
			<button type="submit" name="ingredient" value="파스타면">파스타면</button>
			<button type="submit" name="ingredient" value="밥">밥</button>
<p>
			<button type="submit" name="ingredient" value="계란">계란</button>
			<button type="submit" name="ingredient" value="돼지고기">돼지고기</button>
<p>
			<button type="submit" name="ingredient" value="김치">김치</button>
			<button type="submit" name="ingredient" value="마늘">마늘</button>
			<button type="submit" name="ingredient" value="파">파</button>
			<button type="submit" name="ingredient" value="깨">깨</button>
<p>
			<button type="submit" name="ingredient" value="간장">간장</button>
			<button type="submit" name="ingredient" value="참기름">참기름</button>
			<button type="submit" name="ingredient" value="크림">크림</button>
			<button type="submit" name="ingredient" value="토마토소스">토마토소스</button>
		</form>

		<form action="/step12_miniproject/recipe">
			<button type="submit" name="command" value="clearIngredient">초기화</button> 
		</form>

<p>
			<button onclick="location.href='/step12_miniproject/index.html'">메인으로</button>

		
</body>
<footer>

선택한 재료들 : ${Cookies}

</footer>

</html>