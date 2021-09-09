<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
.w3-third img{margin-bottom: -6px; opacity: 0.8; cursor: pointer}
.w3-third img:hover{opacity: 1}
</style>
<body class="w3-light-grey w3-content" style="max-width:1600px">


<!-- 네비게이션 -->
<nav class="w3-sidebar w3-bar-block w3-white w3-animate-left w3-text-grey w3-collapse w3-top w3-center" style="z-index:3;width:300px;font-weight:bold" id="mySidebar"><br>
	<jsp:include page="layout/nav.jsp" />
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-white w3-xlarge w3-padding-16">
  <span class="w3-left w3-padding">방구석 Chef</span>
  <a href="javascript:void(0)" class="w3-right w3-button w3-white" onclick="w3_open()">&#9776;</a>
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
      <img src="images/index1.jpg" style="width:100%" onclick="onClick(this)" alt="'대한민국 법조계에 김앤장이 있다면, 플레이데이터에는 혜민장이 있다.' - W.S.Lim, - PD Porject 中 -">
      <div style="height:100px; width:100%; background-color:black; color:white; text-align:center; padding-top:40px;">Everyone</div>
      <img src="images/index2.jpg" style="width:100%" onclick="onClick(this)" alt="- 10%의 확신과, 90%의 이게 왜 돌아가지? -">
    </div>
    
    <div class="w3-third">
      <img src="images/index3.jpg" style="width:100%" onclick="onClick(this)" alt="'벌써 자면 어떡해... 일어나, 코딩해야지'">
      <div style="height:100px; width:100%; background-color:black; color:white; text-align:center; padding-top:40px;">Can Be</div>
      <img src="images/index4.jpg" style="width:100%" onclick="onClick(this)" alt="'저쪽 집이 무너졌다고 해서 구경하러 갔죠. 그런데 보고 오니 우리집이 무너진거에요.'">
    </div>
   
    <div class="w3-third">
      <img src="images/index5.jpg" style="width:100%" onclick="onClick(this)" alt="- 1번, 2번 메소드를 만들고 테스트하면 3번 메소드가 실행된다. -">
     <div style="height:100px; width:100%; background-color:black; color:white; text-align:center; padding-top:40px;">a Chef</div>
      <img src="images/index6.jpg" style="width:100%" onclick="onClick(this)" alt="- 모든 에러를 잡아도 사용자는 기상천외한 문제를 발생시킨다. -">
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
  <footer class="w3-container w3-padding-32 w3-grey">  
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