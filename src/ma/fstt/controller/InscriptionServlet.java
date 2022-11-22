package ma.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.UtilisateurDao;
import ma.fstt.entities.Utilisateur;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject private UtilisateurDao utilisateurDao;
       
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() throws ClassNotFoundException, SQLException {
        super();
        utilisateurDao = new UtilisateurDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = null;
		
		try {
			String nom = (String) request.getParameter("nom");
			String email = (String) request.getParameter("email");
			String adresse = (String) request.getParameter("adresse");
			String password = (String) request.getParameter("password");
			
			Utilisateur user = new Utilisateur(0, nom, password, adresse, email, 2);
			request.setAttribute("user", user);
			
			utilisateurDao.save(user);
		} catch (SQLException e) {
			e.printStackTrace();
			error = "Cet e-mail est déjà utilisé !";
			request.setAttribute("error", error);
		}
		// --- Si tout est correct ---
		if(error == null)
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		// --- Si l'email est déjà utilisé (unique dans la BDD) ---
		else
			this.getServletContext().getRequestDispatcher("/createAccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
