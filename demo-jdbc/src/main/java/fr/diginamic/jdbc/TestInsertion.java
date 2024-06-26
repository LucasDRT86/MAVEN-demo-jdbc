package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

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
			int nb = stat.executeUpdate("INSERT INTO fournisseur (ID, NOM) VALUES (5, 'La Maison de la Peinture');");
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
