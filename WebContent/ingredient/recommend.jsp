<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택한 재료에 따라 레시피 출력</title>
</head>
<body>
</body>
<bottom>

		<c:forEach items="${requestScope.recommend}" var="recommend">
				
				${recommend}
				
		</c:forEach>
	
	</div>


	
	<jsp:include page="select.jsp" /> 
</bottom>

<footer> 
	
</footer>

</html>