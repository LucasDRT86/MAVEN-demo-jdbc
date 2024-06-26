package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

public class TestDaoJdbc {

	public static void main(String[] args) {
		FournisseurDaoJdbc fournisseur = new FournisseurDaoJdbc();
		
		fournisseur.extraire();
		fournisseur.insert(new Fournisseur(6, "Gedimat"));
		fournisseur.extraire();
		fournisseur.update("Gedimat", "Gedimat Terasson");
		fournisseur.extraire();
		fournisseur.delete(new Fournisseur(6,"Gedimat Terasson"));
		fournisseur.extraire();
	}

}
