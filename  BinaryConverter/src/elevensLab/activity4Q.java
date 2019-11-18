package elevensLab;

import java.util.Arrays;

public class activity4Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 5; i++) {
			System.out.println(flip() + "\n");
		}

		int[] a = {0,1,2,3};
		int[] b = {2,3,1,0};
		
		System.out.println(arePermutations(a,b));
	}
	
	public static String flip() {
		
		int r = (int)(Math.random() * 3);
		if(r == 0) {
			return "tail";
		} else {
			return "head";
		}
		
	}
	
	public static boolean arePermutations(int[] a, int[] b) {
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] != b[i]) {
				return false;
			}
		}
		
		return true;
		
	}
}
