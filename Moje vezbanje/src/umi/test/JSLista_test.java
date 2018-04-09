package umi.test;

import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.AJSLista;
import labis.test.ListGenerator;
import umi.main.JSLista_vezbanje;

public class JSLista_test extends ListGenerator{

	public static void main(String[] args) {
		
		int[] niz = new int[] {1,2,3,3,3,3,3,3,4,4,4,5,5,5,1,1,1,2,2,2,};	
		AJSLista lista = new AJSLista() {
		};
		ListGenerator.napraviJSListuCommon(lista, niz, false);
		
		CvorJSListe a;
		
		JSLista_vezbanje o = new JSLista_vezbanje();
		ListGenerator.ispisiJSListu(lista.prvi);
		
//		try {
//			int k = o.vratiNajduzuNeopadajucuPodlistu(lista.prvi);
//			System.out.println(k);
//			
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
		
//		try {
//			a = o.izbaci2i3odpozadi(lista.prvi);
//			System.out.println("________________");
//			ListGenerator.ispisiJSListu(a);
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
//		try {
//			double b = o.prosekParnih(lista.prvi);
//			System.out.println("________________");
//			System.out.println(b);
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		

//		try {
//			a = o.noviPrePrvog(lista.prvi, 4);
//			System.out.println("________________");
//			ListGenerator.ispisiJSListu(a);
//
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
//		try {
//			a = o.invertovanjeBezPomocne(lista.prvi);
//			System.out.println("________________");
//			ListGenerator.ispisiJSListu(a);
//
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
//		try {
//			a = o.invertovanjeSaPomocnom(lista.prvi);
//			System.out.println("________________");
//			ListGenerator.ispisiJSListu(a);
//
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
//		System.out.println(o.nadjiElementRekurzijom(lista.prvi, 4));
		
//		System.out.println(o.daLiJeSortiranaRastuce(lista.prvi));
		
//		a = o.klonirajListuRekurzivno(lista.prvi);
//		System.out.println("__________");
//		ListGenerator.ispisiJSListu(a);
		
		int k;
//		try {
//			k = o.prosekParnihCiklicna(lista.prvi);
//			System.out.println(k);
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
//		try {
//			a = o.izbaciVece(lista.prvi);
//			System.out.println("__________");
//			ListGenerator.ispisiJSListu(a);
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
//		try {
//			a = o.ubaciKumulativ(lista.prvi, 0);
//			System.out.println("__________");
//			ListGenerator.ispisiJSListu(a);
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
//		try {
//			a = o.izbaciDuplikate(lista.prvi);
//			System.out.println("__________");
//			ListGenerator.ispisiJSListu(a);
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
		try {
			a = o.invertujBezDupkiata(lista.prvi);
			System.out.println("__________");
			ListGenerator.ispisiJSListu(a);
		} catch (LabisException e) {
			System.out.println(e);
		}
		
	}
}
