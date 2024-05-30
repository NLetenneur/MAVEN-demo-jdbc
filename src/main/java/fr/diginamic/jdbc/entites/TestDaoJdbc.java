package fr.diginamic.jdbc.entites;

import java.util.List;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

public class TestDaoJdbc {

	public static void main(String[] args) {
		Fournisseur four5 = new Fournisseur(5,"France de matériaux");
		FournisseurDaoJdbc fournisseurDaoJdbc = new FournisseurDaoJdbc();
		fournisseurDaoJdbc.insert(four5);
		List<Fournisseur>listeFour=fournisseurDaoJdbc.extraire();
		System.out.println(listeFour);
		fournisseurDaoJdbc.update( "France de matériaux", "France matériaux");
		listeFour=fournisseurDaoJdbc.extraire();
		System.out.println(listeFour);
		fournisseurDaoJdbc.delete(four5);
		listeFour=fournisseurDaoJdbc.extraire();
		System.out.println(listeFour);

	}

}
