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
			
			
			//System.out.println(s.next().toLowerCase());
			
			while(s.hasNext()) {
				
				String newWord = s.next().toLowerCase();
				
				if(newWord.charAt(0) == '\"' 
						|| newWord.charAt(0) == '(') {
					newWord = newWord.substring(1); // remove first letter if punctuation
				} else if (newWord.charAt(newWord.length()-1) == '.' 
						|| newWord.charAt(newWord.length()-1) == ','
						|| newWord.charAt(newWord.length()-1) == '?'
						|| newWord.charAt(newWord.length()-1) == '!'
						|| newWord.charAt(newWord.length()-1) == '\"'
						|| newWord.charAt(newWord.length()-1) == ')') {
					
					newWord = newWord.substring(0,newWord.length() - 1); // remove last letter if punctuation
				}
				
				if(!uniqueList.contains(newWord)){
					
					uniqueList.add(newWord);
					count.add(1);
					
				} else {
					int indexToAdd = uniqueList.indexOf(newWord);
					
					count.add(indexToAdd, count.get(indexToAdd) + 1);
					count.remove(indexToAdd + 1);
					
					//count.remove(count.get(indexToAdd));
					//count.add(indexToAdd, count.get(indexToAdd) + 1);
					
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
	
	public ArrayList<String> getUList() {
		return uniqueList;
	}
}
