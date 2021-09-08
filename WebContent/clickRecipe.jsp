<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.domain.Person, java.util.ArrayList, java.util.HashMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>clickRecipe</title>
</head>
<body>
	<div class="w3-row">
    <div class="w3-third">
      <img src="images/natureboy.jpg" style="width:20%" onclick="onClick(this)" alt="A boy surrounded by beautiful nature">
      <img src="/w3images/girl_mountain.jpg" style="width:20%" onclick="onClick(this)" alt="What a beautiful scenery this sunset">
      <img src="/w3images/girl.jpg" style="width:20%" onclick="onClick(this)" alt="The Beach. Me. Alone. Beautiful">
    </div>

    <div class="w3-third">
      <img src="/w3images/boy.jpg" style="width:20%" onclick="onClick(this)" alt="Quiet day at the beach. Cold, but beautiful">
      <img src="/w3images/man_bench.jpg" style="width:20%" onclick="onClick(this)" alt="Waiting for the bus in the desert">
      <img src="images/natureboy.jpg" style="width:20%" onclick="onClick(this)" alt="Nature again.. At its finest!">
    </div>
    
    <div class="w3-third">
      <img src="/w3images/girl.jpg" style="width:100%" onclick="onClick(this)" alt="Canoeing again">
      <img src="/w3images/girl_train.jpg" style="width:100%" onclick="onClick(this)" alt="A girl, and a train passing">
      <img src="/w3images/closegirl.jpg" style="width:100%" onclick="onClick(this)" alt="What a beautiful day!">
    </div>
  </div>
	
	<br><hr><br>
	
	
	<%
	String v1 = "playdata";
	request.setAttribute("v1", v1);
	
	String [] v2 = {"a1", "a2"};
	request.setAttribute("v2", v2);
	
	Person p = new Person("재석", 10);
	session.setAttribute("v3", p);
	
	Person [] v4 = {new Person("재석", 10), new Person("재석2", 10)};
	request.setAttribute("v4", v4);
	%>
	
	1. ${requestScope.v1} <br>
	2. ${requestScope.v2[0]} <br>
	3. ${sessionScope.v3.name} <br>
	4. ${requestScope.v4[1].name} <br>
	
	<%
	ArrayList<String> v5 = new ArrayList<>();
	v5.add("s1");
	v5.add("s2");
	
	ArrayList<Person> v6 = new ArrayList<>();
	v6.add(new Person("종원1", 10));
	v6.add(new Person("종원2", 10));
	
	session.setAttribute("v5", v5);
	session.setAttribute("v6", v6);
	%>
	
	5. ${v5[0]} <br>
	6. ${v6[1].name} <br>
	
	<%
	HashMap<String, String> v7 = new HashMap<>();
	v7.put("k1", "재석");
	v7.put("k2", "종원");
	request.setAttribute("v7", v7);
	%>
	
	7. ${v7.k2} <br> <br> <br>
	
	
	
	
	<%
		
	%>
	
	<div class="w3-row">
	<div class="w3-third">
      <img src="images/001.png" style="width:20%" onclick="onClick(this)" alt="김치찌개 레시피">
      <img src="images/001.png" style="width:20%" onclick="onClick(this)" alt="김치찌개 레시피">
      <img src="images/001.png" style="width:20%" onclick="onClick(this)" alt="김치찌개 레시피">
    </div>
    
	<div class="w3-third">
      <img src="images/001.png" style="width:20%" onclick="onClick(this)" alt="김치찌개 레시피">
      <img src="images/001.png" style="width:20%" onclick="onClick(this)" alt="김치찌개 레시피">
      <img src="images/001.png" style="width:20%" onclick="onClick(this)" alt="김치찌개 레시피">
    </div>
    
	<div class="w3-third">
      <img src="images/001.png" style="width:20%" onclick="onClick(this)" alt="김치찌개 레시피">
      <img src="images/001.png" style="width:20%" onclick="onClick(this)" alt="김치찌개 레시피">
      <img src="images/001.png" style="width:20%" onclick="onClick(this)" alt="김치찌개 레시피">
    </div>
    </div>
	
	<div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
      <img id="img01" class="w3-image" src="https://www.w3schools.com/w3images/natureboy.jpg">
      <p id="caption">김치찌개 레시피</p>
    </div>
	
	
	<button type="button" class="prev" onclick="prev();">이전 내용</button>

	<button type="button" class="next" onclick="next();">다음 내용</button>
</body>
</html>