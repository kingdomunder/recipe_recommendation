<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="images/egg.ico">
	<title>방구석 CHEF</title>
</head>
<html>
<head>
<meta charset="UTF-8">
<title>에러</title>
</head>
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
	
	${errorMsg}
	
	<!-- Footer -->
  <footer class="footer-container w3-padding-10 w3-grey" style="font-family:'Nanum Gothic';"> 
    <jsp:include page="layout/footer.jsp" />
  </footer>
</body>
</html>