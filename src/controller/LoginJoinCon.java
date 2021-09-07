package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ChefDAO;
import model.DTO.ChefDTO;

@WebServlet("*.do")
public class LoginJoinCon extends HttpServlet {

	public LoginJoinCon() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		if (command.equals("/chefJoin.do")) {
			ChefDTO chef = new ChefDTO();
			chef.setChefName(request.getParameter("nickname"));
			chef.setPassword(request.getParameter("password"));
			chef.setPassword2(request.getParameter("password2"));
			System.out.println(chef.getChefName());
			System.out.println(chef.getPassword());

			if (chef.getChefName().length() > 3 && chef.getPassword().length() > 3) {
				
				if (chef.getPassword().equals(chef.getPassword2())) {
					ChefDAO chefdao = new ChefDAO();
					chefdao.addChef(chef);
					RequestDispatcher dis = request.getRequestDispatcher("index.html");
					dis.forward(request, response);
				} else {
					RequestDispatcher dis = request.getRequestDispatcher("chefJoinError.jsp");
					dis.forward(request, response);
				}
				
			} else if (command.equals("login.do")) {
				String nickname = request.getParameter("nickname");
				String password = request.getParameter("password");

				ChefDAO cdao = new ChefDAO();
				ChefDTO cdto = cdao.getLoginPro(nickname, password);

				if (cdto != null) {
					HttpSession session = request.getSession();
					session.setAttribute("nickname", cdto);
					RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
					dis.forward(request, response);
				
				} else {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('닉네임 및 비밀번호가 맞지 않습니다')");
					out.println("history.back()");
					out.println("</script>");
				}
			
			} else {
				RequestDispatcher dis = request.getRequestDispatcher("chefJoinError.jsp");
				dis.forward(request, response);
			}
		}
	}

}
