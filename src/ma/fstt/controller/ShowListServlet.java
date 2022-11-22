package ma.fstt.controller;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
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
 * Servlet implementation class ShowListServlet
 */
@WebServlet("/ShowListServlet")
public class ShowListServlet extends HttpServlet {
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
    public ShowListServlet() throws ClassNotFoundException, SQLException {
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
			//String action = request.getParameter("act");//(String) session.getAttribute("page");
			int action  = Integer.parseInt(request.getParameter("act"));
			Utilisateur user = (Utilisateur) session.getAttribute("user");
			
			List<Commande> listCmd = new ArrayList<Commande>();
			List<Produit> listProd = new ArrayList<Produit>();
			List<Utilisateur> listUtil = new ArrayList<Utilisateur>();
			List<LigneDeCommande> listLigCmd = new ArrayList<LigneDeCommande>();
			
			// --- 1 : Commandes ---
			if(action == 1)
			{
				if(user.getTypeUtil() == 1)
				{
					listCmd = commandeDao.List();
					request.setAttribute("listCmd", listCmd);
					this.getServletContext().getRequestDispatcher("/showCommandes.jsp").forward(request, response);
				}
				else
				{
					listCmd = commandeDao.getByIdUser(user.getIdUtil());
					request.setAttribute("listCmd", listCmd);
					this.getServletContext().getRequestDispatcher("/showCommandes.jsp").forward(request, response);
				}
			}
			// --- 11 : Commande à modifier ---
			else if(action == 11)
			{
				int id  = Integer.parseInt(request.getParameter("id"));
				Commande cmdToUpdate = commandeDao.getById(id);
				session.setAttribute("cmdToUpdate", cmdToUpdate);
				
				this.getServletContext().getRequestDispatcher("/updateCommande.jsp").forward(request, response);
			}
			// --- 2 : Produits ---
			else if(action == 2)
			{
				listProd = produitDao.List();
				request.setAttribute("listProd", listProd);
				
//				Image img = produitDao.getImage();
//				ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		        ImageIO.write((RenderedImage) img, "jpg", bos );
//		        byte [] data = bos.toByteArray();
//		        String base64Image = Base64.getEncoder().encodeToString(data);
//		        request.setAttribute("img", base64Image);
				
				this.getServletContext().getRequestDispatcher("/showProduits.jsp").forward(request, response);
			}
			// --- 22 : Produit à modifier ---
			else if(action == 22)
			{
				int id  = Integer.parseInt(request.getParameter("id"));
				Produit prodToUpdate = produitDao.getById(id);
				session.setAttribute("prodToUpdate", prodToUpdate);
				
				this.getServletContext().getRequestDispatcher("/updateProduit.jsp").forward(request, response);
			}
			// --- 3 : Utilisateurs ---
			else if(action == 3)
			{
				listUtil = utilisateurDao.List();
				request.setAttribute("listUtil", listUtil);
				this.getServletContext().getRequestDispatcher("/showClients.jsp").forward(request, response);
			}
			// --- 4 : Lignes de commande ---
			else if(action == 4)
			{
				int id  = Integer.parseInt(request.getParameter("id"));
				session.setAttribute("idCmd", id);
				
				listLigCmd = ligneCommandeDao.getByIdCmd(id);
				request.setAttribute("listLigCmd", listLigCmd);
				
				
				this.getServletContext().getRequestDispatcher("/showLignesCommande.jsp").forward(request, response);
			}
			// --- 44 : Ligne de commande à modifier ---
			else if(action == 44)
			{
				int id  = Integer.parseInt(request.getParameter("id"));
				LigneDeCommande lcmdToUpdate = ligneCommandeDao.getById(id);
				session.setAttribute("lcmdToUpdate", lcmdToUpdate);
				listProd = produitDao.List();
				request.setAttribute("listProd", listProd);
				
				this.getServletContext().getRequestDispatcher("/updateLigneCommande.jsp").forward(request, response);
			}
			// --- 444 : Pour afficher les produits dans la Drop Down List (Create/Update ligne de commande) ---
			else if(action == 444)
			{
				listProd = produitDao.List();
				request.setAttribute("listProd", listProd);
				this.getServletContext().getRequestDispatcher("/createLigneCommande.jsp").forward(request, response);
			}
		} catch(SQLException e) {
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
