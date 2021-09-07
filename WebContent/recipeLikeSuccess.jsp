<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RecipeLikeSuccess</title>
</head>
<body>
	${recipe.foodName} 레시피에 좋아요를 등록했습니다. <br>
	
	<button onclick="location.href='recipe?command=recipeAll'">모든 레시피 보기</button><br>
</body>
</html>