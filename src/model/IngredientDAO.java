package model;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import model.DTO.IngredientDTO;
import model.DTO.RecipeDTO;
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

	// 레시피 등록시 - 새로운 재료 등록
	public int addIngredient(IngredientDTO ingredient) { // (사용자가 id는 입력 안했기때문에 id는 0)
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		int ingredientId = 0;
		
		try {
			em.persist(ingredient.toEntity()); 
			em.getTransaction().commit();	 
			// 새로 생성된 시퀀스값(id) 반환
			ingredientId = Integer.parseInt(String.valueOf(em.createNativeQuery("select ingredient_id_seq.currval from dual").getSingleResult()));
			System.out.println(ingredientId);
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return ingredientId;
	}













}
