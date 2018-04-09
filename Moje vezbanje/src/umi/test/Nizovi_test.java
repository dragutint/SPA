package umi.test;

import labis.exception.LabisException;
import umi.main.Nizovi_sam;

public class Nizovi_test {

	public static void main(String[] args) throws LabisException {
		int[] a = new int[] {1,3,5,7,9,10,11,13};
		//int[] k = null;
		Nizovi_sam o = new Nizovi_sam();
		int[] b = new int[] {2,4,6,8,8,12,14,15};

		
		//try {
		//	o.zzv10(a);
		//} catch (LabisException e) {
		//	System.out.println(e);
		//}
		
		//try {
		//	o.zzv18(a);
		//} catch (LabisException e) {
		//	System.out.println(e);
		//}
		
//		int[] novi = o.zzv22(a, b);
//		for(int i = 0; i<novi.length; i++) {
//			System.out.println(novi[i]);
//		}
		
//		try {
//			int p = o.treciNajveci(a);
//			System.out.println(p);
//		} catch (LabisException e) {
//			System.out.println(e);
//		}
		
		int[] novi = o.odDvaRastucaNoviOpadajuci(a, b);
		for(int i = 0; i<novi.length; i++) {
			System.out.println(novi[i]);
		}
		
	}
}
