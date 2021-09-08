package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;

import exception.NotExistException;
import model.dto.RecipeDTO;
import model.entity.Chef;
import model.entity.Ingredient;
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
			list.forEach(v -> result.add(new RecipeDTO(v.getRecipeId(), v.getIngredientId().getIngredientId(), v.getFoodName(), v.getDirection(), v.getRecipeOwner().getChefId(), v.getLike())));
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
	
//	@Test
	void test() throws NotExistException {
		String a = "woosong";
		System.out.println(getMyRecipe(a));
	}
	
	// 내가 등록한 레시피 모두 조회
	public Object getMyRecipe(String nickname) throws NotExistException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		List<Recipe> list = null;
		ArrayList<RecipeDTO> result = new ArrayList<>();
		try {
			Chef chef = (Chef)em.createNamedQuery("Chef.findChef").setParameter("chefName", nickname).getSingleResult();
			
			list = (List<Recipe>)em.createNamedQuery("Recipe.findByRecipeOwner").setParameter("recipeOwner", chef).getResultList();
			
			System.out.println("list : -------"+list);
			System.out.println("size : -------"+list.size());
			
			list.forEach(v -> result.add(new RecipeDTO(v.getRecipeId(), v.getIngredientId().getIngredientId(), v.getFoodName(), v.getDirection(), v.getRecipeOwner().getChefId(), v.getLike())));
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
			Recipe r = em.find(Recipe.class, recipeId);
			recipe = new RecipeDTO(r.getRecipeId(), r.getIngredientId().getIngredientId(), r.getFoodName(), r.getDirection(), r.getRecipeOwner().getChefId(), r.getLike());
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
		return recipe;
	}
	
	// 음식 이름으로 레시피 1개 조회 - 유진
	public RecipeDTO getRecipeOne(String foodname) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		Recipe r = null;
		RecipeDTO result = new RecipeDTO();
		try {
			r = (Recipe)em.createNamedQuery("Recipe.findByFoodName").setParameter("foodName", foodname).getSingleResult();
			result = new RecipeDTO(r.getRecipeId(), r.getIngredientId().getIngredientId(), r.getFoodName(), r.getDirection(), r.getRecipeOwner().getChefId(), r.getLike());
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		System.out.println(result);
		return result;
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

	// 레시피 등록
	public boolean addRecipe(RecipeDTO recipe) { 
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		try {
			Ingredient i = em.find(Ingredient.class, recipe.getIngredientId());
			Chef c = em.find(Chef.class, recipe.getRecipeOwner());
			Recipe r = new Recipe(i, recipe.getFoodName(), recipe.getDirection(), c);
			em.persist(r);
			em.getTransaction().commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return result;
	}

	// 레시피 삭제
	public boolean deleteRecipe(int recipeId) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		try {
			Recipe r = em.find(Recipe.class, recipeId);
			em.remove(r);
			em.getTransaction().commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return result;
	}

}
