package duda.main;

import labis.cvorovi.CvorDSListe;
import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.ADSLista;

/**
 * Klasa koja predstavlja DS listu - Duda
 * 
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
			System.out.print(pom.podatak + " ");
			pom = pom.sledeci;
		}
		System.out.println();
	}

	/**
	 * Ipisuje listu od pozadi
	 */
	public void ispisiListuOdPozadi() {
		if (prvi == null) {
			return;
		}

		CvorDSListe pom = prvi;
		while (pom.sledeci != null) {
			pom = pom.sledeci;
		}
		while (pom != null) {
			System.out.print(pom.podatak + " ");
			pom = pom.prethodni;
		}
	}

	/**
	 * Ispis liste od pozadi preko rekurzije
	 * 
	 * @param prvi
	 */
	public void ispisiListuOdPozadiRekurzivno(CvorDSListe prvi) {
		if (prvi == null) {
			return;
		}
		ispisiListuOdPozadiRekurzivno(prvi.sledeci);
		System.out.print(prvi.podatak + " ");
	}

	/**
	 * Metoda koja proverava da li DS lista ima paran broj parnih elemenata na
	 * parnim pozicijama
	 * 
	 * @return true ako ima, false ako nema
	 * @throws LabisException
	 *             ako je prvi element null
	 */
	public boolean daLiImaParanBrojParnihNaParnimPoz() throws LabisException {
		if (prvi == null) {
			throw new LabisException();
		}
		int brojacParnih = 0;
		int i = 2;

		CvorDSListe pom = prvi.sledeci;
		while (pom != null) {
			if (pom.podatak % 2 == 0 && i % 2 == 0)
				brojacParnih++;
			i++;
			pom = pom.sledeci;
		}

		if (brojacParnih % 2 == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Metoda koja vraca zbir elemenata DS liste
	 * 
	 * @return zbir elemenata
	 * @throws LabisException
	 *             ako je prvi element null, odnosno lista prazna
	 */
	public int zbirElemenata() throws LabisException {
		if (prvi == null) {
			throw new LabisException();
		}

		int zbir = 0;
		CvorDSListe pom = prvi;
		while (pom != null) {
			zbir += pom.podatak;
			pom = pom.sledeci;
		}

		return zbir;
	}

	/**
	 * Metoda koja vraca proizvod neparnih elemenata kojima su i prethodnik i
	 * sledbenik parni u DS listi
	 * 
	 * @return int proizvod neparnih elemenata kojima su prethodnik i sledbenik
	 *         parni
	 * @throws LabisException
	 *             ako je lista prazna, ima samo jedan element ili ima samo dva
	 *             elementa
	 */
	public int proizvodNeparnihPrethodnikSledbenikParni() throws LabisException {
		if (prvi == null || prvi.sledeci == null || prvi.sledeci.sledeci == null) {
			throw new LabisException();
		}
		int proizvod = 1;

		CvorDSListe pom = prvi.sledeci;

		while (pom != null) {
			if (pom.podatak % 2 != 0 && pom.prethodni.podatak % 2 == 0 && pom.sledeci.podatak % 2 == 0) {
				proizvod *= pom.podatak;
			}
			pom = pom.sledeci;
		}

		return proizvod;
	}

	/**
	 * Metoda koja izbacuje duplikate iz DS liste
	 * @throws LabisException ako je lista prazna ili ima samo jedan element u njoj
	 */
	public void izbaciDuplikateIzListe() throws LabisException {
		if (prvi == null)
			throw new LabisException("Lista je prazna");
		if (prvi.sledeci == null)
			throw new LabisException("Lista ima samo jedan element");

		CvorDSListe spori = prvi;
		CvorDSListe brzi;

		while (spori.sledeci != null) {
			brzi = spori.sledeci;
			while(brzi != null && brzi.sledeci != null) {
				if(brzi.podatak == spori.podatak) {
					brzi.prethodni.sledeci = brzi.sledeci;
					brzi.sledeci.prethodni = brzi.prethodni;
				}
				brzi = brzi.sledeci;
			}
			spori = spori.sledeci;
		}
	}
	
	/**
	 * Metoda koja vrsi zamenu prva dva elementa u listi
	 * @throws LabisException ako je lista prazna ili ako ima samo jedan element
	 */
	public void zameniMestaPrvaDvaElementa() throws LabisException {
		if(prvi == null) 
			throw new LabisException("Lista je prazna");
		
		if(prvi.sledeci == null) 
			throw new LabisException("U listi postoji samo jedan element");
		
		prvi.sledeci.prethodni = null;
		prvi.sledeci = prvi.sledeci.sledeci;
		prvi.prethodni = prvi.sledeci.prethodni;
		prvi.sledeci.prethodni = prvi;
		prvi.prethodni.sledeci = prvi;
		prvi = prvi.prethodni;
	}
}
