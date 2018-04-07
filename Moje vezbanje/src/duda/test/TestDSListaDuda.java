package duda.test;

import duda.main.DSListaDuda;
import duda.main.JSListaDuda;
import labis.test.ListGenerator;

public class TestDSListaDuda {
	public static void main(String[] args) {

		DSListaDuda l = new DSListaDuda();
		ListGenerator.napraviDSListuCommon(l, new int[] { 150, 34, 3, 6, 6, 7, 8, 10, 11, 12 }, false);

		try {
/*
			if (l.daLiImaParanBrojParnihNaParnimPoz()) {
				System.out.println("Ima");
			} else {
				System.out.println("Nema");
			}
			
			System.out.println("Zbir elemenata je " + l.zbirElemenata());
			
			System.out.println("Proizvod neparnih kojima je prethodnik i sledbenik paran je " + l.proizvodNeparnihPrethodnikSledbenikParni());
			
			l.ispisiListuOdPozadi();
			System.out.println();

			l.ispisiListuOdPozadiRekurzivno(l.prvi);
*/
			
			
			l.ispisiListu();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
