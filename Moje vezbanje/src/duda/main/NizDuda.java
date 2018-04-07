package duda.main;

import labis.exception.LabisException;
import labis.niz.ANiz;

/**
 * Klasa koja predstavlja niz - Duda
 * @author Dragutin Todorovic
 *
 */
public class NizDuda extends ANiz{
	
	/**
	 * Prikazuje niz
	 * @param niz niz koji se prikazuje
	 * @throws LabisException ako je niz prazan
	 */
	public void prikazNiza(int[] niz) throws LabisException {
		if(niz.length == 0) {
			throw new LabisException("Niz je prazan");
		}
		
		for(int i = 0; i < niz.length; i++) {
			System.out.print(niz[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * Metoda koja vraca najveci neparan element u nizu
	 * @param niz niz u kom se trazi
	 * @return najveciNeparan najveci neparan element u nizu
	 * @throws LabisException ako niz nema neparnih elemenata 
	 */
	public int najveciNeparanElement(int[] niz) throws LabisException {
		int najveciNeparan = Integer.MIN_VALUE;
		
		for(int i = 0; i < niz.length; i++) {
			if(niz[i] % 2 != 0 && niz[i] > najveciNeparan) {
				najveciNeparan = niz[i];
			}
		}
		
		if(najveciNeparan == Integer.MIN_VALUE) {
			throw new LabisException("Nema neparnih elemenata");
		}
		
		return najveciNeparan;
	}
	
	/**
	 * Metoda koja vraca koliko se puta jedan element sadrzi u nekom nizu
	 * @param niz niz u kom se proverava
	 * @param broj broj za koji se racuna frekvencija
	 * @return frekvencija tog broja
	 * @throws LabisException ako je niz lose unet ili prazan
	 */
	public int frekvencijaBroja(int[] niz, int broj) throws LabisException {
		if(niz == null) {
			throw new LabisException();
		}
		
		int brojac = 0;
		
		for(int i = 0; i < niz.length; i++) {
			if( niz[i] == broj) {
				brojac++;
			}
		}
		return brojac;
	}
	
	/**
	 * Metoda koja ispisuje elemente koji se pojavljuju u nizu samo jednom
	 * @param niz niz koji se prikazuje
	 * @throws LabisException ako je lose prosledjen niz
	 */
	public void ispisiJedinstveneElemente(int[] niz) throws LabisException {
		if(niz == null) {
			throw new LabisException("Nije prosledjen niz");
		}
		if(niz.length == 0) {
			System.out.println("Niz je prazan");
			return;
		}
		
		for(int i = 0; i < niz.length; i++) {
			if( frekvencijaBroja(niz, niz[i]) == 1) {
				System.out.print(niz[i] + " ");
			}
		}
	}
	
}
