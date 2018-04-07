package duda;

import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.ADSLista;

public class DSListaDuda extends ADSLista {

	// prikaz liste
	public void ispisiListu() {
		if (prvi == null) {
			return;
		}

		CvorJSListe pom = prvi;
		while (pom != null) {
			System.out.print(pom.podatak + ", ");
			pom = pom.sledeci;
		}
	}

	// Da li DS lista ima paran broj parnih elemenata na parnim pozicijama
	public boolean daLiImaParanBrojParnihNaParnimPoz() throws LabisException {
		if(prvi == null) {
			throw new LabisException();
		}
		
		
	}
	
}
