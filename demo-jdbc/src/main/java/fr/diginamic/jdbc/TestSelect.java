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
		
		System.out.println(url);
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());	
			Connection maConnection = DriverManager.getConnection(url, user, password);
			
			Statement stat = maConnection.createStatement();
			ResultSet res = stat.executeQuery("SELECT id, nom FROM fournisseur");
			System.out.println(res);
			
			ArrayList<Fournisseur> fournisseur = new ArrayList<>();
			
			while(res.next()) {
				Fournisseur newFournisseur = new Fournisseur(res.getInt("id"),res.getString("nom"));
				fournisseur.add(newFournisseur);
			}
			
			for(Fournisseur f : fournisseur) {
				System.out.println(f.getId() + " - " + f.getNom());
			}
			
			stat.close();
			maConnection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			System.exit(-1);
		}

	}

}
