<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String url = application.getContextPath() + "/"; %>

<!DOCTYPE html>
<html lang="en">
<title>재료 선택하기</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/step12_miniproject/css/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">

<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
.w3-third img{margin-bottom: -6px; opacity: 0.8; cursor: pointer}
.w3-third img:hover{opacity: 1}"WebContent/recipeAll.jsp"
</style>

<body class="w3-light-grey w3-content" style="max-width:1600px">

<!-- 네비게이션 -->
<nav class="w3-sidebar w3-bar-block w3-white w3-animate-left w3-text-grey w3-collapse w3-top w3-center" style="z-index:3;width:300px;font-weight:bold" id="mySidebar"><br>
	<jsp:include page="../layout/nav.jsp" />
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-white w3-xlarge w3-padding-16">
  <span class="w3-left w3-padding">SOME NAME</span>
  <a href="javascript:void(0)" class="w3-right w3-button w3-white" onclick="w3_open()">&#9776;</a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px">

  <!-- Push down content on small screens --> 
  <div class="w3-hide-large" style="margin-top:83px"></div>
  
  
  
  
  <!-- 각 페이지마다 내용 바꿀 부분 !! - 모든 레시피 출력 -->
  <div class="form-container ">
  
    <div class="w3-row">
       <div class="recipe-header">추천 메뉴 : </div>
  		  <c:forEach items="${requestScope.recommend}" var="recommend">
			 <a href="/step12_miniproject/recipe?command=recipeOne&foodName=${recommend}">${recommend}</a>
		  </c:forEach>	
    </div>
	  
    <div class="recipe-block">	
		${requestScope.selectError}
    </div>
  	  
	<div class="recipe-block">
        <h3>메인 재료</h3>
	</div>
		
	<div class="recipe-block">
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=파스타면">
		<img src="/step12_miniproject/ingredient/images/pastaNoodles.jpg" style="width:5%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=밥">
		<img src="/step12_miniproject/ingredient/images/rice.jpg" style="width:5%">
		</a>    
	</div>
<br>
<br>
	<div class="recipe-block">
        <h3>부가 재료</h3>
	</div>			
	
	<div class="recipe-block">
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=계란">
		<img src="/step12_miniproject/ingredient/images/egg.jpg" style="width:5%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=돼지고기">
		<img src="/step12_miniproject/ingredient/images/pig.jpg" style="width:5%">
				</a>
<p>
				<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=김치">
				<img src="/step12_miniproject/ingredient/images/kimchi.jpg" style="width:5%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=마늘">
		<img src="/step12_miniproject/ingredient/images/garlic.jpg" style="width:5%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=파">
		<img src="/step12_miniproject/ingredient/images/greenOnion.jpg" style="width:5%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=깨">
		<img src="/step12_miniproject/ingredient/images/sesame.jpg" style="width:5%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=간장">
		<img src="/step12_miniproject/ingredient/images/soy.jpg" style="width:5%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=참기름">
		<img src="/step12_miniproject/ingredient/images/sesameOil.jpg" style="width:5%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=크림">
		<img src="/step12_miniproject/ingredient/images/cream.jpg" style="width:5%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=토마토소스">
		<img src="/step12_miniproject/ingredient/images/tomatoSauce.jpg" style="width:5%">
				</a>
<p>			
		<form action="/step12_miniproject/recipe">
			<button type="submit" name="command" value="clearIngredient">초기화</button> 
		</form>   
<p>
		선택한 재료 : ${Cookies} 
		
	</div>
		




  
  </div>
  
  
  
  
  <!-- Modal for full size images on click-->
  <div id="modal01" class="w3-modal w3-black" style="padding-top:0" onclick="this.style.display='none'">
    <span class="w3-button w3-black w3-xlarge w3-display-topright">&times;</span>
    <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
      <img id="img01" class="w3-image">
      <p id="caption"></p>
    </div>
  </div>
  

  
  <!-- Footer -->
  <footer class="w3-container w3-padding-32 w3-dark-grey">  
    <jsp:include page="../layout/footer.jsp" />
  </footer>
  
<!-- End page content -->

<script>
// Script to open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}
// Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}
</script>
</body>
</html>