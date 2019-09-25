import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class finalBinaryConverter {    
	public static final int MAX_BITS = 64;    
	public static final int LONG = 64;  
	public static final int INT = 32;    
	public static final int SHORT = 16;    
	public static final int BYTE = 8;    // Data Type Codes...    
	public static final int STRING_TYPE = 0;    
	public static final int INT_TYPE = 1;    
	public static final int FLOAT_TYPE = 2; 
	
	
	public static void main(String[] args) {        
		// TODO Auto-generated method stub        
		int dataType = -1;        
		Scanner s = null;        
		boolean allGood = false; 
		
		
		try {          
			s = new Scanner(new File("text.txt"));          
			//System.out.println("It's open");          
			allGood = true;   
			
			
			
		} catch( Exception e ) {            
			System.out.println("It's not open.  There is an issue opening your file.");        
		}   
		
		
		
		
		if(allGood) {            
			
			while(s != null && s.hasNextLine()) {     
				
				String nextNumIn = s.nextLine();     
				
				if(itsNotANumber(nextNumIn)) {                    
					//check for bad input                    
					System.out.println(nextNumIn + " is bad input");                    
					dataType = STRING_TYPE;                
				} else if (isADecimal(nextNumIn)) {                    //check for a decimal                    
						System.out.println(nextNumIn + " is a decimal");                    
						dataType = FLOAT_TYPE;                
				} else {                    
							//its an integer
                    System.out.println(nextNumIn + " is an integer");
                    dataType = INT_TYPE;
				}
	//now process the numbers....                
				if(dataType == INT_TYPE) {                    
					String binInt = "";                    
					try {                        
						long x = Long.parseLong(nextNumIn);                        
						//This is my conversion method...                        
						binInt = binConvertInt(x);                        
						System.out.println(binInt); 
						
					} catch (Exception e) {                        
						
						System.out.println(nextNumIn + " -- Number is too Large...");                            
						binInt = "" + nextNumIn + " is too big for Long";                    
					}                
				} else if(dataType == FLOAT_TYPE) {                    
						// Create the 32 bit float method.... 
					String binDouble = "";
					
					double x = Double.parseDouble(nextNumIn);
					
					binDouble = binConvertDec(x);
					System.out.println(binDouble);
					
					
				} else {                    
					// Strings??                	
				}
			
			}            
			s.close();        
		}    
	}    
	
	
	public static boolean itsNotANumber(String nextNumIn) {        
		boolean itsNotANumber = false;        
		String nonNums = "abcdefghijklmnopqrstuvwxyz!@#$%^&*()_+= {[}]|\\:;\"'<,>?/";        
		for(int l= 0; l < nonNums.length(); l++) {            
			if(nextNumIn.contains("" + nonNums.charAt(l))) {                
				itsNotANumber = true;            
			}        
		}        
		return itsNotANumber;    
	}    
	
	public static boolean isADecimal(String nextNumIn) {        
		boolean itsADecimal = false;        
		if(nextNumIn.contains(".")) {            
			itsADecimal = true;        
		}        
		return itsADecimal;    
	}    
	public static String binConvertInt(long num) {       
		//This is your code for binary byte, short, int and long conversion        
		String binString = "";        
		//Your code here.... 
		
		
		boolean isNeg = false;
		
		if(num < (Math.pow(2, 63) * -1) - 1 || num > Math.pow(2, 63) - 1) {
			System.out.print("overflow");
		}
		
		if(num == -9223372036854775808l) {
			
			return "1000000000000000000000000000000000000000000000000000000000000000";
			
		}
		if(num == 9223372036854775807l) {
			
			return "0111111111111111111111111111111111111111111111111111111111111111";
			
		}
		
		
		
		if(num < 0) {
			isNeg = true;
			num *= -1;
			//System.out.print("-");
			
		}
		
		
		//determine the size of the number, byte short int long
		
		int[] sizes = {8, 16, 32, 64, 64};
		
		int myBitSize = 7;
		
		for(int i = 0; i < 4; i++) {
			
			
			if(num > Math.pow(2, sizes[i] - 1)) {
				
				myBitSize = sizes[i + 1] - 1;
				
				
				
			}
			
			
		}
		

		

		if(isNeg) {
			
			num --;
			
			
			for(int i = myBitSize; i >= 0; i--) {
				
				if((long)(Math.pow(2.0, (double)i)) <= num) {
						
					num -= Math.pow(2.0, (double)i);
					binString = binString + "0";
						
				} else {
					binString = binString + "1";
				}
					
				
			}
			
			
			return binString;
			
			
			
			
		} else {
			
			
			for(int i = myBitSize; i >= 0; i--) {
				
				if((long)(Math.pow(2.0, (double)i)) <= num) {
						
					num -= Math.pow(2.0, (double)i);
					binString = binString + "1";
						
				} else {
					
					binString = binString + "0";
					
				}
					
					
					
			}
			
		}
		
		
		return binString;
	   
	}
	
	
	
	public static String binConvertDec(double num) {
		
String binString = "";
		
		boolean isNeg = false;
		boolean isInt = false;
		
		if(num == (int) num) {
			isInt = true;
		}
		
		if(num < (Math.pow(2, 63) * -1) - 1 || num > Math.pow(2, 63) - 1) {
			System.out.print("overflow");
		}
		
		
		
		
		if(num < 0) {
			isNeg = true;
			num *= -1;
			//System.out.print("-");
			
		}
		
		
		//determine the size of the number, byte short int long
		
		int[] sizes = {8, 16, 32, 64, 64};
		
		int myBitSize = 7;
		
		for(int i = 0; i < 4; i++) {
			
			
			if(num > Math.pow(2, sizes[i] - 1)) {
				
				myBitSize = sizes[i + 1] - 1;
				
				
				
			}
			
			
		}
		
		//System.out.println((long)(Math.pow(2.0, 63.0)));

		//System.out.println(myBitSize + "\n");
		
		String binStringDec = "";
		String binStringInt = "";

		

			
			
		for(int i = 1; i < 25; i++) {
				
			if((Math.pow(2.0, -(double)i)) <= num % 1) {
						
				num -= Math.pow(2.0, -(double)i);
				binStringDec = binStringDec + "1";
						
			} else {
					
				binStringDec = binStringDec + "0";
					
			}
					
					
					
		}
			
			
		for(int i = myBitSize; i >= 0; i--) {
				
			if((long)(Math.pow(2.0, (double)i)) <= num) {
						
				num -= Math.pow(2.0, (double)i);
				binStringInt = binStringInt + "1";
						
			} else {
					
				binStringInt = binStringInt + "0";
					
			}
					
					
					
		}
			
		binString = binStringInt + "." + binStringDec;
			
		
		
		if(isInt) {
			return binStringInt;
		}
		
		
		if(isInt == false) {
			
		
		// integer part.decimal part
		
			int newPointLoc = 0;
			int oldPointLoc = 0;
			
			for(int i = 0; i < 1000; i++) {
				if(binString.charAt(i) == '.') {
					oldPointLoc = i;
					binString = binString.substring(0, i) + binString.substring(i + 1);
					break;
				}
			}
			
			for(int i = 0; i < 1000; i++) {
				
				if(binString.charAt(i) == '1') {
					binString = binString.substring(i, i+1) + "." + binString.substring(i+1);
					newPointLoc = i + 1;
					
					break;
				}
			}
			
			
			String sciNot = binString + "e" + Integer.toString(oldPointLoc - newPointLoc);
			
			//scientific notation part
			
			String IEEE = "";
			
			int exponent = oldPointLoc - newPointLoc;
			
			//System.out.println(sciNot);
			
			if(isNeg == true) {
				IEEE = "1" + IEEE;
			} else {
				IEEE = "0" + IEEE;
			}
			
			for(int i = 7; i >= 0; i--) {
				
				if((Math.pow(2.0, (double)i)) <= exponent + 127) {
						
					exponent -= Math.pow(2.0, (double)i);
					IEEE = IEEE + "1";
						
				} else {
					
					IEEE = IEEE + "0";
					
				}
					
			}
			
			
			
			IEEE = IEEE + binString.substring(2);
			
			//3.45189
			if(IEEE.length() > 32) {
				IEEE = IEEE.substring(0, 31);
			}
			
			
			//System.out.println(IEEE.length());
			
			
			for(int i = 0; i < (32 - IEEE.length()); i++) {
				IEEE = IEEE + "0";
			}
			
			//System.out.println(32 - IEEE.length());

		
			return IEEE;
		
		}
		

		
		return binString;
		
		
		
		
		
		
		
	}


}
