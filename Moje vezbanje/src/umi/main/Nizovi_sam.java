package umi.main;

import labis.exception.LabisException;
import labis.niz.ANiz;

public class Nizovi_sam extends ANiz {
	
	//ispisuje elemente koji se NE pojavljuju vise od jednom
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
	
	//Od dva napravi jedan koji je u rastucem redosledu ( nije uradjen sort)
	public int[] zzv22(int a[], int b[]) {
		
		if (a == null || a.length == 0) {
			return b;
		}
		if (b == null || b.length == 0) {
			return a;
		}

		int[] novi = new int[a.length + b.length];
		int brojac = 0;
		for (int i = 0; i < a.length; i++) {
			novi[i] = a[i];
			brojac++;
		}
		for (int i = 0; i < b.length; i++) {
			novi[brojac] = b[i];
			brojac++;
		}

		return novi;
	}
	
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

}

