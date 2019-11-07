package amicableN;
import java.util.ArrayList;

public class AmicableNumberFinder {
	
	private static int a = 220;
	private static int b = 284;
	
	private static ArrayList<Integer> checked = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 1; i < 10e6; i++) {
			int j = allFactors(i);
			if(allFactors(j) == i && !checked.contains(i) && !checked.contains(j) && i != j) {
				checked.add(i);
				checked.add(j);
				
				System.out.println(i + " " + j);
			}
		}
		
		
		

	}
	public static int allFactors(int a) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1; i < a/2 + 1; i++) {
			
			if(a%i == 0) {
				list.add((int)i);
			}
			
		} 
		//System.out.println(list);
		int sum = 0;
		for(int i = 0; i < list.size(); i++)
		    sum += list.get(i);
		return sum;
	}

}
