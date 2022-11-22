package ma.fstt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import ma.fstt.dao.CommandeDao;
import ma.fstt.dao.LigneDeCommandeDao;
import ma.fstt.dao.ProduitDao;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneDeCommande;
import ma.fstt.entities.Produit;
import ma.fstt.entities.Utilisateur;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
//@MultipartConfig
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject private CommandeDao commandeDao;
	@Inject private ProduitDao produitDao;
	@Inject private LigneDeCommandeDao ligneCommandeDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() throws ClassNotFoundException, SQLException {
        super();
        commandeDao = new CommandeDao();
        produitDao = new ProduitDao();
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
			
			// --- Création d'une commande ---
			if(request.getParameter("act") != null && Integer.parseInt(request.getParameter("act")) == 1)
			{
				java.util.Date date = new java.util.Date();
				Commande commande = new Commande(0, new Date(date.getTime()), user.getIdUtil());
				
				commandeDao.save(commande);
				this.getServletContext().getRequestDispatcher("/ShowListServlet?act=1").forward(request, response);
			}
			// --- Création d'un produit ---
			else if(action == "prod")
			{
//				Part filePart = request.getPart("file"); 
//			    InputStream fileContent = filePart.getInputStream();
//			    produitDao.saveImg(fileContent);

				String nomProd = request.getParameter("nomProd");
				double prixProd = Double.parseDouble(request.getParameter("prixProd"));
				Produit produit = new Produit(0, nomProd, prixProd);
				
				produitDao.save(produit);
				this.getServletContext().getRequestDispatcher("/ShowListServlet?act=2").forward(request, response);
			}
			// --- Création d'une ligne de commande ---
			else if(action == "lcmd")
			{
				int qte = Integer.parseInt(request.getParameter("qte"));
				int idCmd = (Integer) session.getAttribute("idCmd");
				int idProd = Integer.parseInt(request.getParameter("idProd"));
				LigneDeCommande ligneCommande = new LigneDeCommande(0, qte, idCmd, idProd);
				
				ligneCommandeDao.save(ligneCommande);
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
	
	// --- Méthode servant de découpage de l'en-tête Http et extraction du nom du fichier ---
	private static String getNameFile(Part part) 
	{
        for (String contentDisposition : part.getHeader( "content-disposition" ).split( ";" )) 
        {
            if (contentDisposition.trim().startsWith( "filename" )) 
            {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }

}
