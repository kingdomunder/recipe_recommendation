package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.NotExistException;
import model.DTO.IngredientDTO;
import model.DTO.RecipeDTO;
import model.entity.Chef;
import model.entity.Ingredient;
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
			}else if(command.equals("")){
				getRecipeRecommendation(request, response);
			}else if(command.equals("likeRecipe")) {
				likeRecipe(request, response);
			}else if(command.equals("addRecipe")) {
				addRecipe(request,response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	
	}

	
	// 모든 레시피 검색
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
	
	// 레시피에 좋아요 누르기
	private void likeRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		int recipeId = Integer.parseInt(request.getParameter("recipeId"));
		try {
			boolean result = service.likeRecipe(recipeId);
			if(result) {
				request.setAttribute("recipe", service.getOneRecipe(recipeId));
				url = "recipeLikeSuccess.jsp";
			}else {
				request.setAttribute("errorMsg", "레시피 좋아요 누르기 실패했습니다.");
			}
		}catch(Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	// 레시피 등록
	private void addRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		boolean result = false;
		
		String foodName = request.getParameter("foodName");
		String ing1 = request.getParameter("ingredient1");
		String ing2 = request.getParameter("ingredient2");
		String ing3 = request.getParameter("ingredient3");
		String ing4 = request.getParameter("ingredient4");
		String ing5 = request.getParameter("ingredient5");
		String direction = request.getParameter("direction");
		int recipeOwner = 1; // 이부분은 사용자가 로그인했으면 자동으로 가져올수 있도록 수정해야함
		
		// 사용자가 입력한 값으로 새로운 ingredient 등록
		IngredientDTO ingredient = new IngredientDTO(ing1, ing2, ing3, ing4, ing5); 
		try {
			int ingredientId = service.addIngredient(ingredient); // 새로 등록한 ingredient의 id 반환
			RecipeDTO recipe = new RecipeDTO(ingredientId, foodName, direction, recipeOwner);
			result = service.addRecipe(recipe);
			
			if(result) {
				request.setAttribute("recipe", recipe);
				url = "recipeAddSuccess.jsp";
			}else {
				request.setAttribute("errorMsg", "레시피 등록 실패");
			}			
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}


}
