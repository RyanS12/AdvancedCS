package amicableN;

import java.util.ArrayList;

public class AmicableNumberFinder {
	
	//private static int a = 220;
	//private static int b = 284;
	
	private static ArrayList<Integer> checked = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long time = System.currentTimeMillis();
		System.out.println(allFactors(28 ));
		for(int i = 1; i < 10e5; i++) {
			int j = allFactors(i);
			if(allFactors(j) == i && !checked.contains(i) && !checked.contains(j) && i != j) {
				checked.add(i);
				checked.add(j);
				
				System.out.println(i + " " + j);
			}
		}
		
		System.out.println(checked);
		
		System.out.println("time to run in milisec");
		System.out.println(System.currentTimeMillis() - time);

	}
	public static int allFactors(int a) {
		
		int sum = 0;
		//int length = list.size();
		
		for(int i = 1; i <= (int)Math.sqrt(a); i++) {
			
			if(a%i == 0) {
				sum += (int)i;
				if(i != a/i) {
					sum += a/i;
				}
			}
			
		} 
		//System.out.println(list);
		return sum-a;
	}

}
