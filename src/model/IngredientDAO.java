package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.entity.Ingredient;
import model.util.DBUtil;

public class IngredientDAO {
	
	private static IngredientDAO instance = new IngredientDAO();
	public IngredientDAO(){}
	public static IngredientDAO getInstance(){
		return instance;
	}

	//모든 조리법 검색
	public List<Ingredient> getAllIngredients() throws SQLException{
		EntityManager em = DBUtil.getEntityManager();
		List<Ingredient> list = null;
		
		try {
			list = em.createNativeQuery("select * from Ingredient").getResultList();
			
			System.out.println("1----"+list);
			System.out.println("2----"+list.get(0));
			
			System.out.println(list.get(0).getIngredientId());
			list.get(0).getIngredientId();

			//			System.out.println("3----"+list.get(0).getIngredientId());
		}finally {
			em.close();
			em = null;
		}
		System.out.println("3----");
//		if(list.get(0).equals(null)) {
//			System.out.println("3----n");
//		}
		System.out.println("4----");
		return list;
	}













}
