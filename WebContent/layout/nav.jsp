<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="/step12_miniproject/index.html"><h3 class="w3-padding-64 w3-center"><b>방구석<br>Chef</b></h3></a>
<a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-padding w3-hide-large">CLOSE</a>

<c:if test="${not empty sessionScope.nickname}">
<div style="color:black; padding-bottom:20px">${sessionScope.nickname}님 환영합니다.</div>
</c:if>

<a href="/step12_miniproject/recipe?command=recipeAll" onclick="w3_close()" class="w3-bar-item w3-button">모든 레시피 보기</a>
<a href="/step12_miniproject/ingredient/select.jsp" onclick="w3_close()" class="w3-bar-item w3-button">재료 선택하기</a>

<c:if test="${empty sessionScope.nickname}">
<a href="/step12_miniproject/chefJoin.jsp" onclick="w3_close()" class="w3-bar-item w3-button">회원가입</a>
</c:if>

<c:if test="${empty sessionScope.nickname}">
<a href="/step12_miniproject/login.jsp" onclick="w3_close()" class="w3-bar-item w3-button">로그인</a>
</c:if>

<c:if test="${not empty sessionScope.nickname}">
<a href="/step12_miniproject/recipe?command=myRecipe" onclick="w3_close()" class="w3-bar-item w3-button">마이 페이지</a>
</c:if>

<c:if test="${not empty sessionScope.nickname}">
<a href="/step12_miniproject/recipe?command=logout" onclick="w3_close()" class="w3-bar-item w3-button">로그아웃</a>
</c:if>