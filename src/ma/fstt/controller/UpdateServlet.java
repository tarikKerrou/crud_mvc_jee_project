package ma.fstt.controller;

import java.io.IOException;
import java.sql.Date;
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
import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneDeCommande;
import ma.fstt.entities.Produit;
import ma.fstt.entities.Utilisateur;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject private CommandeDao commandeDao;
	@Inject private ProduitDao produitDao;
	@Inject private UtilisateurDao utilisateurDao;
	@Inject private LigneDeCommandeDao ligneCommandeDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() throws ClassNotFoundException, SQLException {
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
			Utilisateur user = (Utilisateur) session.getAttribute("user");
			
			// --- Modification d'une commande ---
			if(action == "cmd")
			{
				int id  = Integer.parseInt(request.getParameter("id"));
				String dateCmd = request.getParameter("dateCmd");
				
				int idUser = commandeDao.getById(id).getIdUtil();
				Commande commande = new Commande(id, Date.valueOf(dateCmd), idUser);
				
				commandeDao.update(commande);
				this.getServletContext().getRequestDispatcher("/ShowListServlet?act=1").forward(request, response);
			}
			// --- Modification d'un produit ---
			else if(action == "prod")
			{
				int id  = Integer.parseInt(request.getParameter("id"));
				String nomProd = request.getParameter("nomProd");
				double prixProd = Double.parseDouble(request.getParameter("prixProd"));
				Produit produit = new Produit(id, nomProd, prixProd);
				
				produitDao.update(produit);
				this.getServletContext().getRequestDispatcher("/ShowListServlet?act=2").forward(request, response);
			}
			// --- Modification d'un utilisateur ---
			else if(action == "util")
			{
				int id  = Integer.parseInt(request.getParameter("id"));
				String nomUtil = request.getParameter("nomUtil");
				String passwordUtil = request.getParameter("passwordUtil");
				String adresseUtil = request.getParameter("adresseUtil");
				String emailUtil = request.getParameter("emailUtil");
				int typeUtil = user.getTypeUtil();
				Utilisateur utilisateur = new Utilisateur(id, nomUtil, passwordUtil, adresseUtil, emailUtil, typeUtil);
				
				utilisateurDao.update(utilisateur);
				session.setAttribute("user", utilisateur);
				this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);		
			}
			// --- Modification d'une ligne de commande ---
			else if(action == "lcmd")
			{
				int id  = Integer.parseInt(request.getParameter("id"));
				LigneDeCommande lcmd = ligneCommandeDao.getById(id);
				int idCmd = lcmd.getIdCmd();
				int idProd = Integer.parseInt(request.getParameter("idProd"));
				int qte = Integer.parseInt(request.getParameter("qte"));
				LigneDeCommande ligneDeCommande = new LigneDeCommande(id, qte, idCmd, idProd);
				
				ligneCommandeDao.update(ligneDeCommande);
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
