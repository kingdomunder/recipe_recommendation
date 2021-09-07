package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.NotExistException;
import model.ChefDAO;
import model.IngredientDAO;
import model.RecipeDAO;
import model.DTO.RecipeDTO;
import model.entity.Ingredient;

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
	
	//모든 조리법 검색
	public List<Ingredient> getAllIngredients() throws SQLException{
		return getIngredientDAO.getAllIngredients();
	}
	
	// 모든 레시피 조회
	public ArrayList<RecipeDTO> getAllRecipe() throws NotExistException {
		return getRecipeDAO.getAllRecipe();
	}
	
	// 레시피에 좋아요 누르기
	public boolean likeRecipe(int recipeId) throws SQLException {
		return getRecipeDAO.updateLike(recipeId);
		
	}
	
	// 레시피 아이디로 레시피 1개 조회
	public RecipeDTO getOneRecipe(int recipeId) {
		return getRecipeDAO.getOneRecipe(recipeId);
	}
}
