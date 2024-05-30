package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {
		ResourceBundle config = ResourceBundle.getBundle("database");
		String url = config.getString("database.url");
		String user = config.getString("database.user");
		String password = config.getString("database.password");
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection maConnection = DriverManager.getConnection(url, user, password);
			Statement monStatement = maConnection.createStatement();
			ResultSet curseur = monStatement
					.executeQuery("select * from FOURNISSEUR");
			ArrayList<Fournisseur> listeFour = new ArrayList<>();
			while(curseur.next()) {
				Integer id=curseur.getInt("id");
				String nom=curseur.getString("nom");
				listeFour.add(new Fournisseur(id, nom));
			}
			curseur.close();
			monStatement.close();
			maConnection.close();
			
			for (Fournisseur fournisseur: listeFour) {
				System.out.println(fournisseur);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
