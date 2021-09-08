package model;

import java.sql.SQLException;
import java.util.ArrayList;
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

	//선택한 재료 레시피 추천 - 우송
	public ArrayList<String> selectIngredient(String ingredientOne) {
		EntityManager em = DBUtil.getEntityManager();
		
		//입력받은 재료로 ingredient 검색
		List<Ingredient> ingredient = null;
		ArrayList<IngredientDTO> ingredientDTO = new ArrayList<>();

		//검색한 ingredient의 id들을 저장하는 리스트
		ArrayList<Integer> selectList = new ArrayList<>();

		//해당 ingredient의 id로 recipe 검색 (recipe에서 요리이름 반환하기 위해)
		List<Recipe> recipe = null;
		ArrayList<RecipeDTO> recipeDTO = new ArrayList<>();
		
		//반환받은 요리 이름들을 저장하는 리스트
		ArrayList<String> recommend = new ArrayList<>();
		
		try {
			//검색할 ingredient들을 DB에서 전부 가져와 리스트화
			ingredient = (List<Ingredient>)em.createNativeQuery("select * from Ingredient", Ingredient.class).getResultList();
			ingredient.forEach(v -> ingredientDTO.add(new IngredientDTO(v.getIngredientId(), v.getIngredient1(), v.getIngredient2(), v.getIngredient3(), v.getIngredient4(), v.getIngredient5())));
			//가져온 ingredient리스트에 입력받은 재료가 들어있는지 검색 한 후, id를 저장 
			for(int i = 0 ; i < ingredientDTO.size() ; i++) {
				if(ingredientDTO.get(i).getIngredient1().equals(ingredientOne)) {
					selectList.add(ingredientDTO.get(i).getIngredientId());
				}else if(ingredientDTO.get(i).getIngredient2().equals(ingredientOne)) {
					selectList.add(ingredientDTO.get(i).getIngredientId());
				}else if(ingredientDTO.get(i).getIngredient3().equals(ingredientOne)) {
					selectList.add(ingredientDTO.get(i).getIngredientId());
				}else if(ingredientDTO.get(i).getIngredient4().equals(ingredientOne)) {
					selectList.add(ingredientDTO.get(i).getIngredientId());
				}else if(ingredientDTO.get(i).getIngredient5().equals(ingredientOne)) {
					selectList.add(ingredientDTO.get(i).getIngredientId());
				}
			}
			//검색할 recipe들을 DB에서 전부 가져와 리스트화
			recipe = (List<Recipe>)em.createNativeQuery("select * from Recipe", Recipe.class).getResultList();
			recipe.forEach(v -> recipeDTO.add(new RecipeDTO(v.getRecipeId(), v.getIngredientId().getIngredientId(), v.getFoodName(), v.getDirection(), v.getRecipeOwner().getChefId(), v.getLike())));
			//가져온 recipe리스트와 ingredient id리스트를 비교하면서, id가 포함되어 있으면 해당 recipe의 foodName을 리스트에 저장 
			for(int i = 0 ; i < recipeDTO.size() ; i++) {
				for(int j = 0 ; j < selectList.size() ; j++) {
					if(recipeDTO.get(i).getIngredientId() == selectList.get(j)){
						recommend.add(recipeDTO.get(i).getFoodName());
						break;
					}
				}
			}
			
		}finally {
			em.close();
			em = null;
		}
		System.out.println(recommend);
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

}