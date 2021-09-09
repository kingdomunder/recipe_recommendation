package model;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.persistence.EntityManager;

import model.dto.ChefDTO;
import model.dto.IngredientDTO;
import model.entity.Chef;
import model.entity.Recipe;
import model.util.DBUtil;

public class ChefDAO {

	private static ChefDAO instance = new ChefDAO();

	public ChefDAO() {
	}

	public static ChefDAO getInstance() {
		return instance;
	}

	// 회원가입시 회원 정보를 DB에 저장하는 메소드
	public boolean addChef(ChefDTO chef) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;

		Chef c = new Chef(chef.getChefName(), chef.getPassword(), chef.getPassword2());

		try {
			em.persist(c);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return result;
	}

	// 로그인 메소드
	public int logInChef(String nickname, String password) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		String pass = null;
		try {
			pass = (String) em.createNamedQuery("Chef.findByChefName").setParameter("chefName", nickname).getSingleResult();
			if (pass != null) {
				if (pass.equals(password)) {
					return 1;		// 비밀번호가 DB와 일치한 경우
				} else {
					return 0;		// 비밀번호가 DB와 일치하지 않는 경우
				}
			}else {
				return -1;			// 아이디가 없는 경우
			}
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return -2;					// 그 외의 경우
	}

	// 음식 이름으로 셰프 이름 조회
	public Object getChefName(String foodName) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		Recipe r = null;
		String chefName = null;
		try {
			r = (Recipe)em.createNamedQuery("Recipe.findByFoodName").setParameter("foodName", foodName).getSingleResult();
			chefName = (String)r.getRecipeOwner().getChefName();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return chefName;
	}

}
