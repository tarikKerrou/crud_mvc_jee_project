package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.LigneDeCommande;
import ma.fstt.service.LigneDeCommandeRepository;
import ma.fstt.tools.ConnectionManager;

public class LigneDeCommandeDao implements LigneDeCommandeRepository {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public LigneDeCommandeDao() throws SQLException, ClassNotFoundException {
		connection = ConnectionManager.getConnection();
	}

	@Override
	public void save(LigneDeCommande ligneDeCommande) throws SQLException {
		String qry = "insert into lignedecommande (quantite, idCmd, idProd) values (?, ?, ?)";
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setDouble(1, ligneDeCommande.getQuantite());
		this.preparedStatement.setInt(2, ligneDeCommande.getIdCmd());
		this.preparedStatement.setInt(3, ligneDeCommande.getIdProd());
		this.preparedStatement.execute();
	}

	@Override
	public void update(LigneDeCommande ligneDeCommande) throws SQLException {
		String qry = "update lignedecommande set quantite = ?, idProd = ? where idLigneCmd = ?";
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setDouble(1, ligneDeCommande.getQuantite());
		this.preparedStatement.setInt(2, ligneDeCommande.getIdProd());
		this.preparedStatement.setInt(3, ligneDeCommande.getIdLigneCmd());
		this.preparedStatement.execute();
	}

	@Override
	public void delete(LigneDeCommande id) throws SQLException {
		String qry = "delete from lignedecommande where idLigneCmd = ?";
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setInt(1, id);
		this.preparedStatement.execute();
	}

	@Override
	public java.util.List<LigneDeCommande> List() throws SQLException {
		String qry = "select * from lignedecommande";
		List<LigneDeCommande> list = new ArrayList<LigneDeCommande>();
		this.statement = this.connection.createStatement();
		this.resultSet = this.statement.executeQuery(qry);
		while(this.resultSet.next()) {
			list.add(new LigneDeCommande(this.resultSet.getInt(1), this.resultSet.getInt(2), this.resultSet.getInt(3), this.resultSet.getInt(4)));
		}
		return list;
	}

	@Override
	public LigneDeCommande getById(int id) throws SQLException {
		String qry = "select * from lignedecommande where idLigneCmd = ?";
		LigneDeCommande ligneDeCommande = null;
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setInt(1, id);
		this.resultSet = this.preparedStatement.executeQuery();
		while(this.resultSet.next()) {
			ligneDeCommande = new LigneDeCommande(this.resultSet.getInt(1), this.resultSet.getInt(2), this.resultSet.getInt(3), this.resultSet.getInt(4));
			break;
		}
		return ligneDeCommande;
	}

	@Override
	public java.util.List<LigneDeCommande> getByIdCmd(int id) throws SQLException {
		//System.out.println("I'm in getByIdCmd");
		String qry = "select * from lignedecommande where idCmd = ?";
		List<LigneDeCommande> list = new ArrayList<LigneDeCommande>();
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setInt(1, id);
		this.resultSet = this.preparedStatement.executeQuery();
		while(this.resultSet.next()) {
			list.add(new LigneDeCommande(this.resultSet.getInt(1), this.resultSet.getInt(2), this.resultSet.getInt(3), this.resultSet.getInt(4)));
		}
		//System.out.println("Ligne 1 : " + list.get(0).toString());
		return list;
	}
}
