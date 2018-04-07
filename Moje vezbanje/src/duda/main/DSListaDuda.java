package duda.main;

import labis.cvorovi.CvorDSListe;
import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.ADSLista;

/**
 * Klasa DS Lista
 * @author Dragutin Todorovic
 *
 */
public class DSListaDuda extends ADSLista {

	/**
	 * Prikaz DS liste
	 */
	public void ispisiListu() {
		if (prvi == null) {
			return;
		}

		CvorDSListe pom = prvi;
		while (pom != null) {
			System.out.print(pom.podatak + ", ");
			pom = pom.sledeci;
		}
	}

	/**
	 * Metoda koja proverava da li DS lista ima paran broj parnih elemenata na parnim pozicijama
	 * @return true ako ima, false ako nema
	 * @throws LabisException ako je prvi element null
	 */
	public boolean daLiImaParanBrojParnihNaParnimPoz() throws LabisException {
		if(prvi == null) {
			throw new LabisException();
		}
		int brojacParnih = 0;
		int i = 2;
		
		CvorDSListe pom = prvi.sledeci;
		while(pom != null) {
			if(pom.podatak % 2 == 0 && i % 2 == 0)
				brojacParnih++;
			i++;
			pom = pom.sledeci;
		}
		
		if(brojacParnih % 2 == 0) {
			return true;
		}
		return false;
	}
	
}
