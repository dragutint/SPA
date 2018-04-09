package umi.main;

import labis.exception.LabisException;
import labis.niz.ANiz;

public class Nizovi_sam extends ANiz {
	
	/**
	 * Metoda koja ispisuje elemente niza koji se NE pojavljuju vise od jednom (znaci samo jednom)
	 * @param niz zadati niz
	 * @throws LabisException ukoliko niz ne postoji ili je prazan
	 */
	public void zzv10(int niz[]) throws LabisException {

		if (niz == null || niz.length == 0) {
			throw new LabisException("Niz ili ne postoji ili je prazan");
		}
		int brojac = 0;
		for (int i = 0; i < niz.length; i++) {
			for (int j = 0; j < niz.length; j++) {
				if (niz[i] == niz[j]) {
					brojac++;
				}
			}
			if (brojac == 1) {
				System.out.println(niz[i]);
			}
			brojac = 0;
		}
	}
	
	//vraca dvocifreni iz niza jednocifrenih, dvocifrenih i trocifrenih
	/**
	 * Metoda koja vraca dvocifreni element niza ako znamo da prvu idu jednocifreni, 
	 * taj dvocifreni i onda trocifreni do kraja
	 * @param niz zadati niz
	 * @return niz[i] koji ce biti taj dvocifreni kao int
	 * @throws LabisException ukoliko niz ne postoji ili je prazan ili ukoliko ne postoji dvocifreni broj
	 */
	public int zzv18(int niz[]) throws LabisException {
		
		if (niz == null || niz.length == 0) {
			throw new LabisException("Niz ili ne postoji ili je prazan");
		}
		int brojac = 0;
		int pom = 0;
		
		for(int i = 0; i<niz.length; i++) {
			pom = niz[i];
			while(pom >= 1) {
				pom = pom / 10;
				brojac++;
			}
			
			if(brojac == 2) {
				System.out.println(niz[i]);
				return niz[i];
			}
			brojac = 0;
		}
		
		throw new LabisException("Ne postoji dvocifreni");
		
	}
	
//	Od dva napravi jedan koji je u rastucem redosledu ( nije uradjen sort)
//	Uradjen je kasnije mnogo bolje tako da radi u svim mogucim situacijama za oba niza
//	public int[] zzv22(int a[], int b[]) {
//		
//		if (a == null || a.length == 0) {
//			return b;
//		}
//		if (b == null || b.length == 0) {
//			return a;
//		}
//
//		int[] novi = new int[a.length + b.length];
//		int brojac = 0;
//		for (int i = 0; i < a.length; i++) {
//			novi[i] = a[i];
//			brojac++;
//		}
//		for (int i = 0; i < b.length; i++) {
//			novi[brojac] = b[i];
//			brojac++;
//		}
//
//		return novi;
//	}
	
	/**
	 * Metoda koja vraca treci najveci element u nizu u jednom prolazu
	 * @param a niz koji je zadat
	 * @return m3 treci najveci element
	 * @throws LabisException ukoliko niz ne postoji ili ima manje od 3 elementa
	 */
	public int treciNajveci(int a[]) throws LabisException {
		
		if (a == null) {
			throw new LabisException("Niz ne postoji");
		}
		if(a.length < 3) {
			throw new LabisException("U nizu ima manje od 3 elementa");
		}
		
		int m1 = Integer.MIN_VALUE;
		int m2 = Integer.MIN_VALUE;
		int m3 = Integer.MIN_VALUE;

		
		for (int i = 0; i < a.length; i++) {
			if(a[i] > m1) {
				m3 = m2;
				m2 = m1;
				m1 = a[i];
			}
			else if(a[i] > m2) {
				m3 = m2;
				m2 = a[i];
			}
			else if(a[i] > m3) {
				m3 = a[i];
			}
		}
		return m3;
	}
	/**
	 * Metoda koja od dva rastuca niza pravi novi niz koji je opadajuci i sadrzi sve clanove oba niza.
	 * @param a prvi niz
	 * @param b drugi niz
	 * @return null ukoliko su oba zadata niza prazna
	 * 			novi[] koji predstavlja novi niz
	 */
	public int[] odDvaRastucaNoviOpadajuci(int[] a, int[] b) {
		
		if(a == null && b == null) {
			return null;
		}
		
		int[] novi = new int[a.length + b.length];
		int brEl = 0;
		int indexA = a.length - 1;
		int indexB = b.length - 1;
		for(int i = 0; i<novi.length; i++) {
			if( indexA >= 0 && indexB >= 0 ){ //postoje oba niza i imaju elemente
				if(a[indexA] > b[indexB]) {
					novi[brEl] = a[indexA];
					brEl++;
					indexA--;
				}
				if(b[indexB] > a[indexA]) {
					novi[brEl] = b[indexB];
					brEl++;
					indexB--;
				}
			}
			if( indexA < 0 && indexB >= 0) { //u A nema vise al ima u B
				novi[brEl] = b[indexB];
				brEl++;
				indexB--;
			}
			if( indexB < 0 && indexA >= 0) { //u B nema vise al ima u A
				novi[brEl] = a[indexA];
				brEl++;
				indexA--;
			}
		}
		
		return novi;
		
	}

}

