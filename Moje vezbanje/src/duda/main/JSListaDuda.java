package duda.main;

import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.AJSLista;

/**
 * Klasa koja predstavlja JS listu - Duda
 * @author Dragutin Todorovic
 *
 */
public class JSListaDuda extends AJSLista{
	
	/**
	 * Prikazuje listu
	 */
	public void ispisiListu() {
		if(prvi == null) {
			return;
		}
		
		CvorJSListe pom = prvi;
		while(pom != null) {
			System.out.print(pom.podatak + ", ");
			pom = pom.sledeci;
		}
	}
	
	/**
	 * Metoda koja broji pozitivne elemente rekurzivno
	 * @param prvi Cvor koji je prvi element liste
	 * @return int broj pozitivnih elemenata
	 */
	public int pozitivniElementiRekurzivno(CvorJSListe prvi) {
		if(prvi == null) {
			return 0;
		}
		
		if( prvi.podatak > 0 ) {
			return 1 + pozitivniElementiRekurzivno(prvi.sledeci);
		} else {
			return pozitivniElementiRekurzivno(prvi.sledeci);
		}	
	}
	
	/**
	 * Pravi od JS Liste niz i vraca ga
	 * @param prvi Cvor koji je prvi element liste
	 * @return niz elemenata JS liste
	 * @throws LabisException ako je lista prazna
	 */
	public int[] listaUNiz(CvorJSListe prvi) throws LabisException {
		if(prvi == null) throw new LabisException();
		
		CvorJSListe pom = prvi;
		int brEl = 0;
		
		while(pom != null) {
			brEl++;
			pom = pom.sledeci;
		}
		pom = prvi;
		int[] niz = new int[brEl];
		brEl = 0;
		
		while(pom != null) {
			niz[brEl++] = pom.podatak;
			pom = pom.sledeci;
		}
		
		return niz;
	}
	
	/**
	 * Metoda koja od dve JS liste pravi trecu i vraca je
	 * @param prva pokazivac na prvi element prve liste
	 * @param druga pokazivac na prvi element druge liste
	 * @return pokazivac na prvi element nove liste
	 */
	public CvorJSListe unijaDveListe(CvorJSListe prva, CvorJSListe druga) {
		if(prva == null && druga == null)
			return null;
		
		CvorJSListe novaLista = null;
		
		CvorJSListe pom = prva;
		while(pom != null) {
			novaLista = new CvorJSListe(pom.podatak, novaLista);
			pom = pom.sledeci;
		}
		pom = druga;
		while(pom != null) {
			novaLista = new CvorJSListe(pom.podatak, novaLista);
			pom = pom.sledeci;
		}
		
		return novaLista;
	}
	
	/**
	 * Metoda koja proverava da li postoji vrednost u JS listi
	 * @param prvi pokazivac na prvi element liste
	 * @param br broj za proveru
	 * @return true ako postoji, false ako ne postoji
	 */
	public boolean daLiPostoji(CvorJSListe prvi, int br) {
		if(prvi == null) {
			return false;
		}
		
		CvorJSListe pom = prvi;
		while(pom != null) {
			if(pom.podatak == br) 
				return true;
			pom = pom.sledeci;
		}
		return false;
	}

	// metoda koja vraca broj ponavljanja zadate vrednosti u listi
	public int frekvencijaBrojaUListi(CvorJSListe prvi, int br) {
		if(prvi == null) 
			return 0;

		int frek = 0;
		CvorJSListe pom = prvi;
		while(pom != null) {
			if(pom.podatak == br)
				frek++;
			
			pom = pom.sledeci;
		}
		return frek;
	}
	
	// metoda koja broji koliko ima elemenata u listi koji su veci od prvog elementa
	public int prebrojVeceOdPrvog(CvorJSListe prvi) throws LabisException {
		if(prvi == null) 
			throw new LabisException();
		
		int brojac = 0;
		CvorJSListe pom = prvi.sledeci;
		while(pom != null) {
			if(pom.podatak > prvi.podatak) 
				brojac++;
			pom = pom.sledeci;
		}
		return brojac;
	}
	
	// metoda koja izbacuje element koji se nalazi nakon elementa sa najmanjom vrednoscu
	public int izbaciElementNakonMinimuma(CvorJSListe prvi) throws LabisException {
		if(prvi == null || prvi.sledeci == null) {
			throw new LabisException();
		}
		
		CvorJSListe min = prvi;
		CvorJSListe pom = prvi.sledeci;
		
		while(pom != null) {
			if(pom.podatak < min.podatak) 
				min = pom;
			pom = pom.sledeci;
		}
		
		if(min.sledeci == null) {
			throw new LabisException();
		}
		int br = min.sledeci.podatak;
		min.sledeci = min.sledeci.sledeci;
		return br;
	}
	
	// kloniraj listu rekurzivno - kopija date liste
	public CvorJSListe klonirajRekurzivno(CvorJSListe prvi) {
		if(prvi == null) 
			return null;
		
		CvorJSListe novaLista = new CvorJSListe(prvi.podatak, klonirajRekurzivno(prvi.sledeci));
		
		return novaLista;
	}
	
	// vrati invertovanu listu sa pomocnom strukturom 
	public void invertujSaPomocnom() throws LabisException {
		if(prvi == null) {
			throw new LabisException();
		}
		
		CvorJSListe pom = prvi;
		CvorJSListe novaLista = null;
		while(pom != null) {
			novaLista = new CvorJSListe(pom.podatak, novaLista);
			pom = pom.sledeci;
		}
		prvi = novaLista;
	}
	
	// vrati invertovanu listu bez pomocne strukture (moze pokazivac)
	public void invertujBezPomocne() throws LabisException {
		if(prvi == null || prvi.sledeci == null) {
			throw new LabisException();
		}
		
		CvorJSListe pom = prvi;
		CvorJSListe pom2 = prvi;
		
		while(pom2.sledeci != null) {
			pom = pom2.sledeci;
			pom2.sledeci = pom.sledeci;
			pom.sledeci = prvi;
			prvi = pom;
		}
	}
	
	//Metoda koja izbacuje iz JS liste cvor na koji je dat pokazivac
	public void izbaciElement(CvorJSListe element) throws LabisException {
		if(element == null || prvi == null) {
			throw new LabisException();
		}
		
		CvorJSListe pom = prvi;
		while(pom != null && pom.sledeci != element) {
			pom = pom.sledeci;
		}
		
		if(pom == null) {
			throw new LabisException();
		}
		
		pom.sledeci = pom.sledeci.sledeci;
	}
	/*
	Da li postoji zadata vrednost u JS/DS listi
		a) iterativno
		b) rekurzivno
	*/
	//iterativno
	public boolean daLiPostojiIterativno(int broj) {
		if(prvi == null) {
			return false;
		}
		
		CvorJSListe pom = prvi;
		while(pom != null) {
			if(pom.podatak == broj) {
				return true;
			}
			pom = pom.sledeci;
		}
		return false;
	}
	
	//rekurzivno
	public boolean daLiPostojiRekurzivno(CvorJSListe prvi, int broj) {
		if(prvi.podatak == broj) {
			return true;
		}
		
		if(prvi.sledeci == null) {
			return false;
		}
		
		return daLiPostojiRekurzivno(prvi.sledeci, broj);
	}
	

	/**
	 * Metoda koja proverava da li je lista sortirana u rastucem redosledu - iterativno
	 * @return true ako jeste sortirana u rastucem redosledu, false ako nije
	 * @throws LabisException ako je lista prazna
	 */
	public boolean daLiJeSortiranaRastuceIterativno() throws LabisException {
		if(prvi == null) {
			throw new LabisException();
		}
		if(prvi.sledeci == null) {
			return true;
		}
		
		CvorJSListe pom = prvi;
		
		while(pom.sledeci != null) {
			if(pom.podatak > pom.sledeci.podatak) {
				return false;
			}
			pom = pom.sledeci;
		}
		return true;
	}
	
	/**
	 * Metoda koja proverava da li je lista sortirana u rastucem redosledu - rekurzivno
	 * @param prvi pokazivac na prvi element liste
	 * @return true ako jeste sortirana u rastucem redosledu, false ako nije
	 */
	public boolean daLiJeSortiranaRastuceRekurzivno(CvorJSListe prvi) {
		
		if(prvi.sledeci == null) {
			return true;
		}
		
		if(prvi.podatak > prvi.sledeci.podatak) {
			return false;
		}
		
		return daLiJeSortiranaRastuceRekurzivno(prvi.sledeci);
		
	}
	
	/**
	 * Izbacuje najmanji element iz liste
	 * @return broj koji je izbacen
	 * @throws LabisException ako je lista prazna
	 */
	public int izbaciNajmanjiElement() throws LabisException {
		if(prvi == null) {
			throw new LabisException("Lista je prazna");
		}
		
		if(prvi.sledeci == null) {
			int br = prvi.podatak;
			prvi = null;
			return br;
		}
		
		CvorJSListe najmanji = prvi;
		CvorJSListe pom = prvi.sledeci;
		while(pom != null) {
			if(najmanji.podatak > pom.podatak) {
				najmanji = pom;
			}
			pom = pom.sledeci;
		}
		
		if(najmanji == prvi) {
			prvi = prvi.sledeci;
			return najmanji.podatak;
		}
		
		pom = prvi;
		while(pom.sledeci != najmanji) {
			pom = pom.sledeci;
		}
		pom.sledeci = najmanji.sledeci;
		return najmanji.podatak;
	}
	

	
}
