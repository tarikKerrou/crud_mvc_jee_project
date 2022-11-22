package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Commande;
import ma.fstt.service.CommandeRepository;
import ma.fstt.tools.ConnectionManager;

public class CommandeDao implements CommandeRepository {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public CommandeDao() throws SQLException, ClassNotFoundException {
		connection = ConnectionManager.getConnection();
	}
	
	@Override
	public void save(Commande commande) throws SQLException {
		String qry = "insert into commande (dateCmd, idUtil) values (?, ?)";
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setDate(1, commande.getDateCmd());
		this.preparedStatement.setInt(2, commande.getIdUtil());
		this.preparedStatement.execute();
	}

	@Override
	public void update(Commande commande) throws SQLException {
		String qry = "update commande set dateCmd = ? where idCmd = ?";
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setDate(1, commande.getDateCmd());
		this.preparedStatement.setInt(2, commande.getIdCmd());
		this.preparedStatement.execute();
	}

	@Override
	public void delete(int id) throws SQLException {
		String qry = "delete from commande where idCmd = ?";
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setInt(1, id);
		this.preparedStatement.execute();
	}

	@Override
	public java.util.List<Commande> List() throws SQLException {
		String qry = "select * from commande";
		List<Commande> list = new ArrayList<Commande>();
		this.statement = this.connection.createStatement();
		this.resultSet = this.statement.executeQuery(qry);
		while(this.resultSet.next()) {
			list.add(new Commande(this.resultSet.getInt(1), this.resultSet.getDate(2), this.resultSet.getInt(3)));
		}
		return list;
	}

	@Override
	public Commande getById(int id) throws SQLException {
		String qry = "select * from commande where idCmd = ?";
		Commande commande = null;
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setInt(1, id);
		this.resultSet = this.preparedStatement.executeQuery();
		while(this.resultSet.next()) {
			commande = new Commande(this.resultSet.getInt(1), this.resultSet.getDate(2), this.resultSet.getInt(3));
			break;
		}
		return commande;
	}

	@Override
	public java.util.List<Commande> getByIdUser(int id) throws SQLException {
		String qry = "select * from commande where idUtil = ?";
		List<Commande> list = new ArrayList<Commande>();
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setInt(1, id);
		this.resultSet = this.preparedStatement.executeQuery();
		while(this.resultSet.next()) {
			list.add(new Commande(this.resultSet.getInt(1), this.resultSet.getDate(2), this.resultSet.getInt(3)));
		}
		return list;
	}

}
