package morseCode;/**

 * Encodes messages in Morse code using a map and
 * decodes messages using a "decoding tree" in the
 * Morse Code program.
 */
 
import java.util.Stack;
import java.util.TreeMap;

public class MorseCode
{
  private static final char DOT = '.';
  private static final char DASH = '-';

  private static TreeMap<Character, String> codeMap;
  private static TreeNode decodeTree;

  public static void start()
  {
    codeMap = new TreeMap<Character, String>();
    decodeTree = new TreeNode(' ', null, null);  // autoboxing
          // put a space in the root of the decoding tree

    addSymbol('A', ".-");
    addSymbol('B', "-...");
    addSymbol('C', "-.-.");
    addSymbol('D', "-..");
    addSymbol('E', ".");
    addSymbol('F', "..-.");
    addSymbol('G', "--.");
    addSymbol('H', "....");
    addSymbol('I', "..");
    addSymbol('J', ".---");
    addSymbol('K', "-.-");
    addSymbol('L', ".-..");
    addSymbol('M', "--");
    addSymbol('N', "-.");
    addSymbol('O', "---");
    addSymbol('P', ".--.");
    addSymbol('Q', "--.-");
    addSymbol('R', ".-.");
    addSymbol('S', "...");
    addSymbol('T', "-");
    addSymbol('U', "..-");
    addSymbol('V', "...-");
    addSymbol('W', ".--");
    addSymbol('X', "-..-");
    addSymbol('Y', "-.--");
    addSymbol('Z', "--..");
    addSymbol('0', "-----");
    addSymbol('1', ".----");
    addSymbol('2', "..---");
    addSymbol('3', "...--");
    addSymbol('4', "....-");
    addSymbol('5', ".....");
    addSymbol('6', "-....");
    addSymbol('7', "--...");
    addSymbol('8', "---..");
    addSymbol('9', "----.");
    addSymbol('.', ".-.-.-");
    addSymbol(',', "--..--");
    addSymbol('?', "..--..");
  }

  /**
   * Inserts a letter and its Morse code string into the encoding map
   * and calls treeInsert to insert them into the decoding tree.
   */
  private static void addSymbol(char letter, String code)
  {
	codeMap.put(letter, code);
	treeInsert(letter, code);
  }
  
  /**
   * Inserts a letter and its Morse code string into the
   * decoding tree.  Each dot-dash string corresponds to a path
   * in the tree from the root to a node: at a "dot" go left, at a "dash" go
   * right.  The node at the end of the path holds the symbol
   * for that code string.
   */
  private static void treeInsert(char letter, String code)
  {
	  TreeNode temp = decodeTree;
	  for(int i = 0; i < code.length(); i++) {
		  char c = code.charAt(i);
		  if(c == '-') { 
			  if(temp.getRight() == null) {
				  temp.setRight(new TreeNode(c));
			  }
			  temp = temp.getRight();
			  
		  
		  } else {
			  if(temp.getLeft() == null) {
				  temp.setLeft(new TreeNode(c));
			  }
			  temp = temp.getLeft();
		  }
	  }
	  temp.setValue(letter);
  }

  /**
   * Converts text into a Morse code message.  Adds a space after a dot-dash
   * sequence for each letter.  Other spaces in the text are transferred directly
   * into the encoded message.
   * Returns the encoded message.
   */
  private static boolean traversePreorder (TreeNode root, char letter, Stack<Character> stack) {
	  
	  if(root==null) 
		  return false;
	  if(root.getValue() != (Object)letter){
		  return true;
	  }
	  
	  stack.push('.');
	  if(traversePreorder(root.getLeft(), letter, stack)) 
		  return true;
	  stack.pop();
	  stack.push('-');
	  if(traversePreorder(root.getRight(), letter, stack))
		  return true; 
	  stack.pop();
	  return false;
  }
  
  public static String encode(String text)
  {
    StringBuffer morse = new StringBuffer(400);
    
    TreeNode temp = decodeTree;
    for(int i = 0; i < text.length(); i++) {
    	char c = text.charAt(i);
    	Stack<Character> a = new Stack<Character>();
    	traversePreorder(decodeTree, c, a);
    	Stack<Character> tempStack = new Stack<Character>();
    	while(!a.empty()) {
    		tempStack.push(a.pop());
    	}
    	while(!tempStack.isEmpty())
    		morse.append(tempStack.pop());
    }
    return morse.toString();
  }

  /**
   * Converts a Morse code message into a text string.  Assumes that dot-dash
   * sequences for each letter are separated by one space.  Additional spaces are
   * transferred directly into text.
   * Returns the plain text message.
   */
  public static String decode(String morse)
  {
    StringBuffer text = new StringBuffer(100);
    
    TreeNode temp = decodeTree;
    for(int i = 0; i < morse.length(); i++) {
    	
    	if(temp == null)
    		throw new IllegalArgumentException();
    	if(morse.charAt(i) == '.') {
    		temp = temp.getLeft();
    	}
    	if(morse.charAt(i) == '-') {
    		temp = temp.getRight();
    	}
    	if((morse.charAt(i) == ' ' && temp!=decodeTree) || i == morse.length()-1) {
    		text.append(temp.getValue());
    		temp = decodeTree;
    	} else if(morse.charAt(i) == ' ') {
    		text.append(' ');
    	}
    }
    
    return text.toString();
  }
}
