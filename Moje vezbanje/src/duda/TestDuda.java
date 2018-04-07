package duda;

import labis.test.ListGenerator;

public class TestDuda {
	
	public static void main(String[] args) {
		JSListaDuda l = new JSListaDuda();
		ListGenerator.napraviJSListuCommon(l, new int[] {-150,-34,3,5,6,7,8}, false);
		
		try {
/*			
  			System.out.println(l.pozitivniElementiRekurzivno(l.prvi));
			
			System.out.println("Izbacen je broj " + l.izbaciElementNakonMinimuma(l.prvi));
			
			l.invertujBezPomocne();
			
			if( l.daLiPostojiRekurzivno(l.prvi, -34) ) {
				System.out.println("Postoji");
			} else {
				System.out.println("Ne postoji");
			}
			
*/			
			if( l.daLiJeSortiranaRastuceRekurzivno(l.prvi) ) {
				System.out.println("Sortirana je rastuce");
			} else {
				System.out.println("Nije sortirana rastuce");
			}
			
			l.ispisiListu();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
