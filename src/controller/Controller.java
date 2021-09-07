package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.NotExistException;
import model.DTO.ChefDTO;
import model.entity.Ingredient;
import service.Service;

@WebServlet("/recipe")
public class Controller extends HttpServlet {
	private static Controller instance = new Controller();
	private static Service service = Service.getInstance();

	public Controller() {
	}

	public static Controller getInstance() {
		return instance;
	}

	// 모든 조리법 검색
	public List<Ingredient> getAllIngredients() {
		List<Ingredient> list = null;
		try {
			list = service.getAllIngredients();
		} catch (Exception e) {
		}
//		System.out.println(list.get(0).getIngredientId());

		return list;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");

		try {
			if (command.equals("recipeAll")) {
				getAllRecipe(request, response);
			} else if (command.equals("makeRecipe")) {
				getRecipeRecommendation(request, response);
			} else if (command.equals("addChef")) {
				addChef(request, response);
			} else if (command.equals("login")) {
				logInChef(request, response);
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}

	}

	// 紐⑤뱺 �젅�떆�뵾 蹂닿린
	private void getAllRecipe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("recipeAll", service.getAllRecipe());
			url = "recipeAll.jsp";
		} catch (NotExistException e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void getRecipeRecommendation(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void addChef(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		boolean result = false;

		ChefDTO chef = new ChefDTO();
		chef.setChefName(request.getParameter("nickname"));
		chef.setPassword(request.getParameter("password"));
		chef.setPassword2(request.getParameter("password2"));
		System.out.println(chef.getChefName());
		System.out.println(chef.getPassword());

		try {
			result = service.addChef(chef);

			if (result) {
				request.setAttribute("chef", chef);
				url = "chefAddSuccess.jsp";
			} else {
				request.setAttribute("errorMsg", "회원가입 실패");
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void logInChef(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		int result = service.logInChef(nickname, password);
		
		if(result == 0) {
			request.setAttribute("errorMsg", "비밀번호 불일치");
		} else if(result == 1) {
			url = "logInSuccess.jsp";
		} else if(result == -1) {
			request.setAttribute("errorMsg", "존재하지 않는 닉네임입니다.");
		} else {
			request.setAttribute("errorMsg", "로그인 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
