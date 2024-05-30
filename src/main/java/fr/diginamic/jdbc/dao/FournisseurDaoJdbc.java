package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	ResourceBundle config = ResourceBundle.getBundle("database");
	String url = config.getString("database.url");
	String user = config.getString("database.user");
	String password = config.getString("database.password");

	@Override
	public List<Fournisseur> extraire() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection maConnection = DriverManager.getConnection(url, user, password);
			Statement monStatement = maConnection.createStatement();
			ResultSet curseur = monStatement.executeQuery("select * from FOURNISSEUR");
			List<Fournisseur> listeFour = new ArrayList<>();
			while (curseur.next()) {
				Integer id = curseur.getInt("id");
				String nom = curseur.getString("nom");
				listeFour.add(new Fournisseur(id, nom));
			}
			curseur.close();
			monStatement.close();
			maConnection.close();
			return listeFour;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection maConnection = DriverManager.getConnection(url, user, password);
			Statement monStatement = maConnection.createStatement();
			int nb = monStatement.executeUpdate("insert into FOURNISSEUR(id, nom) values(" + fournisseur.getId() + ", '"
					+ fournisseur.getNom() + "')");
			System.out.println(nb);
			monStatement.close();
			maConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection maConnection = DriverManager.getConnection(url, user, password);
			Statement monStatement = maConnection.createStatement();
			int nb = monStatement.executeUpdate("update FOURNISSEUR set nom='" + nouveauNom + "' where nom='" + ancienNom+"'");
			monStatement.close();
			maConnection.close();
			return nb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection maConnection = DriverManager.getConnection(url, user, password);
			Statement monStatement = maConnection.createStatement();
			int nb = monStatement.executeUpdate("delete from FOURNISSEUR where id=" + fournisseur.getId());
			if (nb != 0) {
				return true;
			}
			monStatement.close();
			maConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
