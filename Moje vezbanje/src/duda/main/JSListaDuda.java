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
			System.out.print(pom.podatak + " ");
			pom = pom.sledeci;
		}
		System.out.println();
	}
	
	/**
	 * Prikazuje listu
	 * @param prvi pokazivac na prvi element liste
	 */
	public static void ispisiListu(CvorJSListe prvi) {
		if(prvi == null) {
			return;
		}
		
		CvorJSListe pom = prvi;
		while(pom != null) {
			System.out.print(pom.podatak + " ");
			pom = pom.sledeci;
		}
		System.out.println();
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
	public static boolean daLiPostoji(CvorJSListe prvi, int br) {
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

	/**
	 * Metoda koja vraca broj ponavljanja zadate vrednosti u listi
	 * @param prvi pokazivac na prvi element u listi
	 * @param br broj za proveru
	 * @return broj ponavljana zadate vrednosti u listi
	 */
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
	
	/**
	 * Metoda koja broji koliko ima elemenata u listi koji su veci od prvog elementa
	 * @param prvi pokazivac na prvi element u listi
	 * @return koliko ih ima
	 * @throws LabisException ako je lista prazna
	 */
	public int prebrojVeceOdPrvog(CvorJSListe prvi) throws LabisException {
		if(prvi == null) 
			throw new LabisException("Lista je prazna");
		
		int brojac = 0;
		CvorJSListe pom = prvi.sledeci;
		while(pom != null) {
			if(pom.podatak > prvi.podatak) 
				brojac++;
			pom = pom.sledeci;
		}
		return brojac;
	}
	
	/**
	 * Metoda koja izbacuje element nakon najmanjeg elementa u listi
	 * @param prvi pokazivac na prvi element u listi
	 * @return broj koji je izbacen
	 * @throws LabisException ako je lista prazna ili ima samo jedan element
	 */
	public int izbaciElementNakonMinimuma(CvorJSListe prvi) throws LabisException {
		if(prvi == null || prvi.sledeci == null) 
			throw new LabisException("Lista je prazna ili ima samo jedan element u njoj");
		
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
	
	/**
	 * Metoda koja klonira listu rekurzivno - pravi novu listu istu kao onu koja je prosledjena
	 * @param prvi pokazivac na prvi element liste
	 * @return nova lista koja je ista kao i ona koja je prosledjena
	 */
	public CvorJSListe klonirajRekurzivno(CvorJSListe prvi) {
		if(prvi == null) 
			return null;
		
		CvorJSListe novaLista = new CvorJSListe(prvi.podatak, klonirajRekurzivno(prvi.sledeci));
		
		return novaLista;
	}
	
	/**
	 * Metoda koja invertuje listu koristeci pomocne strukture, funkcionise tako sto pravi novu listu dodavanjem na pocetak liste 
	 * @throws LabisException ako je lista prazna
	 */
	public void invertujSaPomocnom() throws LabisException {
		if(prvi == null) {
			throw new LabisException("Lista je prazna");
		}
		
		CvorJSListe pom = prvi;
		CvorJSListe novaLista = null;
		while(pom != null) {
			novaLista = new CvorJSListe(pom.podatak, novaLista);
			pom = pom.sledeci;
		}
		prvi = novaLista;
	}
	
	/**
	 * Metoda koja invertuje listu bez koriscenja pomocnih struktura, koristi se samo pokazivac na neki element
	 * @throws LabisException ako je lista prazna
	 */
	public void invertujBezPomocne() throws LabisException {
		if(prvi == null || prvi.sledeci == null) {
			throw new LabisException("Lista je prazna");
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
	
	/**
	 * Metoda koja izbacuje element iz JS liste na koji je dat pokazivac
	 * @param element pokazivac na element za izbacivanje
	 * @throws LabisException ako element ne postoji ili ako je lista prazna
	 */
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

	/**
	 * Metoda koja proverava da li neki broj postoji u listi - iterativnim prolazom
	 * @param broj broj za proveru
	 * @return true ako postoji, false ako ne postoji
	 */
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
	/**
	 * Metoda koja proverava da li neki broj postoji u listi - rekurzivnim prolazom
	 * @param prvi pokazivac na prvi element liste
	 * @param broj broj za proveru
	 * @return true ako postoji, false ako ne postoji
	 */
	public boolean daLiPostojiRekurzivno(CvorJSListe prvi, int broj) {
		if(prvi.podatak == broj) 
			return true;
		
		if(prvi.sledeci == null) 
			return false;
		
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
	
	/**
	 * Metoda koja trazi najduzu rastucu podlistu i vraca njenu duzinu
	 * @return duzinu najduze rastuce podliste
	 * @throws LabisException ako je lista prazna
	 */
	public int duzinaNajduzeRastucePodliste() throws LabisException {
		if(prvi == null) {
			throw new LabisException("Lista je prazna");
		}
		int duzina = 1;
		int najduzaDuzina = 0;
		
		CvorJSListe pom = prvi;
		while(pom.sledeci != null) {
			if( pom.podatak <= pom.sledeci.podatak) {
				duzina++;
			} else {
				if(duzina > najduzaDuzina) {
					najduzaDuzina = duzina;
				}
				duzina = 1;
			}
			pom = pom.sledeci;
		}
		return najduzaDuzina;
	}
	
	/**
	 * Metoda koja spaja dve liste u jednu unakrsno
	 * @param prva pokazivac na prvi element prve liste
	 * @param druga pokazivac na prvi element druge liste
	 * @return pokazivac na prvi element nove liste
	 * @throws LabisException ukoliko su lose unete liste ili nisu iste duzine
	 */
	public CvorJSListe spojiDveListeIsteDuzineUnakrsno(CvorJSListe prva, CvorJSListe druga) throws LabisException {
		CvorJSListe novaLista = null;
		if(prva == null || druga == null) 
			throw new LabisException();
		
		int brojac1 = 0, brojac2 = 0;
		CvorJSListe pom1 = prva, pom2 = druga;

		while(pom1 != null) {
			brojac1++;
			pom1 = pom1.sledeci;
		}
		while(pom2 != null) {
			brojac2++;
			pom2 = pom2.sledeci;
		}
		if(brojac1 != brojac2) 
			throw new LabisException("Liste nisu iste duzine");
		
		pom1 = prva;
		pom2 = druga;
		int brojZaUnos;
		int brojac = 0;
		while(pom1 != null || pom2 != null) {
			if(brojac % 2 == 0) {
				brojZaUnos = pom1.podatak;
				pom1 = pom1.sledeci;
			} else {
				brojZaUnos = pom2.podatak;
				pom2 = pom2.sledeci;
			}
			brojac++;
			// ubaci na kraj treba a ne na pocetak
			novaLista = new CvorJSListe(brojZaUnos, novaLista);
		}
		return novaLista;
	}
	
	/**
	 * Metoda koja izbacuje drugi i treci element od pozadi iz liste
	 * @throws LabisException ako je lista prazna, ima samo jedan element ili ima samo dva elementa
	 */
	public void izbaciDrugiITreciOdPozadi() throws LabisException {		
		if (prvi == null) {
			throw new LabisException("Lista je prazna");
		}
		if (prvi.sledeci == null) {
			throw new LabisException("U listi ima samo 1 element");
		}
		if (prvi.sledeci.sledeci == null) {
			throw new LabisException("U listi ima samo 2 elementa");
		}
		if (prvi.sledeci.sledeci.sledeci == null) {
			prvi = prvi.sledeci.sledeci;
			return;
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
	}
	
	//Simetricna razlika dve JS liste(unija bez preseka)
	//Primer: 1 2 3 4 5 i 3 4 5 6 -> 1 2 6
	/**
	 * Metoda koja generise novu listu koja predstavlja simetricnu razliku dve liste
	 * @param prva pokazivac na prvi element prve liste
	 * @param druga pokazivac na prvi element druge liste
	 * @return pokazivac na prvi element liste koja predstavlja simetricnu razliku prve i druge liste
	 * @throws LabisException ukoliko su liste prazne
	 */
	public static CvorJSListe simetricnaRazlikaDveJSListe(CvorJSListe prva, CvorJSListe druga) throws LabisException {
		if(prva == null && druga == null) {
			throw new LabisException("Liste su prazne");
		}
		
		CvorJSListe novaLista = null;
		CvorJSListe pom = prva;
		while(pom != null) {
			if( !daLiPostoji(druga, pom.podatak) ) {
				novaLista = new CvorJSListe(pom.podatak, novaLista);
			}
			pom = pom.sledeci;
		}
		pom = druga;
		while(pom != null) {
			if( !daLiPostoji(prva, pom.podatak) ) {
				novaLista = new CvorJSListe(pom.podatak, novaLista);
			}
			pom = pom.sledeci;
		}
		return novaLista;
	}
	
	/**
	 * Metoda koja izbacuje duplikate iz JS liste
	 * @throws LabisException ako lista ne postoji 
	 */
//	public void izbaciDuplikateIzListe() throws LabisException {
//		if(prvi == null) 
//			throw new LabisException("Lista ne postoji");
//		
//<<<<<<< HEAD
//		if(prvi.sledeci == null) {
//			System.out.println("Lista ima samo jedan element");
//			return;
//		}
//			
//=======
//		if(prvi.sledeci == null) 
//			throw new LabisException("Lista ima samo jedan element");
//		
//>>>>>>> branch 'master' of https://github.com/duda973/SPA.git
//		CvorJSListe spori = prvi;
//		CvorJSListe brzi;
//		
//		while(spori.sledeci != null) {
//			brzi = spori.sledeci;
//			while( brzi != null && brzi.sledeci != null) {
//				if(brzi.sledeci.podatak == spori.podatak) {
//					brzi.sledeci = brzi.sledeci.sledeci;
//				}
//				brzi = brzi.sledeci;
//			}
//			spori = spori.sledeci;
//		}
//	}
	
	/**
	 * Metoda koja izracunava i vraca aritmeticku sredinu liste
	 * @return iznos aritmeticke sredine liste
	 * @throws LabisException ako je lista prazna
	 */
	public double aritmetickaSredina() throws LabisException {
		if(prvi == null) {
			throw new LabisException("Lista je prazna");
		}
		
		int suma = 0;
		int brojac = 0;
	
		CvorJSListe pom = prvi;
		while(pom != null) {
			suma += pom.podatak;
			brojac++;
			pom = pom.sledeci;
		}
		return (double)suma / brojac;
	}
	
	
	/**
	 * Metoda koja povecava parne elemente na neparnim pozicijama za iznos aritmeticke sredine liste
	 * @throws LabisException
	 */
	public void povecajParneNaNeparnimZaAritmetickuSredinu() throws LabisException {
		if(prvi == null) 
			throw new LabisException("Lista je prazna");
		
		CvorJSListe pom = prvi;
		int sredina = (int) aritmetickaSredina();
		
		while(pom != null) {
			if( pom.podatak % 2 == 0)
				pom.podatak += sredina;
			
			if(pom.sledeci == null) 
				break;
			
			pom = pom.sledeci.sledeci;
		}
	}

	
}
