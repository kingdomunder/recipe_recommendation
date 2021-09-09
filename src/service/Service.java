package service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import exception.NotExistException;
import model.ChefDAO;
import model.IngredientDAO;
import model.RecipeDAO;
import model.dto.ChefDTO;
import model.dto.IngredientDTO;
import model.dto.RecipeDTO;

public class Service {
	private static Service instance = new Service();
	
	private static ChefDAO getChefDAO = ChefDAO.getInstance();
	private static IngredientDAO getIngredientDAO = IngredientDAO.getInstance();
	private static RecipeDAO getRecipeDAO = RecipeDAO.getInstance();
	
	public Service(){
	}

	public static Service getInstance(){
		return instance;
	}
	
	// 레시피 아이디로 레시피 1개 조회
	public RecipeDTO getOneRecipe(int recipeId) {
		return getRecipeDAO.getOneRecipe(recipeId);
	}
	
	// 음식 이름으로 레시피 1개 조회
	public RecipeDTO getRecipeOne(String foodName) throws SQLException, NotExistException {
		return getRecipeDAO.getRecipeOne(foodName);
	}

	// 모든 레시피 조회
	public ArrayList<RecipeDTO> getAllRecipe() throws NotExistException {
		return getRecipeDAO.getAllRecipe();
	}
	
	// 내가 등록한 레시피만 조회
	public Object getMyRecipe(String nickname) throws NotExistException {
		return getRecipeDAO.getMyRecipe(nickname);
	}
	
	// 레시피에 좋아요 누르기
	public boolean likeRecipe(int recipeId) throws SQLException {
		return getRecipeDAO.updateLike(recipeId);
		
	}	
	
	// 레시피 등록
	public boolean addRecipe(RecipeDTO recipe, String nickname) {
		return getRecipeDAO.addRecipe(recipe, nickname);
	}
	
	// 레시피 등록시 새로운 재료 추가
	public int addIngredient(IngredientDTO ingredient) {
		return getIngredientDAO.addIngredient(ingredient);
	}
	
	// 레시피 수정
	public boolean updateRecipe(int recipeId, String foodName, String direction, IngredientDTO ingredient) {
		return getRecipeDAO.updateRecipe(recipeId, foodName, direction, ingredient);
	}
	
	// 레시피 삭제
	public boolean deleteRecipe(int recipeId) {
		return getRecipeDAO.deleteRecipe(recipeId);
	}
	
	//모든 조리법 검색 - 우송
	public ArrayList<IngredientDTO> getAllIngredient() throws  NotExistException, SQLException {
		return getIngredientDAO.getAllIngredient();
	}
	
	//선택한 재료 레시피 추천 - 우송
	public ArrayList<String> selectIngredient(ArrayList<String> selected) throws NotExistException, SQLException {
		ArrayList<String> recommend = new ArrayList<>();
		recommend = getIngredientDAO.selectIngredient(selected);
		return recommend;
	}
	
	// 셰프 추가
	public boolean addChef(ChefDTO chef) throws SQLException {
		return getChefDAO.addChef(chef);
	}
	// 로그인
	public int logInChef(String nickname, String password) {
		return getChefDAO.logInChef(nickname, password);
	}

	// 음식 이름으로 레시피 조회 후 재료 출력
	public IngredientDTO getRecipeIngredient(String foodName) {
		return getRecipeDAO.getRecipeIngredient(foodName);
	}

	// 음식 이름으로 레시피 조회 후 사용자이름 출력
	public String getChefName(String foodName) {
		return getChefDAO.getChefName(foodName);
	}
	
	// 음식 이름으로 해당음식의 재료 가져오기
	public ArrayList<String> getIngredientByFoodName(String foodName) {
		return getIngredientDAO.getIngredientByFoodName(foodName);
	}

}
