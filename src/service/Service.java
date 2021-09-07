package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import exception.NotExistException;
import model.ChefDAO;
import model.IngredientDAO;
import model.RecipeDAO;
import model.DTO.IngredientDTO;
import model.DTO.RecipeDTO;

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
	

	// 모든 레시피 조회
	public ArrayList<RecipeDTO> getAllRecipe() throws NotExistException {
		return getRecipeDAO.getAllRecipe();
	}
	
	
	//모든 조리법 검색 - 우송
	public ArrayList<IngredientDTO> getAllIngredient() throws  NotExistException, SQLException {
		return getIngredientDAO.getAllIngredient();
	}
	
	//선택한 재료 레시피 추천 - 우송
	public ArrayList<String> selectIngredient(String IngredientOne) throws NotExistException, SQLException {
		ArrayList<String> recommend = new ArrayList<>();
		recommend = getIngredientDAO.selectIngredient(IngredientOne);
		return recommend;
	}
	
}
