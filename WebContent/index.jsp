<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="images/egg.ico">
	<title>방구석 CHEF</title>
</head>
<html lang="en">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", 'Nanum Gothic'}
.w3-third img{margin-bottom: -6px; opacity: 0.8; cursor: pointer; background-color: grey}
.w3-third img:hover{opacity: 0.7}
</style>
<body class="body-yellow w3-content">


<!-- 네비게이션 -->
<nav class="w3-sidebar w3-bar-block w3-animate-left w3-text-white w3-collapse w3-top w3-center" style="z-index:3; width:300px; font-weight:bold" id="mySidebar"><br>
	<jsp:include page="layout/nav.jsp" />
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-xlarge w3-padding-20" style="background-color: #FF712C; color: white; font-weight: bolder;">
  <span class="w3-left w3-padding-16">방구석 Chef</span>
  <a href="javascript:void(0)" class="w3-right w3-button w3-white w3-padding-16" style="padding-top: 20px" onclick="w3_open()">&#9776;</a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px">

  <!-- Push down content on small screens --> 
  <div class="w3-hide-large" style="margin-top:83px"></div>
  
  <!-- Photo grid -->
  <div class="w3-row">
    <div class="w3-third">
      <img src="images/index/001.jpg" style="width:100%" onclick="onClick(this)" alt="'대한민국 법조계에 김앤장이 있다면, 플레이데이터에는 혜민장이 있다.' - W.S.Lim, - PD Porject 中 -">
      <div style="height:100px; width:100%; background-color:#333333; color:white; font-weight:500; text-align:center; padding-top:30px;"><h4>EVERYONE</h4></div>
      <img src="images/index/002.jpg" style="width:100%" onclick="onClick(this)" alt="- 10%의 확신과, 90%의 이게 왜 돌아가지? -">
    </div>
    
    <div class="w3-third">
      <img src="images/index/003.jpg" style="width:100%" onclick="onClick(this)" alt="'벌써 자면 어떡해... 일어나, 코딩해야지'">
      <div style="height:100px; width:100%; background-color:#333333; color:white; font-weight:500; text-align:center; padding-top:30px;"><h4>CAN BE</h4></div>
      <img src="images/index/004.jpg" style="width:100%" onclick="onClick(this)" alt="'저쪽 집이 무너졌다고 해서 구경하러 갔죠. 그런데 보고 오니 우리집이 무너진거에요.'">
    </div>
   
    <div class="w3-third">
      <img src="images/index/005.jpg" style="width:100%" onclick="onClick(this)" alt="- 1번, 2번 메소드를 만들고 테스트하면 3번 메소드가 실행된다. -">
     <div style="height:100px; width:100%; background-color:#333333; color:white; font-weight:500; text-align:center; padding-top:30px;"><h4>A CHEF</h4></div>
      <img src="images/index/006.jpg" style="width:100%" onclick="onClick(this)" alt="- 모든 에러를 잡아도 사용자는 기상천외한 문제를 발생시킨다. -">
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
  <footer class="footer-container w3-padding-10" style="font-family:'Nanum Gothic';"> 
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