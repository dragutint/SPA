package umi.test;

import labis.cvorovi.CvorDSListe;
import labis.exception.LabisException;
import labis.liste.ADSLista;
import labis.test.ListGenerator;
import umi.main.DSLista_vezbanje;

public class DSLista_test extends ListGenerator{

	public static void main(String[] args) {
		
		int[] niz = new int[] {1,2,3,4};
		ADSLista lista = new ADSLista() {
		};
		ListGenerator.napraviDSListuCommon(lista, niz, false);
		
		DSLista_vezbanje o = new DSLista_vezbanje();
		ListGenerator.ispisiDSListu(lista.prvi);
		
		
		
//		try {
//			CvorDSListe a = o.zameniPrvaDva(lista.prvi);
//			System.out.println("________________");
//			ListGenerator.ispisiDSListu(a);
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
//		try {
//			System.out.println(o.vratiProizvod(lista.prvi));
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
//		try {
//			CvorDSListe a = o.kloniraj(lista.prvi);
//			System.out.println("___________");
//			ListGenerator.ispisiDSListu(a);
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
		try {
			CvorDSListe a = o.invertujBezNovih(lista.prvi);
			CvorDSListe pom = a;
			System.out.println("od pozadi invertovana ___________");
			while(pom.sledeci != null) {
				pom = pom.sledeci;
			}
			while(pom != null) {
				System.out.println(pom.podatak);
				pom = pom.prethodni;
			}

			System.out.println("od pocetka invertovana ___________");
			ListGenerator.ispisiDSListu(a);
		} catch (LabisException e) {
			System.out.println(e);
		}
		

	}

}
