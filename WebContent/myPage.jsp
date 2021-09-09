<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 


<!DOCTYPE html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="images/egg.ico">
	<title>방구석 CHEF</title>
</head>
<html lang="en">
<title>마이 페이지</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
.w3-third img{margin-bottom: -6px; opacity: 0.8; cursor: pointer}
.w3-third img:hover{opacity: 1}
</style>
<body class="body-yellow w3-content">


<!-- 네비게이션 -->
<nav class="w3-sidebar w3-bar-block w3-animate-left w3-text-white w3-collapse w3-top w3-center" style="z-index:3; width:300px; font-weight:bold" id="mySidebar"><br>
	<jsp:include page="layout/nav.jsp" />
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-xlarge w3-padding-16" style="background-color: #FF712C; color: white; font-weight: bolder;">
  <span class="w3-left w3-padding">방구석 Chef</span>
  <a href="javascript:void(0)" class="w3-right w3-button w3-white" style="padding-top: 20px" onclick="w3_open()">&#9776;</a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px">

  <!-- Push down content on small screens --> 
  <div class="w3-hide-large" style="margin-top:83px"></div>
  
  <!-- 각 페이지마다 내용 바꿀 부분 !! - 마이페이지 -->
  <div class="w3-container w3-light-grey w3-padding-32 w3-padding-large">
    	<div class="w3-content" style="max-width:600px">
     		<h4 class="w3-center"><b>${nickname}님이 등록한 레시피</b></h4>
	  		<div style="height: 300px; margin-top: 30px;">
	  		<c:if test="${empty myRecipe}">
	  		 등록한 레시피가 없습니다.
	  		</c:if>
	  		<c:if test="${not empty myRecipe}">
	  		총 ${fn:length(myRecipe)}개의 레시피를 등록하셨습니다.
	  		</c:if>
	  		<br>
	  		<br>
	   		<c:forEach items="${myRecipe}" var="recipe">
			<li>
				<a href="recipe?command=recipeOne&foodName=${recipe.foodName}" class="recipe-name" style="font-size:x-large">${recipe.foodName}</a>
				<a class="recipe-like" style="padding-left:10px">좋아요 ${recipe.like}개</a>
			</li>
			</c:forEach>
	  		</div>
	  		<br>
	
	  		<button onclick="location.href='addRecipe.jsp'" class="w3-button w3-block w3-black w3-margin-bottom">레시피 등록하기:)</button>
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
  <footer class="footer-container w3-padding-10 w3-grey" style="font-family:'Nanum Gothic';"> 
    <jsp:include page="layout/footer.jsp" />
  </footer>
  
<!-- End page content -->
</div>

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