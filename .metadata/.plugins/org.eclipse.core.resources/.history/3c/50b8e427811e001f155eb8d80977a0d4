package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;




public class TestConnexionJdbc {

	public static void main(String[] args) {

		ResourceBundle config = ResourceBundle.getBundle("database");
		String url = config.getString("database.url");
		String user = config.getString("database.user");
		String password = config.getString("database.password");
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());	
			Connection maConnection = DriverManager.getConnection(url, user, password);
			
			maConnection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
	}

}
