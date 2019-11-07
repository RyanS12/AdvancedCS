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
		
		removeDuplicates(l);
		
		System.out.println(l);
		
		
	}
	
	public static void removeDuplicates(ArrayList<String> list) {
		for(int i = 0;i < list.size(); i++) {
			for(int j = 0; j < list.size(); j++) {
				if(i!=j && list.get(i) == list.get(j)) {
					list.remove(j);
				}
			}
			
		}
	}

}
