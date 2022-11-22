package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Utilisateur;
import ma.fstt.service.UtilisateurRepository;
import ma.fstt.tools.ConnectionManager;

public class UtilisateurDao implements UtilisateurRepository {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public UtilisateurDao() throws SQLException, ClassNotFoundException {
		connection = ConnectionManager.getConnection();
	}

	@Override
	public void save(Utilisateur utilisateur) throws SQLException {
		String qry = "insert into utilisateur(nomUtil, passwordUtil, adresseUtil, emailUtil, typeUtil) values (? , ?, ?, ?, ?)";
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setString(1, utilisateur.getNomUtil());
		this.preparedStatement.setString(2, utilisateur.getPasswordUtil());
		this.preparedStatement.setString(3, utilisateur.getAdresseUtil());
		this.preparedStatement.setString(4, utilisateur.getEmailUtil());
		this.preparedStatement.setInt(5, utilisateur.getTypeUtil());
		this.preparedStatement.execute();

	}

	@Override
	public void update(Utilisateur utilisateur) throws SQLException {
		String qry = "update utilisateur set nomUtil = ?, passwordUtil = ?, adresseUtil = ? , emailUtil = ?, typeUtil = ? where idUtil=?";
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setString(1, utilisateur.getNomUtil());
		this.preparedStatement.setString(2, utilisateur.getPasswordUtil());
		this.preparedStatement.setString(3, utilisateur.getAdresseUtil());
		this.preparedStatement.setString(4, utilisateur.getEmailUtil());
		this.preparedStatement.setInt(5, utilisateur.getTypeUtil());
		this.preparedStatement.setInt(6, utilisateur.getIdUtil());
		this.preparedStatement.execute();

	}

	@Override
	public void delete(int id) throws SQLException {
		String qry = "delete from utilisateur where idUtil = ?";
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setInt(1, id);
		this.preparedStatement.execute();
	}

	@Override
	public java.util.List<Utilisateur> List() throws SQLException {
		String qry = "select * from utilisateur";
		List<Utilisateur> list = new ArrayList<Utilisateur>();
		this.statement = this.connection.createStatement();
		this.resultSet = this.statement.executeQuery(qry);
		while (this.resultSet.next()) {
			list.add(new Utilisateur(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), 
					this.resultSet.getString(5), this.resultSet.getInt(6)));
		}
		return list;
	}

	@Override
	public Utilisateur getById(int id) throws SQLException {
		String qry = "select * from utilisateur where idUtil = ?";
		Utilisateur utilisateur = null;
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setInt(1, id);
		this.resultSet = this.preparedStatement.executeQuery();
		while (this.resultSet.next()) {
			utilisateur = new Utilisateur(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), 
					this.resultSet.getString(5), this.resultSet.getInt(6));
			break;
		}
		return utilisateur;
	}

	@Override
	public Utilisateur getByEmail(String email) throws SQLException {
		String qry = "select * from utilisateur where emailUtil = ?";
		Utilisateur utilisateur = null;
		this.preparedStatement = this.connection.prepareStatement(qry);
		this.preparedStatement.setString(1, email);
		this.resultSet = this.preparedStatement.executeQuery();
		while(this.resultSet.next()) {
			utilisateur = new Utilisateur(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), 
					this.resultSet.getString(5), this.resultSet.getInt(6));
			break;
		}
		return utilisateur;
	}
}
