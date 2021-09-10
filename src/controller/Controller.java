package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import exception.NotExistException;
import model.dto.ChefDTO;
import model.dto.IngredientDTO;
import model.dto.RecipeDTO;
import service.Service;

@WebServlet("/recipe")
public class Controller extends HttpServlet {
	
	private static Controller instance = new Controller();
	private static Service service = Service.getInstance();
	public Controller() {}
	public static Controller getInstance() {
		return instance;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");

		try {
			if (command.equals("recipeAll")) {
				instance.getAllRecipe(request, response);
			} else if (command.equals("recipeOne")) {
				getRecipeOne(request, response);
			} else if (command.equals("likeRecipe")) {
				instance.likeRecipe(request, response);
			} else if (command.equals("addRecipe")) {
				instance.addRecipe(request, response);
			} else if (command.equals("deleteRecipe")) {
				instance.deleteRecipe(request, response);
			} else if (command.equals("updateRecipe")) {
				instance.updateRecipe(request, response);
			} else if (command.equals("selectIngredient")) {
				instance.selectIngredient(request, response);
			} else if (command.equals("clearIngredient")) {
				instance.clearIngredient(request, response);
			} else if (command.equals("addChef")) {
				instance.addChef(request, response);
			} else if (command.equals("login")) {
				instance.logInChef(request, response);
			} else if (command.equals("logout")) {
				instance.logOutChef(request, response);
			} else if (command.equals("myRecipe")) {
				instance.getMyRecipe(request, response);
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}

	// 요청처리 성공시 alert 메시지 띄우는 함수
	private void alert(HttpServletRequest request, HttpServletResponse response, String url, String message) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('" + message + "'); location.href='" + url + "';</script>");
		writer.close();
	}

	// 레시피 하나 출력 - 유진
	private void getRecipeOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String url = "showError.jsp";
		String foodName = request.getParameter("foodName");
		
		try {
			RecipeDTO recipe = service.getRecipeOne(foodName);
			String chef = service.getChefName(foodName);
			ArrayList<String> ingredient = service.getIngredientByFoodName(foodName);
			request.setAttribute("recipeOne", recipe);
			request.setAttribute("chefName", chef);
			request.setAttribute("ingredient", ingredient);

			HttpSession recipeSession = request.getSession();

			recipeSession.setAttribute("recipeIdSession", recipe.getRecipeId());
			recipeSession.setAttribute("recipeOneSession", recipe);
			recipeSession.setAttribute("chefNameSession", chef);
			recipeSession.setAttribute("ingredientSession", ingredient);
			url = "recipeOne.jsp";
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 레시피 출력
	private void getAllRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	// 내가 등록한 레시피만 출력
	private void getMyRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String nickname = (String) request.getSession().getAttribute("nickname");
		
		try {
			request.setAttribute("myRecipe", service.getMyRecipe(nickname));
			System.out.println(service.getMyRecipe(nickname));
			url = "myPage.jsp";
		} catch (NotExistException e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 선택한 재료 레시피 추천 - 우송
	private void selectIngredient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ingredient/select.jsp";
		String selected = request.getParameter("ingredient");
		String encoding = null;

		Cookie[] cookies = request.getCookies();

		ArrayList<String> decodedCookies = new ArrayList<>();
		
		for (Cookie cookie : cookies) {
			String decode = URLDecoder.decode(cookie.getValue(), "UTF-8");
			if (decode.length() < 10) {
				decodedCookies.add(decode);
			}
		}
		
		request.setAttribute("Cookies", decodedCookies);

		if (cookies == null) {
			request.setAttribute("selectError", "---로딩중입니다. 잠시만 기다려주세요---");
			request.getRequestDispatcher(url).forward(request, response);
			return;
		} else if (cookies.length == 6) {
			request.setAttribute("selectError", "---최대 5개까지만 선택할 수 있습니다. 초기화해주세요---");
			request.getRequestDispatcher(url).forward(request, response);
			return;
		} else if (decodedCookies.contains(selected)) {
			request.setAttribute("selectError", "---이미 선택한 재료입니다---");
			request.getRequestDispatcher(url).forward(request, response);
			return;
		} else {
			decodedCookies.add(selected);
			encoding = URLEncoder.encode(selected, "UTF-8");
			Cookie cookie = new Cookie(encoding, encoding);
			cookie.setMaxAge(60);
			response.addCookie(cookie);
		}
		
		ArrayList<String> recommend = new ArrayList<>();
		
		try {
			recommend.addAll(service.selectIngredient(decodedCookies));
			
			if (recommend != null && recommend.size() != 0) {
				request.setAttribute("recommend", recommend);
			} else {
				request.setAttribute("selectError", "추천할 레시피가 없습니다");
				request.getRequestDispatcher(url).forward(request, response);
				return;
			}
		} catch (NotExistException e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 레시피에 좋아요 누르기
	private void likeRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recipeId = Integer.parseInt(request.getParameter("recipeId"));
		
		try {
			boolean result = service.likeRecipe(recipeId);
			
			if (result) {
				alert(request, response, "recipe?command=recipeAll", "좋아요 등록! :)");
			} else {
				alert(request, response, "recipe?command=recipeAll", "좋아요 등록에 실패했습니다.");
			}
		} catch (Exception e) {
			alert(request, response, "recipe?command=recipeAll", "좋아요 등록에 실패했습니다.");
			e.printStackTrace();
		}
	}

	// 레시피 등록
	private void addRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = false;

		String foodName = request.getParameter("foodName");
		String ing1 = request.getParameter("ingredient1");
		String ing2 = request.getParameter("ingredient2");
		String ing3 = request.getParameter("ingredient3");
		String ing4 = request.getParameter("ingredient4");
		String ing5 = request.getParameter("ingredient5");
		String direction = request.getParameter("direction");
		String nickname = (String) request.getSession().getAttribute("nickname");

		// 사용자가 입력한 값으로 새로운 ingredient 등록
		IngredientDTO ingredient = new IngredientDTO(ing1, ing2, ing3, ing4, ing5);

		try {
			result = service.expectFoodName(foodName);
			
			if (result == false) {
				alert(request, response, "recipe?command=myRecipe", "이미 존재하는 요리입니다.");
				return;
			}
			int ingredientId = service.addIngredient(ingredient); // 새로 등록한 ingredient의 id 반환

			// 새로 등록할 recipe DTO 생성해서 등록하기
			RecipeDTO recipe = new RecipeDTO(ingredientId, foodName, direction);
			result = service.addRecipe(recipe, nickname);

			if (result) {
				alert(request, response, "recipe?command=myRecipe", "레시피 등록에 성공했습니다.");
			} else {
				alert(request, response, "recipe?command=myRecipe", "레시피 등록에 실패했습니다.");
			}
		} catch (Exception e) {
			alert(request, response, "recipe?command=myRecipe", "레시피 등록에 실패했습니다.");
			e.printStackTrace();
		}
	}

	// 레시피 수정
	private void updateRecipe(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean result = false;

		int recipeId = (int) request.getSession().getAttribute("recipeIdSession");

		String foodName = request.getParameter("foodName");
		String direction = request.getParameter("direction");

		IngredientDTO ingredient = new IngredientDTO();
		ingredient.setIngredient1(request.getParameter("ingredient1"));
		ingredient.setIngredient1(request.getParameter("ingredient2"));
		ingredient.setIngredient1(request.getParameter("ingredient3"));
		ingredient.setIngredient1(request.getParameter("ingredient4"));
		ingredient.setIngredient1(request.getParameter("ingredient5"));

		try {
			result = service.updateRecipe(recipeId, foodName, direction, ingredient);

			if (result) {
				alert(request, response, "recipe?command=recipeOne&foodName=" + foodName, "레시피 수정에 성공했습니다.");
			} else {
				alert(request, response, "recipe?command=recipeOne&foodName=" + foodName, "레시피 수정에 실패했습니다.");
			}
		} catch (Exception e) {
			alert(request, response, "recipe?command=recipeOne&foodName=" + foodName, "레시피 수정에 실패했습니다.");
			e.printStackTrace();
		}
		HttpSession recipeSession = request.getSession();
		recipeSession.removeAttribute("recipeIdSession");
		recipeSession.removeAttribute("recipeOneSession");
		recipeSession.removeAttribute("chefNameSession");
		recipeSession.removeAttribute("ingredientSession");
	}

	// 레시피 삭제
	private void deleteRecipe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recipeId = Integer.parseInt(request.getParameter("recipeId"));
		
		try {
			boolean result = service.deleteRecipe(recipeId);
			
			if (result) {
				alert(request, response, "recipe?command=myRecipe", "레시피 삭제에 성공했습니다.");
			} else {
				alert(request, response, "recipe?command=myRecipe", "레시피 삭제에 실패했습니다.");
			}
		} catch (Exception e) {
			alert(request, response, "recipe?command=myRecipe", "레시피 삭제에 실패했습니다.");
			e.printStackTrace();
		}
	}

	// 선택한 재료 초기화 - 쿠키 초기화
	private void clearIngredient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ingredient/select.jsp";
		Cookie[] cookies = request.getCookies();
		
		if (cookies.length <= 1) {
			System.out.println("----지울 쿠키가 없습니다----");
			request.setAttribute("selectError", "---이미 초기화 되었습니다---");
		} else {
			for (Cookie cookie : cookies) {
				if ((URLDecoder.decode(cookie.getValue(), "UTF-8")).length() < 10) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
			request.setAttribute("selectError", "---재료 초기화 완료---");
			System.out.println("----쿠키 초기화 완료----");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 회원가입
	private void addChef(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = false;

		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");

		if (nickname.length() < 4) {
			alert(request, response, "chefJoin.jsp", "아이디는 4글자 이상으로 입력해주세요.");
		} else if (nickname.equals("admin")) {
			alert(request, response, "chefJoin.jsp", "사용할 수 없는 이름입니다.");
		} else if (!password.equals(password2)) {
			alert(request, response, "chefJoin.jsp", "비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
		} else {
			ChefDTO chef = new ChefDTO();
			chef.setChefName(nickname);
			chef.setPassword(password);
			chef.setPassword2(password2);
			
			try {
				result = service.addChef(chef);

				if (result) {
					alert(request, response, "login.jsp", chef.getChefName() + "님 환영합니다.");
				} else {
					alert(request, response, "chefJoin.jsp", "이미 사용중인 이름입니다.");
				}
			} catch (Exception e) {
				alert(request, response, "chefJoin.jsp", "회원가입 실패. 입력정보를 확인해주세요.");
				e.printStackTrace();
			}
		}
	}

	// 로그인
	private void logInChef(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		int result = service.logInChef(nickname, password);

		if (result == 0) {
			alert(request, response, "login.jsp", "로그인 실패! 비밀번호를 확인하세요.");
		} else if (result == 1) {
			// 로그인 성공하면 session에 사용자이름 및 id값저장
			HttpSession session = request.getSession();
			session.setAttribute("nickname", nickname);
			alert(request, response, "recipe?command=recipeAll", "로그인 성공");
		} else if (result == -1) {
			alert(request, response, "login.jsp", "로그인 실패! 아이디를 확인하세요.");
		} else {
			alert(request, response, "login.jsp", "로그인에 실패했습니다.");
		}
	}

	// 로그아웃
	private void logOutChef(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		alert(request, response, "recipe?command=recipeAll", "로그아웃 되었습니다.");
	}

}
