package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import exception.NotExistException;
import model.dto.IngredientDTO;
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
	public ArrayList<RecipeDTO> getAllRecipe() throws NotExistException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		List<Recipe> list = null;
		ArrayList<RecipeDTO> result = new ArrayList<>();
		ArrayList<Integer> Likes = new ArrayList<>();
		ArrayList<RecipeDTO> resultSorted = new ArrayList<>();
		
		try {
			list = (List<Recipe>) em.createNativeQuery("select * from Recipe", Recipe.class).getResultList();
			list.forEach(v -> result.add(new RecipeDTO(v.getRecipeId(), v.getIngredientId().getIngredientId(),v.getFoodName(), 
													   v.getDirection(), v.getRecipeOwner().getChefId(), v.getLike(), v.getImgPath())));

			for (RecipeDTO r : result) {
				Likes.add(r.getLike());
			}
			Likes.sort(Comparator.reverseOrder());

			for (int i : Likes) {
				for (int r = 0; r < result.size(); r++) {
					if (result.get(r).getLike() == i) {
						resultSorted.add(result.get(r));
						result.remove(result.get(r));
						break;
					}
				}
			}
		} catch (NoResultException e) {
			e.printStackTrace();
			throw new NotExistException();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			em = null;
		}
		return resultSorted;
	}

	// 내가 등록한 레시피 모두 조회
	public Object getMyRecipe(String nickname) throws NotExistException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		List<Recipe> list = null;
		ArrayList<RecipeDTO> result = new ArrayList<>();
		
		try {
			Chef chef = (Chef) em.createNamedQuery("Chef.findChef").setParameter("chefName", nickname).getSingleResult();
			list = (List<Recipe>) em.createNamedQuery("Recipe.findByRecipeOwner").setParameter("recipeOwner", chef).getResultList();
			list.forEach(v -> result.add(new RecipeDTO(v.getRecipeId(), v.getIngredientId().getIngredientId(),v.getFoodName(), 
													   v.getDirection(), v.getRecipeOwner().getChefId(), v.getLike(), v.getImgPath())));
		} catch (NoResultException e) {
			e.printStackTrace();
			throw new NotExistException();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			em = null;
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
			recipe = new RecipeDTO(r.getRecipeId(), r.getIngredientId().getIngredientId(), r.getFoodName(),
								   r.getDirection(), r.getRecipeOwner().getChefId(), r.getLike(), r.getImgPath());
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			em = null;
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
			r = (Recipe) em.createNamedQuery("Recipe.findByFoodName").setParameter("foodName", foodname).getSingleResult();
			result = new RecipeDTO(r.getRecipeId(), r.getIngredientId().getIngredientId(), r.getFoodName(),
								   r.getDirection(), r.getRecipeOwner().getChefId(), r.getLike(), r.getImgPath());
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			em = null;
		}
		return result;
	}

	// 레시피 좋아요 누르기
	public boolean updateLike(int recipeId) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		
		try {
			Recipe r = em.find(Recipe.class, recipeId);
			r.setLike(r.getLike() + 1);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			em = null;
		}
		return result;
	}

	// 레시피 등록
	public boolean addRecipe(RecipeDTO recipe, String nickname) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		
		try {
			Ingredient i = em.find(Ingredient.class, recipe.getIngredientId());
			Chef c = (Chef) em.createNamedQuery("Chef.findChef").setParameter("chefName", nickname).getSingleResult();
			Recipe r = new Recipe(i, recipe.getFoodName(), recipe.getDirection(), c);
			
			em.persist(r);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return result;
	}

	// 레시피 수정
	public boolean updateRecipe(int recipeId, String foodName, String direction, IngredientDTO ingredient) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		
		try {
			Recipe r = em.find(Recipe.class, recipeId); // 수정할 레시피 가져오기
			Ingredient i = r.getIngredientId(); // 수정할 레시피의 재료 가져오기
			i.setIngredient1(ingredient.getIngredient1());
			i.setIngredient1(ingredient.getIngredient2());
			i.setIngredient1(ingredient.getIngredient3());
			i.setIngredient1(ingredient.getIngredient4());
			i.setIngredient1(ingredient.getIngredient5());
			r.setFoodName(foodName);
			r.setIngredientId(i);
			r.setDirection(direction);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return result;
	}

}
