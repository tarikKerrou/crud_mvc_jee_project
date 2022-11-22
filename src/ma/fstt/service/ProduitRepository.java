package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Produit;

public interface ProduitRepository {
	public void save(Produit produit) throws SQLException;
	public void update(Produit produit) throws SQLException;
	public void delete(int id) throws SQLException;
	public List<Produit> List() throws SQLException;
	public Produit getById(int id) throws SQLException;
}
