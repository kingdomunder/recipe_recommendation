package controller;

import java.util.List;

import model.entity.Ingredient;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
	
	
	//모든 조리법 검색
	public List<Ingredient> getAllIngredients(){
		List<Ingredient> list = null;
		try {
			list = service.getAllIngredients();
		}catch (Exception e) {
		}
//		System.out.println(list.get(0).getIngredientId());
		
		return list;
	}
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		
		try{
			if(command.equals("recipeAll")){
				getAllRecipe(request, response);
			}else if(command.equals("makeRecipe")){
				getRecipeRecommendation(request, response);
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
	
	
	private void getRecipeRecommendation(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
