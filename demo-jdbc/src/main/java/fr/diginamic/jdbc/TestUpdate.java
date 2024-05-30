package fr.diginamic.jdbc;

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
		
		System.out.println(url);
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());	
			Connection maConnection = DriverManager.getConnection(url, user, password);
			
			Statement stat = maConnection.createStatement();
			int nb = stat.executeUpdate("UPDATE fournisseur SET fournisseur.Nom = 'La Maison du peintre' WHERE fournisseur.id = 5");
			System.out.println(nb);
			
			stat.close();
			maConnection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			System.exit(-1);
		}

	}

}
