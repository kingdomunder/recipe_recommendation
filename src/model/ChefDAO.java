package model;

public class ChefDAO {
	private static ChefDAO instance = new ChefDAO();

	public ChefDAO(){}
	
	public static ChefDAO getInstance(){
		return instance;
	}
}
