package duda.test;

import duda.main.JSListaDuda;
import labis.test.ListGenerator;

public class TestJSListaDuda {
	
	public static void main(String[] args) {
		JSListaDuda l = new JSListaDuda();
		JSListaDuda l1 = new JSListaDuda();
		ListGenerator.napraviJSListuCommon(l, new int[] {2,3,4,5,6}, false);
		ListGenerator.napraviJSListuCommon(l1, new int[] {5,6,7,8}, false);
		
		try {
/*			
////////////////////////////////////////////////////////////////////////////////////////////			
  			System.out.println(l.pozitivniElementiRekurzivno(l.prvi));
////////////////////////////////////////////////////////////////////////////////////////////			
			System.out.println("Izbacen je broj " + l.izbaciElementNakonMinimuma(l.prvi));
////////////////////////////////////////////////////////////////////////////////////////////			
			l.invertujBezPomocne();
////////////////////////////////////////////////////////////////////////////////////////////			
			if( l.daLiPostojiRekurzivno(l.prvi, -34) ) {
				System.out.println("Postoji");
			} else {
				System.out.println("Ne postoji");
			}
////////////////////////////////////////////////////////////////////////////////////////////			
			if( l.daLiJeSortiranaRastuceRekurzivno(l.prvi) ) {
				System.out.println("Sortirana je rastuce");
			} else {
				System.out.println("Nije sortirana rastuce");
			}
////////////////////////////////////////////////////////////////////////////////////////////			
			l.ispisiListu();
			System.out.println("Izbacen je broj " + l.izbaciNajmanjiElement());
////////////////////////////////////////////////////////////////////////////////////////////			
			System.out.println(l.duzinaNajduzeRastucePodliste());
////////////////////////////////////////////////////////////////////////////////////////////			
			JSListaDuda l = new JSListaDuda();
			JSListaDuda l1 = new JSListaDuda();
			ListGenerator.napraviJSListuCommon(l, new int[] {15,13,11,10,9,10,8}, false);
			ListGenerator.napraviJSListuCommon(l1, new int[] {15,13,11,10,9,10,8}, false);

			l.ispisiListu( l.spojiDveListeIsteDuzineUnakrsno(l.prvi, l1.prvi));
////////////////////////////////////////////////////////////////////////////////////////////			
			l.ispisiListu();
			l.izbaciDrugiITreciOdPozadi();
////////////////////////////////////////////////////////////////////////////////////////////			
*/			
			
			
			JSListaDuda.ispisiListu( JSListaDuda.simetricnaRazlikaDveJSListe(l.prvi,l1.prvi) );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
