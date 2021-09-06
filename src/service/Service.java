package service;

import java.util.ArrayList;

import exception.NotExistException;
import model.DAO.RecipeDAO;
import model.DTO.RecipeDTO;

public class Service {
	private static Service instance = new Service();
	
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
}
