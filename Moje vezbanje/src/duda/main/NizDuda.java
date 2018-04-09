package duda.main;

import labis.exception.LabisException;
import labis.niz.ANiz;

/**
 * Klasa koja predstavlja niz - Duda
 * 
 * @author Dragutin Todorovic
 *
 */
public class NizDuda extends ANiz {

	/**
	 * Prikazuje niz
	 * 
	 * @param niz
	 *            niz koji se prikazuje
	 * @throws LabisException
	 *             ako je niz prazan
	 */
	public void prikazNiza(int[] niz) throws LabisException {
		if (niz.length == 0) {
			throw new LabisException("Niz je prazan");
		}

		for (int i = 0; i < niz.length; i++) {
			System.out.print(niz[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Metoda koja vraca najveci neparan element u nizu
	 * 
	 * @param niz
	 *            niz u kom se trazi
	 * @return najveciNeparan najveci neparan element u nizu
	 * @throws LabisException
	 *             ako niz nema neparnih elemenata
	 */
	public int najveciNeparanElement(int[] niz) throws LabisException {
		int najveciNeparan = Integer.MIN_VALUE;

		for (int i = 0; i < niz.length; i++) {
			if (niz[i] % 2 != 0 && niz[i] > najveciNeparan) {
				najveciNeparan = niz[i];
			}
		}

		if (najveciNeparan == Integer.MIN_VALUE) {
			throw new LabisException("Nema neparnih elemenata");
		}

		return najveciNeparan;
	}

	/**
	 * Metoda koja vraca koliko se puta jedan element sadrzi u nekom nizu
	 * 
	 * @param niz
	 *            niz u kom se proverava
	 * @param broj
	 *            broj za koji se racuna frekvencija
	 * @return frekvencija tog broja
	 * @throws LabisException
	 *             ako je niz lose unet ili prazan
	 */
	public int frekvencijaBroja(int[] niz, int broj) throws LabisException {
		if (niz == null) {
			throw new LabisException();
		}

		int brojac = 0;

		for (int i = 0; i < niz.length; i++) {
			if (niz[i] == broj) {
				brojac++;
			}
		}
		return brojac;
	}

	/**
	 * Metoda koja ispisuje elemente koji se pojavljuju u nizu samo jednom
	 * 
	 * @param niz
	 *            niz koji se prikazuje
	 * @throws LabisException
	 *             ako je lose prosledjen niz
	 */
	public void ispisiJedinstveneElemente(int[] niz) throws LabisException {
		if (niz == null) {
			throw new LabisException("Nije prosledjen niz");
		}
		if (niz.length == 0) {
			System.out.println("Niz je prazan");
			return;
		}

		for (int i = 0; i < niz.length; i++) {
			if (frekvencijaBroja(niz, niz[i]) == 1) {
				System.out.print(niz[i] + " ");
			}
		}
	}

	// napisati metodu koja pronalazi zbir tri najvece vrednosti u nizu jednim
	// prolaskom kroz niz
	/**
	 * Metoda koja pronalazi tri najvece vrednosti u nizu i vraca njihov zbir
	 * 
	 * @param niz
	 *            niz u kom se traze vrednosti
	 * @return zbir tri najvece vrednosti
	 * @throws LabisException
	 *             ako u nizu nema dovoljno brojeva, odnosno duzina niza je manja od
	 *             3 ili ako niz nije unet
	 */
	public int zbirTriNajveceVrednosti(int[] niz) throws LabisException {
		if (niz == null)
			throw new LabisException("Niz ne postoji");

		if (niz.length < 3)
			throw new LabisException("U nizu nema dovoljno brojeva");

		int prvaVr = niz[0];
		int drugaVr = niz[1];
		int trecaVr = niz[2];

		for (int i = 3; i < niz.length; i++) {
			if (niz[i] > prvaVr && drugaVr > prvaVr && trecaVr > prvaVr) {
				prvaVr = niz[i];
				continue;
			}
			if (niz[i] > drugaVr && prvaVr > drugaVr && trecaVr > drugaVr) {
				drugaVr = niz[i];
				continue;
			}
			if (niz[i] > trecaVr && prvaVr > trecaVr && drugaVr > trecaVr) {
				trecaVr = niz[i];
				continue;
			}
		}
		return prvaVr + drugaVr + trecaVr;
	}

	
	/**
	 * Metoda koja spaja dva rastuca niza i vraca novi niz koji je u opadajucem redosledu
	 * @param prvi prvi niz
	 * @param drugi drugi niz
	 * @return novi niz
	 */
	public int[] spojiDvaRastucaNizaIVratiNoviOpadajuci(int[] prvi, int[] drugi) {
		int[] noviNiz = new int[prvi.length + drugi.length];
		int brEl = 0;

		int indeksPrvi = prvi.length - 1;
		int indeksDrugi = drugi.length - 1;

		for (int i = 0; i < prvi.length + drugi.length; i++) {
			if (indeksPrvi >= 0 && indeksDrugi >= 0) { // oba niza imaju elemente
				if (prvi[indeksPrvi] > drugi[indeksDrugi]) {
					noviNiz[brEl++] = prvi[indeksPrvi--];
				} else {
					noviNiz[brEl++] = drugi[indeksDrugi--];
				}
			}

			if (indeksPrvi >= 0 && indeksDrugi < 0) {// drugi niz je ubacen ceo a prvi nije
				noviNiz[brEl++] = prvi[indeksPrvi--];
			}

			if (indeksPrvi < 0 && indeksDrugi >= 0) { // prvi niz je ubacen ceo a drugi nije
				noviNiz[brEl++] = drugi[indeksDrugi--];
			}

		}
		return noviNiz;
	}

	
	/**
	 * Metoda koja spaja dva rastuca niza i vraca novi niz koji je sortiran u rastucem redosledu
	 * @param prvi prvi niz
	 * @param drugi drugi niz
	 * @return novi niz
	 */
	public int[] spojiDvaRastucaNizaIVratiNoviRastuci(int[] prvi, int[] drugi) {
		int[] noviNiz = new int[prvi.length + drugi.length];
		int brEl = 0;

		int indeksPrvi = 0;
		int indeksDrugi = 0;

		for (int i = 0; i < prvi.length + drugi.length; i++) {
			if(indeksPrvi == prvi.length && indeksDrugi == drugi.length) 
				break;
			
			if ( (indeksPrvi <= prvi.length - 1) && (indeksDrugi <= drugi.length - 1)) { // oba niza imaju elemente
				if( prvi[indeksPrvi] < drugi[indeksDrugi] ) {
					noviNiz[brEl++] = prvi[indeksPrvi++];
				} else {
					noviNiz[brEl++] = drugi[indeksDrugi++];
				}
				continue;
			}
			
			if(indeksPrvi <= prvi.length - 1) {		// prvi niz ima jos elemenata a drugi je prazan
				noviNiz[brEl++] = prvi[indeksPrvi++];
				continue;
			}
			
			// ako nigde nije if dostigao true, znaci da samo drugi niz ima jos elemenata a prvi je prazan
			noviNiz[brEl++] = drugi[indeksDrugi++];
		}

		return noviNiz;
	}
}
