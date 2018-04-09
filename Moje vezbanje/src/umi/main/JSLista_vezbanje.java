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
	/**
	 * Metoda koja klonira datu listu rekurzivno
	 * @param prvi pokazivac na prvi element date liste
	 * @return novi pokazivac na prvi element nove liste
	 */
	public CvorJSListe klonirajListuRekurzivno(CvorJSListe prvi) {
		
		if(prvi == null) {
			return null;
		}
		
		CvorJSListe novi = new CvorJSListe(prvi.podatak, klonirajListuRekurzivno(prvi.sledeci));
		return novi;
	}
	/**
	 * Metoda koja proverava prosek parnih elemenata u ciklicnoj JS listi.
	 * @param prvi pokazivac na priv element liste
	 * @return prosek parnih elemenata
	 * @throws LabisException ukoliko je lista prazna, ili nema parnih elmenata
	 */
	public int prosekParnihCiklicna(CvorJSListe prvi) throws LabisException{
		
		if(prvi == null) {
			throw new LabisException("Lista ne postoji");
		}
		if (prvi.sledeci == prvi) {
			if(prvi.podatak % 2 == 0) {
				return prvi.podatak;
			}
			else {
				throw new LabisException("U listi je jedan elmenet i on nije paran");
			}
		}
		
		int brojac = 0;
		int suma = 0;
		CvorJSListe pom = prvi.sledeci;
		while (pom != prvi) {
			if (pom.podatak % 2 == 0) {
				suma = suma + pom.podatak;
				brojac++;
			}
			pom = pom.sledeci;
		}
		if(prvi.podatak % 2 == 0) {
			suma = suma + pom.podatak;
			brojac++;
		}
		
		if (brojac == 0) {
			throw new LabisException("U lisit nema parnih elemenata");
		}
		
		return suma/brojac;
	}
	/**
	 * Metoda koja izbacuje sve elemente vece od svog prethodnika iz liste
	 * 1 1 2 3 4 5 6 = 1 1 3 5 
	 * @param prvi pokazivac na prvi element liste	
	 * @return prvi pokazivac na prvi element liste
	 * @throws LabisException ukoliko je lista prazna ili ima samo jedan element
	 */
	public CvorJSListe izbaciVece(CvorJSListe prvi) throws LabisException{
		if(prvi == null) {
			throw new LabisException("Lista ne postoji");
		}
		if(prvi.sledeci == null) {
		 throw new LabisException("U listi je samo jedna element");
		}
		CvorJSListe drugi = prvi;
		
		while(drugi != null && drugi.sledeci != null) {
			if(drugi.podatak < drugi.sledeci.podatak) {
				drugi.sledeci = drugi.sledeci.sledeci;
			}
			drugi = drugi.sledeci;
		}

		return prvi;
		
	}
	/**
	 * Metoda koja iz lite izbacuje sve duplikate (nije savrsena, ne radi za slucajeve kada ima na primer 1 2 3 1 1 6) izbaci
	 * samo jednu jedinicu
	 * @param prvi pokazivac na prvi element liste
	 * @return prvi pokazivac na listu bez duplikata
	 * @throws LabisException ukoliko lista ne postoji ili ima samo jedan element
	 */
	public CvorJSListe izbaciDuplikate(CvorJSListe prvi) throws LabisException{
		
		if(prvi == null) {
			throw new LabisException("Lista je prazna");
		}
		if(prvi.sledeci == null) {
			throw new LabisException("U lisiti je samo jedan element");
		}
		
		CvorJSListe fix = prvi;
		CvorJSListe pom = prvi;
		while(fix.sledeci != null) {
			pom = fix.sledeci;
			while(pom != null && pom.sledeci != null) {
				if(fix.podatak == pom.sledeci.podatak) {
					pom.sledeci = pom.sledeci.sledeci;
				}
				pom = pom.sledeci;
			}
			fix = fix.sledeci;
		}
		
		return prvi;
	}
	/**
	 * Ubacuje novi element pre prvog cija suma sa prethodnima je veca od elementa koji se ubacuje.
	 * @param prvi pokazivac
	 * @param broj broj koji se ubacuje
	 * @return prvi pokazivac na prvi elment liste
	 * @throws LabisException ukoliko je lista prazna 
	 */
	public CvorJSListe ubaciKumulativ(CvorJSListe prvi, int broj) throws LabisException{
		
		if(prvi == null) {
			throw new LabisException("Lista je prazna");
		}
		int zbir = 0;
		int zbir2 = 0;
		CvorJSListe pom = prvi;
		while(pom.sledeci != null) {
			zbir = zbir + pom.podatak;
			zbir2 = zbir + pom.sledeci.podatak;
			if(zbir2 > broj) {
				CvorJSListe novi = new CvorJSListe(broj, pom.sledeci);
				pom.sledeci = novi;
				return prvi;
			}
			pom = pom.sledeci;
		}
		
		//nismo nasli ni jeda, dodajemo ga samo na kraj
		CvorJSListe novi = new CvorJSListe(broj, null);
		pom.sledeci = novi;
		return prvi;
	}
	/**
	 * Metoda koja invertuje datu listu bez duplikata u njoj.
	 * @param prvi pokazivac na prvi element liste
	 * @return novi pokazivac na prvi element nove liste bez duplikata koja je invertovana pocetna
	 * @throws LabisException ukoliko pocetna lista ne postoji
	 */
	public CvorJSListe invertujBezDupkiata(CvorJSListe prvi) throws LabisException{
		
		if(prvi == null) {
			throw new LabisException("Lista ne postoji");
		}
		if(prvi.sledeci == null) {
			return prvi;
		}
		CvorJSListe pom = prvi;
		CvorJSListe novi = null;
		CvorJSListe noviPom = novi;
		boolean postoji = false;
		while(pom != null) {
			noviPom = novi;
			while(noviPom != null) {
				if(noviPom.podatak == pom.podatak) {
					postoji = true;
				}
				noviPom = noviPom.sledeci;
			}
			if(postoji == false) {
				novi = new CvorJSListe(pom.podatak, novi);
			}
			postoji = false;
			pom = pom.sledeci;
		}
		
		return novi;
	}
	/**
	 * Metoda koja proverava koliko ima parnih elemenata u listi rekurzivno.
	 * @param prvi pokazivac na prvi element liste za koju proveravamo
	 * @return broj parnih kao int
	 */
	public int kolikoParnih(CvorJSListe prvi) {
		
		if(prvi == null) {
			return 0;
		}
		
		if(prvi.podatak % 2 == 0) {
			return 1 + kolikoParnih(prvi.sledeci);
		}
		else {
			return kolikoParnih(prvi.sledeci);
		}
	}
	
	public void ispisiListuNaopacke(CvorJSListe prvi) {
		
		if(prvi == null) {
			return;
		}
		
		ispisiListuNaopacke(prvi.sledeci);
		System.out.println(prvi.podatak);
	}
	
}
