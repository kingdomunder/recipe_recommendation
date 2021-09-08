<title>재료 선택하기</title>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<meta charset="UTF-8">
    
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">    
    
<!DOCTYPE html>
<html>
<head>

  <div class="w3-container w3-dark-grey w3-center w3-text-light-grey w3-padding-32" id="about">
		--- 추천 메뉴 --- <p>

					
  </div>
<!-- About section -->
  <div class="w3-container w3-dark-grey w3-center w3-text-light-grey w3-padding-32" id="about">
		<c:forEach items="${requestScope.recommend}" var="recommend">
			 ${recommend}
		</c:forEach>	
		${requestScope.selectError}
  </div>
  
</head>

<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
.w3-third img{margin-bottom: -6px; opacity: 0.8; cursor: pointer}
.w3-third img:hover{opacity: 1}
</style>

<body class="w3-light-grey w3-content" style="max-width:1600px">

<!-- 네비게이션 -->
<nav class="w3-sidebar w3-bar-block w3-white w3-text-grey w3-collapse w3-top w3-center" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
  <a href="/step12_miniproject/index.html"><h3 class="w3-padding-64 w3-center"><b>방구석<br>셰프</b></h3></a>
  <a href="/step12_miniproject/javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-padding w3-hide-large">CLOSE</a>
  <a href="/step12_miniproject/recipe?command=recipeAll" onclick="w3_close()" class="w3-bar-item w3-button">모든 레시피 보기</a>
  <a href="/step12_miniproject/ingredient/select.jsp" onclick="w3_close()" class="w3-bar-item w3-button">재료 선택하기</a>
  <a href="/step12_miniproject/chefJoin.jsp" onclick="w3_close()" class="w3-bar-item w3-button">회원가입</a>
  <a href="/step12_miniproject/login.jsp" onclick="w3_close()" class="w3-bar-item w3-button">로그인</a>
  <a href="/step12_miniproject/addRecipe.html" onclick="w3_close()" class="w3-bar-item w3-button">레시피 등록</a>
</nav>

<!-- !PAGE CONTENT! -->
<div class="w3-main">

  <!-- Footer -->
    <div class="w3-row-padding w3-grey">
      <div class="w3-third  w3-left" id="about">
        <h3>메인 재료</h3>
            <form action="/step12_miniproject/recipe">
				<input type="hidden" name="command" value="selectIngredient">
					<button type="submit" name="ingredient" value="파스타면">파스타면</button>
					<button type="submit" name="ingredient" value="밥">밥</button>
			</form>
      </div>
	</div>      
      
    <div class="w3-row-padding w3-grey">
      <div class="w3-third  w3-right" id="about">
        <h3>부가 재료</h3>
        <form action="/step12_miniproject/recipe">
			<input type="hidden" name="command" value="selectIngredient">
			
			<button type="submit" name="ingredient" value="계란">계란</button>
			<button type="submit" name="ingredient" value="돼지고기">돼지고기</button>
<p>
			<button type="submit" name="ingredient" value="김치">김치</but	ton>
			<button type="submit" name="ingredient" value="마늘">마늘</button>
			<button type="submit" name="ingredient" value="파">파</button>
			<button type="submit" name="ingredient" value="깨">깨</button>
<p>
			<button type="submit" name="ingredient" value="간장">간장</button>
			<button type="submit" name="ingredient" value="참기름">참기름</button>
			<button type="submit" name="ingredient" value="크림">크림</button>
			<button type="submit" name="ingredient" value="토마토소스">토마토소스</button>
		</form>
		</div>
    </div>
  

<!-- End page content -->
</div>


    </div>
  </footer>
  

<!-- End page content -->
</div>
		
</body>
<footer>

  <div class="w3-container w3-dark-grey w3-center w3-text-light-grey w3-padding-32" id="about">
  
		<form action="/step12_miniproject/recipe">
			<button type="submit" name="command" value="clearIngredient">초기화</button> 
		</form>

  </div>


  <div class="w3-container w3-dark-grey w3-center w3-text-light-grey w3-padding-32" id="about">
  
		선택한 재료들 : ${Cookies}

  </div>
  
      <div class="w3-section">
      TEST
      </div>
  
</footer>

</html>