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

import ma.fstt.dao.CommandeDao;
import ma.fstt.dao.LigneDeCommandeDao;
import ma.fstt.dao.ProduitDao;
import ma.fstt.dao.UtilisateurDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject private CommandeDao commandeDao;
	@Inject private ProduitDao produitDao;
	@Inject private UtilisateurDao utilisateurDao;
	@Inject private LigneDeCommandeDao ligneCommandeDao;
       
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() throws ClassNotFoundException, SQLException {
        super();
        commandeDao = new CommandeDao();
        produitDao = new ProduitDao();
        utilisateurDao = new UtilisateurDao();
        ligneCommandeDao = new LigneDeCommandeDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String action = (String) session.getAttribute("page");
			
			int id  = Integer.parseInt(request.getParameter("id")); // Id de l'élément à supprimer
			
			// --- Suppression d'une commande ---
			if(action == "cmd")
			{
				commandeDao.delete(id);
				this.getServletContext().getRequestDispatcher("/ShowListServlet?act=1").forward(request, response);
			}
			// --- Suppression d'un produit ---
			else if(action == "prod")
			{
				produitDao.delete(id);
				this.getServletContext().getRequestDispatcher("/ShowListServlet?act=2").forward(request, response);
			}
			// --- Suppression d'un utilisateur ---
			else if(action == "util")
			{
				utilisateurDao.delete(id);
				this.getServletContext().getRequestDispatcher("/ShowListServlet?act=3").forward(request, response);
			}
			// --- Suppression d'une ligne de commande ---
			else if(action == "lcmd")
			{
				int idCmd = (Integer) session.getAttribute("idCmd");
				ligneCommandeDao.delete(id);
				this.getServletContext().getRequestDispatcher("/ShowListServlet?act=4&id="+idCmd+"").forward(request, response);
			}
			
		}  catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
