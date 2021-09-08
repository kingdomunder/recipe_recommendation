<title>선택한 재료에 따라 레시피 출력</title>
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
		<c:forEach items="${requestScope.recommend}" var="recommend">
				${recommend}
		</c:forEach>
	<jsp:include page="select.jsp" /> 
  </div>




</head>
<body>
</body>
<bottom>

	


	
</bottom>

<footer> 
	
</footer>

</html>