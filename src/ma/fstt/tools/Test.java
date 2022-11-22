package ma.fstt.tools;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import ma.fstt.dao.CommandeDao;
import ma.fstt.dao.LigneDeCommandeDao;
import ma.fstt.dao.ProduitDao;
import ma.fstt.dao.UtilisateurDao;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneDeCommande;
import ma.fstt.entities.Produit;
import ma.fstt.entities.Utilisateur;

public class Test {

	public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
		// --- Commande ---
		String dt = "01/01/2021";
		java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dt);
		Commande commande = new Commande(1, new Date(date.getTime()), 1);
		CommandeDao cmdDao = new CommandeDao();
		List<Commande> list = cmdDao.getByIdUser(4);
		for(Commande cmd : list) {
			System.out.println(cmd.toString());
		}
		Commande cmd = cmdDao.getById(2);
		System.out.println(cmd.toString());
		
		// --- Produit ---
		Produit produit = new Produit(2, "T-ssshirt", 149);
		ProduitDao prodDao = new ProduitDao();
		List<Produit> list = prodDao.List();
		for(Produit prod : list) {
			System.out.println(prod.toString());
		}
		Produit prod = prodDao.getById(1);
		System.out.println(prod.toString());
		
		// --- LigneDeCommande ---
		LigneDeCommande lcmd = new LigneDeCommande(2, 10, 2, 1);
		LigneDeCommandeDao lcmdDao = new LigneDeCommandeDao();
		lcmdDao.delete(lcmd);
		List<LigneDeCommande> list = lcmdDao.List();
		for(LigneDeCommande l : list) {
			System.out.println(l.toString());
		}
		LigneDeCommande ligne = lcmdDao.getById(1);
		System.out.println(ligne.toString());
		
		// --- Utilisateur ---
		Utilisateur util = new Utilisateur(0, "Balkees", "myPass", "Belle Vue", "balkees@gmail.com", 2);
		UtilisateurDao utilDao = new UtilisateurDao();
		utilDao.save(util);
	}

}
