package duda.test;

import duda.main.NizDuda;
import labis.exception.LabisException;

public class TestNizDuda {
	public static void main(String[] args) {
		NizDuda niz = new NizDuda();
		int[] a = new int[] {2,4,6,8,4,6,10};
		
		
		try {
/*			
			System.out.println(niz.najveciNeparanElement(a) + " je najveci neparan element");
			
			
*/
			niz.ispisiJedinstveneElemente(a);
			System.out.println();
			niz.prikazNiza(a);
		} catch (LabisException e) {
			System.out.println(e.getMessage());
		}
	}
}
