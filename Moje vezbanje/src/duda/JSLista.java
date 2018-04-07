package duda;

import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.AJSLista;

public class JSLista extends AJSLista{
	// prikaz liste
	public void ispisiListu(CvorJSListe prvi) {
		if(prvi == null) {
			return;
		}
		
		CvorJSListe pom = prvi;
		while(pom != null) {
			System.out.print(pom.podatak + ", ");
			pom = pom.sledeci;
		}
	}
	
	// broj pozitivnih elemenata - rekurzivno
	public int pozitivniElementiRekurzivno(CvorJSListe prvi) throws LabisException {
		if(prvi == null) {
			return 0;
		}
		
		if( prvi.podatak > 0 ) {
			return 1 + pozitivniElementiRekurzivno(prvi.sledeci);
		} else {
			return pozitivniElementiRekurzivno(prvi.sledeci);
		}	
	}
	
	// metoda koja od JSListe pravi niz
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
	
	// metoda koja od dve JS liste pravi trecu i vraca je
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
	
	// metoda koja proverava da li postoji vrednost u JS listi
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
	
/*
 * Da li je lista sortirana u neopadajucem redosledu
	a) iterativno
	b) rekurzivno	
 */
	// iterativno
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
	
	//rekurzivno
	public boolean daLiJeSortiranaRastuceRekurzivno(CvorJSListe prvi) throws LabisException {
		
		if(prvi.sledeci == null) {
			return true;
		}
		
		if(prvi.podatak > prvi.sledeci.podatak) {
			return false;
		}
		
		return daLiJeSortiranaRastuceRekurzivno(prvi.sledeci);
		
	}
}
