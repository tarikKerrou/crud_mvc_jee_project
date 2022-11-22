package ma.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.fstt.dao.UtilisateurDao;
import ma.fstt.entities.Utilisateur;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/AuthentificationServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject private UtilisateurDao utilisateurDao;

	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthentificationServlet() throws ClassNotFoundException, SQLException {
		super();
		utilisateurDao = new UtilisateurDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = null;
		String errorVide = null;
		HttpSession session = request.getSession();
		
		// --- LogOut ---
		if(request.getParameter("act") != null)
		{
			int action  = Integer.parseInt(request.getParameter("act"));
			if(action == 0)
			{
				session.removeAttribute("user");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		}
		
		// --- LogIn ---
		try {
			Utilisateur user = new Utilisateur();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
	
			user = utilisateurDao.getByEmail(email);
			request.setAttribute("user", user);
			
			session.setAttribute("user", user);
			
			if(user != null)
			{
				// --- Si tout est correct ---
				if(password.equals(user.getPasswordUtil()))
					this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
				// --- Si le mot de passe est incorrect ---
				else
				{
					error = "Le mot de passe est incorrect !";
					request.setAttribute("error", error);
					this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
			}
			// --- Si l'email est incorrect (n'existe pas dans la BDD) ---
			else
			{
				errorVide = "E-mail incorrect";
				request.setAttribute("errorVide", errorVide);
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
