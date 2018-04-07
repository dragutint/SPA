package duda;

import labis.cvorovi.CvorJSListe;
import labis.liste.ADSLista;

public class DSListaDuda extends ADSLista {

	// prikaz liste
	public void ispisiListu(CvorJSListe prvi) {
		if (prvi == null) {
			return;
		}

		CvorJSListe pom = prvi;
		while (pom != null) {
			System.out.print(pom.podatak + ", ");
			pom = pom.sledeci;
		}
	}

	
	
}
