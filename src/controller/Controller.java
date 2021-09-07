package controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.NotExistException;
import service.Service;

@WebServlet("/recipe")  
public class Controller extends HttpServlet {
	private static Controller instance = new Controller();
	private static Service service = Service.getInstance();
	
	public Controller(){}
	
	public static Controller getInstance(){
		return instance;
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		
		try{
			if(command.equals("recipeAll")){
				getAllRecipe(request, response);
			}
			
			//우송 
			 else if(command.equals("indgredientAll")){
				instance.getAllIngredient(request, response);
			}else if(command.equals("selectIngredient")){
				instance.selectIngredient(request, response);
			}else if(command.equals("clearIngredient")){
				instance.clearIngredient(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	


	// 紐⑤뱺 �젅�떆�뵾 蹂닿린
	private void getAllRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("recipeAll", service.getAllRecipe());
			url = "recipeAll.jsp";
		}catch(NotExistException e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//모든 재료 검색 - 우송
	private void getAllIngredient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("IngredientAll", service.getAllIngredient());
			url = "IngredientAll.jsp";
		}catch(NotExistException e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}catch(SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	

	
	//선택한 재료 레시피 추천 - 우송
	private void selectIngredient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String selected = request.getParameter("ingredient");
		
		//클라이언트 로컬에 저장된 쿠키 받아오기
		Cookie[] cookies = request.getCookies();
		//저장된 쿠키가 없어서 null인 경우가 아니고, 쿠키가 7개 미만이면 입력받은 ingredient를 쿠키에 추가 (JSESSINOID 쿠키는 기본으로 하나가 생성됨)
		if(cookies != null && cookies.length < 7 ) {
			Cookie cookie = new Cookie(URLEncoder.encode(selected, "UTF-8"), URLEncoder.encode(selected, "UTF-8"));
		//추가한 쿠키를 응답에 add	
			response.addCookie(cookie);
			cookie.setMaxAge(30);
		//추가한 쿠키가 7개 이상이면 메소드 종료, 에러 페이지로 이동 
		}else {
			request.setAttribute("selectError", "최대 5개까지 선택할 수 있습니다. 초기화해주세요");
			request.getRequestDispatcher("ingredient/selectError.jsp").forward(request, response);
		}
		//쿠키의 value를 담을 리스트 생성
		ArrayList length = new ArrayList<>();
		for(Cookie value : cookies) {
			length.add(value);
		}
		 
		//추천 레시피를 담을 리스트 생성
		ArrayList<String> recommend = new ArrayList<>();
		try {
			recommend.addAll(service.selectIngredient(selected));
			if(recommend != null && recommend.size() != 0) {
				request.setAttribute("recommend", recommend);
				url = "ingredient/recommend.jsp";
			}else {
				request.setAttribute("selectError", "추천할 레시피가 없습니다");
			}
		}catch(NotExistException e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}catch(SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	
	//선택한 재료 초기화 - 쿠키 초기화 
	private void clearIngredient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ingredient/select.jsp";
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(URLEncoder.encode(cookie.getName(), "UTF-8") != "JSESSIONID") {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
		
	
	
}
