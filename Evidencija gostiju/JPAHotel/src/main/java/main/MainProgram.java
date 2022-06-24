package main;

import crud.BoravakCrud;
import crud.GostCrud;
import crud.UslugaCrud;
import crud.VrstaSobeCrud;
import model.Gost;

public class MainProgram {

	public static void main(String[] args) {

		GostCrud gc = new GostCrud();
		
//		Gost gost = new Gost();
//		gost.setIme("Stefan");
//		gost.setPrezime("Kalafatic");
//		gost.setAdresa("Vladana Djordjevica 3");
//		
//		gc.insertGost(gost);
		
		BoravakCrud bc = new BoravakCrud();
		VrstaSobeCrud vsc = new VrstaSobeCrud();
		UslugaCrud uc = new UslugaCrud();
//		
//		String datum = "14.9.2021.";
//		String trajanje = "3";
//		
//		bc.insertBoravak(gc.getGostByID(1), vsc.getVrstasobeByID(1), uc.getUslugaByID(1), datum, trajanje);
//		
		
		gc.deleteGost(gc.getGostByID(1));
		
		System.exit(0);
	}

}
