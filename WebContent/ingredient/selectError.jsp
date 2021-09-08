<title>재료선택하기 - 에러출력 페이지</title>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<meta charset="UTF-8">
    
<!DOCTYPE html>
<html>
<head>

  <div class="w3-container w3-dark-grey w3-center w3-text-light-grey w3-padding-32" id="about">
		${requestScope.selectError}
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