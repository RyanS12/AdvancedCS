package harryPotterReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UniqueWord {
	
	private ArrayList<String> uniqueList = new ArrayList<String>();
	
	private ArrayList<Integer> count = new ArrayList<Integer>();
	
	
	public UniqueWord(File f) {
		
		try {
			
			Scanner s = new Scanner(f);
			System.out.println("file open");
			
			while(s.hasNext()) {
				
				String newWord = stripCharacters(s.next().toLowerCase());
				
				if(!uniqueList.contains(newWord)){
					
					uniqueList.add(newWord);
					count.add(1);
					
				} else {
					int indexToAdd = uniqueList.indexOf(newWord);
					
					count.set(indexToAdd, count.get(indexToAdd) + 1);
					
					
				}
				
			}
			s.close();
			for(int i = 0; i < uniqueList.size(); i++) {
				System.out.println(uniqueList.get(i) + " : " + count.get(i));
			}
	
		} catch (Exception FileNotFoundException) {
			System.out.println("problem opening file");
		}	
	}
	
	public String stripCharacters(String s) {
		
		s = s.trim();
		s = s.replaceAll("[^a-zA-Z ]", "");
		
		return s;
	}
}
