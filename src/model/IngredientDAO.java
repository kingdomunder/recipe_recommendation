package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import model.dto.IngredientDTO;
import model.dto.RecipeDTO;
import model.entity.Ingredient;
import model.entity.Recipe;
import model.util.DBUtil;

public class IngredientDAO {
	private static IngredientDAO instance = new IngredientDAO();

	public IngredientDAO(){}
	
	public static IngredientDAO getInstance(){
		return instance;
	}

	
	//모든 조리법 검색
	public ArrayList<IngredientDTO> getAllIngredient() throws SQLException{
		EntityManager em = DBUtil.getEntityManager();
		ArrayList<IngredientDTO> ingredient = new ArrayList<>();
		
		try {
			ingredient = (ArrayList<IngredientDTO>)em.createNativeQuery("select * from Ingredient", Ingredient.class).getResultList();
			
		}finally {
			em.close();
			em = null;
		}
		return ingredient;
	}

	//선택한 재료 레시피 추천 - 우송  (파라미터로 받은 재료 selected가 0개 ~ 5개일때)
	public ArrayList<String> selectIngredient(ArrayList<String> selected) {
		EntityManager em = DBUtil.getEntityManager();
		
		//DB검색해서 엔티티를 담을 리스트
		List<Ingredient> ingEntity = null;
		//엔티티 리스트의 원소들인 엔티티들을 돌면서 데이터를 담을 리스트
		ArrayList<Object> list = new ArrayList();
		//데이터 담은 리스트를 담을 리스트(2차원)
		ArrayList<List> ingList = new ArrayList<>();
		
		//검색한 ingredient의 id들을 저장하는 리스트
		ArrayList<Integer> selectList = new ArrayList<>();

		//해당 ingredient의 id로 recipe 검색 (recipe에서 요리이름 반환하기 위해)
		List<Recipe> recipe = null;
		ArrayList<RecipeDTO> recipeDTOList = new ArrayList<>();
		
		//반환받은 요리 이름들을 저장하는 리스트
		ArrayList<String> recommend = new ArrayList<>();
		
		try {
			//검색할 ingredient들을 DB에서 전부 가져와 객체리스트화
			ingEntity = (List<Ingredient>)em.createNativeQuery("select * from Ingredient", Ingredient.class).getResultList();
			//객체리스트를 데이터리스트화
			for(Ingredient ing : ingEntity) {
				list.add(ing.getIngredientId());
				list.add(ing.getIngredient1());
				list.add(ing.getIngredient2());
				list.add(ing.getIngredient3());
				list.add(ing.getIngredient4());
				list.add(ing.getIngredient5());
				ingList.add(list);
				list = new ArrayList();
			}
			System.out.println("---DB에서 가져온 비교할 리스트----"+ingList);

			//입력받은 재료가 들어있는지 데이터값들을 확인한 후, id를 저장 
			for(List list1 : ingList) {
				if(list1.containsAll(selected)){
					selectList.add((Integer)list1.get(0));
				}
			}
			System.out.println("---선택한 재료가 들어있는 리스트----"+selectList);
			
			//검색할 recipe들을 DB에서 전부 가져와 리스트화
			recipe = (List<Recipe>)em.createNativeQuery("select * from Recipe", Recipe.class).getResultList();
			recipe.forEach(v -> recipeDTOList.add(new RecipeDTO(v.getRecipeId(), v.getIngredientId().getIngredientId(), v.getFoodName(), v.getDirection(), v.getRecipeOwner().getChefId(), v.getLike(), v.getImgPath())));
			//가져온 recipe리스트와 ingredient id리스트를 비교하면서, id가 포함되어 있으면 해당 recipe의 foodName을 리스트에 저장 
		
			for(RecipeDTO r : recipeDTOList) {
				if(selectList.contains(r.getRecipeId())){
					recommend.add(r.getFoodName());
				}
			}
			
		}finally {
			em.close();
			em = null;
		}
		return recommend;
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

	// 음식 이름으로 해당 음식의 재료 가져오기
	public ArrayList<String> getIngredientByFoodName(String foodName) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		Recipe r = null;
		ArrayList<String> ingredients = new ArrayList<>();
		try {
			r = (Recipe)em.createNamedQuery("Recipe.findByFoodName").setParameter("foodName", foodName).getSingleResult();
			ingredients.add(r.getIngredientId().getIngredient1());
			ingredients.add(r.getIngredientId().getIngredient2());
			ingredients.add(r.getIngredientId().getIngredient3());
			ingredients.add(r.getIngredientId().getIngredient4());
			ingredients.add(r.getIngredientId().getIngredient5());
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return ingredients;
	}

}