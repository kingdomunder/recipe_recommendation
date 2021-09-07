package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import exception.NotExistException;
import model.DTO.RecipeDTO;
import model.entity.Recipe;
import model.util.DBUtil;

public class RecipeDAO {
	private static RecipeDAO instance = new RecipeDAO();

	private RecipeDAO() {}

	public static RecipeDAO getInstance() {
		return instance;
	}

	// 모든 레시피 조회
	public ArrayList<RecipeDTO> getAllRecipe() throws NotExistException{
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		List<Recipe> list = null;
		ArrayList<RecipeDTO> result = new ArrayList<>();
		try {
			list = (List<Recipe>)em.createNativeQuery("select * from Recipe", Recipe.class).getResultList();
			list.forEach(v -> result.add(new RecipeDTO(v.getRecipeId(), v.getIngredientId(), v.getFoodName(), v.getDirection(), v.getRecipeOwner(), v.getLike())));
			System.out.println("hello");
		}catch(NoResultException e) {
			e.printStackTrace();
			throw new NotExistException();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return result;
	}

	// 레시피 아이디로 레시피 1개 조회
	public RecipeDTO getOneRecipe(int recipeId) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		RecipeDTO recipe = null;
		
		try {
			Recipe r = (Recipe)em.createNamedQuery("Recipe.findByRecipeId").setParameter("recipeId", recipeId).getSingleResult();
			recipe = new RecipeDTO(r.getRecipeId(), r.getIngredientId(), r.getFoodName(), r.getDirection(), r.getRecipeOwner(), r.getLike());
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		return recipe;
	}
		
	// 레시피 좋아요 누르기
	public boolean updateLike(int recipeId) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		try {
			Recipe r = em.find(Recipe.class, recipeId);
			r.setLike(r.getLike()+1);
			
			em.getTransaction().commit();
			
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return result;
	}
	
	
}
