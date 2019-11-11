package harryPotterReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class WordCounter {
	public static void main(String[] args) throws FileNotFoundException {
		
		//readFile();
		
		File text = new File("harry_potter.txt");
		
		//UniqueWord uList = new UniqueWord(text);
		
		System.setOut(new PrintStream(new FileOutputStream("text.txt")));
		System.out.println("This is test output");
		
		System.out.println(new UniqueWord(text));
		
		
		
		
		
	}
	
	public static void readFile() {
		try {
			
			Scanner s = new Scanner(new File("harry_potter.txt"));
			System.out.println("file open");
			
			while(s.hasNext()) {
				String newWord = s.next();
				System.out.println(newWord);
			}
			s.close();
			
			
		} catch (Exception FileNotFoundException) {
			
			System.out.println("problem opening file");
			
		}
	}
}
