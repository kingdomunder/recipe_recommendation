package service;

import java.sql.SQLException;
import java.util.List;

import model.ChefDAO;
import model.IngredientDAO;
import model.RecipeDAO;
import model.entity.Ingredient;
import java.util.ArrayList;

import exception.NotExistException;
import model.DAO.RecipeDAO;
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
	
	//모든 조리법 검색
	public List<Ingredient> getAllIngredients() throws SQLException{
		return getIngredientDAO.getAllIngredients();
	}
	// 모든 레시피 조회
	public ArrayList<RecipeDTO> getAllRecipe() throws NotExistException {
		return getRecipeDAO.getAllRecipe();
	}
}
