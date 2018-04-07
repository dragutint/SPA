package umi.main;

import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.AJSLista;

public class JSLista_vezbanje extends AJSLista {

	/**
	 * Metoda koja vraca duzinu najduze neopadajuce podlise unutar zadate
	 * @param prvi pokazivac na prvi element liste
	 * @return najduzi predstavlja duzinu najduze podliste u int
	 * @throws LabisException ukoliko je pocetna lista nepostojeca
	 */
	public int vratiNajduzuNeopadajucuPodlistu(CvorJSListe prvi) throws LabisException {

		if (prvi == null) {
			throw new LabisException("Lista ne postoji");
		}
		if (prvi.sledeci == null) {
			return 1;
		}

		CvorJSListe pom = prvi;
		int brojac = 1;
		int najduzi = 0;
		while (pom.sledeci != null) {
			if (pom.sledeci.podatak >= pom.podatak) {
				brojac++;
			} else {
				if (brojac > najduzi) {
					najduzi = brojac;
					brojac = 1;
				}
			}
			pom = pom.sledeci;
		}
		if (brojac > najduzi) {
			najduzi = brojac;
			brojac = 1;
		}
		return najduzi;
	}

	/**
	 * Metoda koji izbacuje 2 i 3 element od pozadi iz JS liste
	 * @param prvi pokazivac na prvi element JS liste
	 * @return prvi pokazivac na prvi element liste
	 * @throws LabisException ukoliko je pocetna lista prazna ili ima mnje od 3 elementa
	 */
	public CvorJSListe izbaci2i3odpozadi(CvorJSListe prvi) throws LabisException {

		if (prvi == null) {
			throw new LabisException("Lista ne postoji");
		}
		if (prvi.sledeci == null) {
			throw new LabisException("U lisit ima samo 1 element");
		}
		if (prvi.sledeci.sledeci == null) {
			throw new LabisException("U lisiti ima samo 2 elementa");
		}
		if (prvi.sledeci.sledeci.sledeci == null) {
			return prvi.sledeci.sledeci;
		}
		CvorJSListe pom = prvi;
		int brojac = 0;
		while (pom != null) {
			brojac++;
			pom = pom.sledeci;
		}
		// System.out.println(brojac);

		pom = prvi;
		for (int i = 0; i < brojac - 4; i++) {
			pom = pom.sledeci;
		}
		pom.sledeci = pom.sledeci.sledeci.sledeci;

		return prvi;
	}
	
	/**
	 * Metoda koja vraca prosek parnih elemenata u listi
	 * @param prvi pokazivacna prvi element liste
	 * @return prosek prosek parnih elemnata kao double
	 * @throws LabisException ukliko je pocetna lista nepostojeca ili prazna ili ukoliko ne postoji parni element u listi
	 */
	public double prosekParnih(CvorJSListe prvi) throws LabisException {

		if (prvi == null) {
			throw new LabisException("Lisa je prazna");
		}

		CvorJSListe pom = prvi;
		double suma = 0;
		int brojac = 0;

		while (pom != null) {
			if (pom.podatak % 2 == 0) {
				suma = suma + pom.podatak;
				brojac++;
			}
			pom = pom.sledeci;
		}
		if (brojac != 0) {
			return suma / brojac;
		}

		throw new LabisException("U lisit nema parnih");
	}
	
	/**
	 * Metoda koja ubacuje element odmah nakom prvog elementa cija suma sa prethodnicima je veca od elementa koji se ubacuje.
	 * @param prvi pokazivac na prvi element liste
	 * @param p element koji se ubacuje u listu
	 * @return prvi pokazivac na prvi element
	 * @throws LabisException ukoliko je pocetna lista prazna ili ne postoji
	 */
	public CvorJSListe noviPrePrvog(CvorJSListe prvi, int p) throws LabisException {

		if (prvi == null) {
			throw new LabisException("Lisa je prazna");
		}

		CvorJSListe pom = prvi;
		int suma = prvi.podatak;

		while (pom.sledeci != null) {
			if (suma > p) {
				break;
			}
			pom = pom.sledeci;
			suma = suma + pom.podatak;
		}

		CvorJSListe novi = new CvorJSListe(p, pom.sledeci);
		pom.sledeci = novi;

		return prvi;

	}
	/**
	 * Metoda koja invertuje JS listu uz pomoc novih struktura
	 * @param prvi pokazivac na prvi element
	 * @return prvi pokazivac na prvi element invertovane liste
	 * @throws LabisException ukoliko je pocetna prazna ili ne postoji
	 */
	public CvorJSListe invertovanjeSaPomocnom(CvorJSListe prvi) throws LabisException {
		if (prvi == null || prvi.sledeci == null) {
			return null;
		}
		CvorJSListe pom = prvi;
		CvorJSListe novi = null;
		while (pom != null) {
			novi = new CvorJSListe(pom.podatak, novi);
			pom = pom.sledeci;

		}
		prvi = novi;
		return prvi;
	}
	/**
	 * Metoda koja invertuje JS listu bez novih struktura
	 * @param prvi pokazivac na prvi element
	 * @return prvi pokazivac na prvi element invertovane liste
	 * @throws LabisException ukoliko je pocetna prazna ili ne postoji
	 */
	public CvorJSListe invertovanjeBezPomocne(CvorJSListe prvi) throws LabisException {
		if (prvi == null || prvi.sledeci == null) {
			return null;

		}

		CvorJSListe pom = prvi;
		CvorJSListe pom2 = prvi;

		while (pom2.sledeci != null) {
			pom = pom2.sledeci;
			pom2.sledeci = pom.sledeci;
			pom.sledeci = prvi;
			prvi = pom;

		}
		
		return prvi;
	}
	/**
	 * metoda koja proverava da li zadati element postoji u listi rekurzijom
	 * @param prvi pokazivac na prvi element
	 * @param p element koji se trazi
	 * @return true ili false ukoliko je element nadje odnosno nije nadjen
	 */
	public boolean nadjiElementRekurzijom(CvorJSListe prvi, int p) {
		
		if(prvi == null) {
			return false;
		}
		
		if(prvi.podatak == p) {
			return true;
		}
		return nadjiElementRekurzijom(prvi.sledeci, p);
	}
	/**
	 * Metoda koja proverava da li je lista rastuca rekurzijom
	 * @param prvi pokazivac na prvi element
	 * @return true ukoliko jeste, false ukoliko nije
	 */
	public boolean daLiJeSortiranaRastuce(CvorJSListe prvi) {
		
		if (prvi.sledeci == null) {
			return true;
		}
		if (prvi.podatak > prvi.sledeci.podatak) {
			return false;
		}
		
		return daLiJeSortiranaRastuce(prvi.sledeci);
	}

}
