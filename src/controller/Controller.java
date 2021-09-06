package controller;

import java.util.List;

import model.entity.Ingredient;
import service.Service;

public class Controller {
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
	
	
	
	
	
	
}
