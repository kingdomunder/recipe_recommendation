<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RecipeAll</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>레시피 번호</th>
				<th>이름</th>
				<th>메인재료</th>
				<th>만드는 법</th>
				<th>게시자</th>
				<th>좋아요</th>
			</tr>
		</thead>
		<c:forEach items="${recipeAll}" var="recipe">
			<tr>
				<td>${recipe.recipeId}</td>
				<td>${recipe.foodName}</td>
				<td>${recipe.ingredientId.ingredient1}</td>
				<td>${recipe.direction}</td>
				<td>${recipe.recipeOwner}</td>
				<td>${recipe.like}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>