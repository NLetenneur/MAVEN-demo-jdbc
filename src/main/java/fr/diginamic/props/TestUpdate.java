package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {

	public static void main(String[] args) {
		ResourceBundle config = ResourceBundle.getBundle("database");
		String url = config.getString("database.url");
		String user = config.getString("database.user");
		String password = config.getString("database.password");
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection maConnection = DriverManager.getConnection(url, user, password);
			Statement monStatement = maConnection.createStatement();
			int nb = monStatement
					.executeUpdate("update FOURNISSEUR set nom='La maison des Peintures' where id=4");
			System.out.println(nb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
