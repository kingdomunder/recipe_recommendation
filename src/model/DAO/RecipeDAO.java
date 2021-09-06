package model.DAO;

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
			list = (List<Recipe>)em.createQuery("select r from Recipe r").getResultList();
			list.forEach(v -> result.add(new RecipeDTO(v.getRecipeId(), v.getIngredientId(), v.getFoodName(), v.getDirection(), v.getRecipeOwner(), v.getLike())));
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
}
