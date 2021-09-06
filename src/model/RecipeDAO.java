package model;

public class RecipeDAO {
	private static RecipeDAO instance = new RecipeDAO();

	public RecipeDAO(){}
	
	public static RecipeDAO getInstance(){
		return instance;
	}
}
