<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
   <!-- <div class="w3-row"> -->
	<div style="background-color: white grey;height: 800px;text-align: center;vertical-align: middle;">
        <h3>메인 재료</h3> <br>
        	
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=밥">
			<img src="/step12_miniproject/ingredient/images/rice.jpg" style="width:10%">
		</a>    
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=파스타면">
			<img src="/step12_miniproject/ingredient/images/pastaNoodles.jpg" style="width:10%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=돼지고기">
			<img src="/step12_miniproject/ingredient/images/pig.jpg" style="width:10%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=소고기">
			<img src="/step12_miniproject/ingredient/images/cow.jpg" style="width:10%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=떡">
			<img src="/step12_miniproject/ingredient/images/riceCake.jpg" style="width:10%">
		</a>
<p>
		        <h3>부가 재료</h3> <br>
        
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=계란">
			<img src="/step12_miniproject/ingredient/images/egg.jpg" style="width:10%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=김치">
			<img src="/step12_miniproject/ingredient/images/kimchi.jpg" style="width:10%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=마늘">
			<img src="/step12_miniproject/ingredient/images/garlic.jpg" style="width:10%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=파">
			<img src="/step12_miniproject/ingredient/images/greenOnion.jpg" style="width:10%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=양파">
			<img src="/step12_miniproject/ingredient/images/onion.jpg" style="width:10%">
		</a>
<p>
		        <h3>기타 재료</h3> <br>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=간장">
			<img src="/step12_miniproject/ingredient/images/soy.jpg" style="width:10%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=참기름">
			<img src="/step12_miniproject/ingredient/images/sesameOil.jpg" style="width:10%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=깨">
			<img src="/step12_miniproject/ingredient/images/sesame.jpg" style="width:10%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=고추장">
			<img src="/step12_miniproject/ingredient/images/kochujang.jpg" style="width:10%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=크림">
			<img src="/step12_miniproject/ingredient/images/cream.jpg" style="width:10%">
		</a>
		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=토마토소스">
			<img src="/step12_miniproject/ingredient/images/tomatoSauce.jpg" style="width:10%">
		</a>
		
		
		
		
		<!-- 
		
       	  <div class="w3-display-container">
       	  
        		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=토마토소스">
					<img src="/step12_miniproject/ingredient/images/tomatoSauce.jpg" style="width:10%">
          <div class="w3-display-bottom w3-display-hover">
            <button class="w3-button w3-black">토마토 소스</button>
          </div>
				</a>
        </div>
        
            <div class="w3-col l3 s6">
      <div class="w3-container">
      
        		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=토마토소스">
					<img src="/step12_miniproject/ingredient/images/tomatoSauce.jpg" style="width:10%">
          <div class="w3-display-bottom w3-display-hover">
            <button class="w3-button w3-black">토마토 소스<i class="fa fa-shopping-cart"></i></button>
          </div>
				</a>
        
        		<a href="/step12_miniproject/recipe?command=selectIngredient&ingredient=토마토소스">
					<img src="/step12_miniproject/ingredient/images/tomatoSauce.jpg" style="width:10%">
          <div class="w3-display-bottom w3-display-hover">
            <button class="w3-button w3-black">토마토 소스<i class="fa fa-shopping-cart"></i></button>
          </div>
				</a>
          
          
        </div>
      </div>
         -->
		
<br>
<br>


<p>			
		<form action="/step12_miniproject/recipe">
			<button type="submit" name="command" value="clearIngredient">초기화</button> 
		</form>   
<p>
		<h3>선택한 재료 : ${Cookies}</h3>

    </div>




		
	
	
	<!-- 추가 중 

	
<div class="w3-row w3-grayscale">
    <div class="w3-col l3 s6">
      <div class="w3-container">
        <img src="/w3images/jeans1.jpg" style="width:100%">
        <p>Ripped Skinny Jeans<br><b>$24.99</b></p>
      </div>
      <div class="w3-container">
        <img src="/w3images/jeans2.jpg" style="width:100%">
        <p>Mega Ripped Jeans<br><b>$19.99</b></p>
      </div>
    </div>

    <div class="w3-col l3 s6">
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="/w3images/jeans2.jpg" style="width:100%">
          <span class="w3-tag w3-display-topleft">New</span>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>Mega Ripped Jeans<br><b>$19.99</b></p>
      </div>
      <div class="w3-container">
        <img src="/w3images/jeans3.jpg" style="width:100%">
        <p>Washed Skinny Jeans<br><b>$20.50</b></p>
      </div>
    </div>

    <div class="w3-col l3 s6">
      <div class="w3-container">
        <img src="/w3images/jeans3.jpg" style="width:100%">
        <p>Washed Skinny Jeans<br><b>$20.50</b></p>
      </div>
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="/w3images/jeans4.jpg" style="width:100%">
          <span class="w3-tag w3-display-topleft">Sale</span>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>Vintage Skinny Jeans<br><b class="w3-text-red">$14.99</b></p>
      </div>
    </div>

    <div class="w3-col l3 s6">
      <div class="w3-container">
        <img src="/w3images/jeans4.jpg" style="width:100%">
        <p>Vintage Skinny Jeans<br><b>$14.99</b></p>
      </div>
      <div class="w3-container">
        <img src="/w3images/jeans1.jpg" style="width:100%">
        <p>Ripped Skinny Jeans<br><b>$24.99</b></p>
      </div>
    </div>
  </div>
  
	-->
	