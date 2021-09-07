package test;

import java.util.List;

import controller.Controller;
import model.entity.Ingredient;

public class Test {

	public static void showAllList(){
		List<Ingredient> list = Controller.getInstance().getAllIngredients();
		
//		System.out.println(list.get(0));
//		System.out.println(list.get(0).getIngredientId());
		
//		list.get(0).getIngredientId();
		
//		for(Ingredient ing : list){
//			System.out.println(ing);
//		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		showAllList();
		
		
	}
}
