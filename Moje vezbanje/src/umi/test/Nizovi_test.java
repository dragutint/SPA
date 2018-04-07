package umi.test;

import labis.exception.LabisException;
import umi.main.Nizovi_sam;

public class Nizovi_test {

	public static void main(String[] args) throws LabisException {
		int[] a = new int[] {9,7,1,8,14,2,11};
		//int[] k = null;
		Nizovi_sam o = new Nizovi_sam();
		int[] b = new int[5];
		b[0] = 5;
		b[1] = 5;
		b[2] = 7;
		b[3] = 999;
		b[4] = 999;
		
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
		
		try {
			int p = o.treciNajveci(a);
			System.out.println(p);
		} catch (LabisException e) {
			System.out.println(e);
		}
	}
}
