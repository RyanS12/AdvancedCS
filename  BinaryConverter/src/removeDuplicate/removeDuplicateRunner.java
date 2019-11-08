package removeDuplicate;
import java.util.ArrayList;

public class removeDuplicateRunner {
	
	public static ArrayList<String> l = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		l.add("Carl");
		l.add("Chris");
		l.add("Chris");
		l.add("Cathy");
		l.add("Carl");
		l.add("Julian");
		l.add("Kartik");
		l.add("Ryan");
		l.add("Kartik");
		l.add("Sarah");
		
		
		
		System.out.println(removeDuplicates(l));
		
		
	}
	
	public static ArrayList<String> removeDuplicates(ArrayList<String> list) {
		ArrayList<String> happenedOnce = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++) {
			
			if(!happenedOnce.contains(list.get(i))) {
				happenedOnce.add(list.get(i));
			}
			
		}
		
		return happenedOnce;
		
		//System.out.println(happenedOnce);
	}

}
