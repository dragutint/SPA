package duda.test;

import duda.main.NizDuda;
import labis.exception.LabisException;

public class TestNizDuda {
	public static void main(String[] args) {
		NizDuda niz = new NizDuda();
		int[] a = new int[] {2,1,7,1,15,1,10,16,11,19};
		
		
		try {
/*			
			System.out.println(niz.najveciNeparanElement(a) + " je najveci neparan element");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			niz.ispisiJedinstveneElemente(a);
			System.out.println();
			niz.prikazNiza(a);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			
*/
			System.out.println("Zbir tri najvece vrednosti je " + niz.zbirTriNajveceVrednosti(a));
			niz.prikazNiza(a);
		} catch (LabisException e) {
			System.out.println(e.getMessage());
		}
	}
}
