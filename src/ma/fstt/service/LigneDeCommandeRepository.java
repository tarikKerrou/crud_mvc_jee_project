package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.LigneDeCommande;

public interface LigneDeCommandeRepository {
	public void save(LigneDeCommande ligneDeCommande) throws SQLException;
	public void update(LigneDeCommande ligneDeCommande) throws SQLException;
	public void delete(LigneDeCommande id) throws SQLException;
	public List<LigneDeCommande> List() throws SQLException;
	public LigneDeCommande getById(int id) throws SQLException;
	public List<LigneDeCommande> getByIdCmd(int id) throws SQLException;
}
