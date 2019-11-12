package elevensLab;
/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	
	static int[] values1 = {2,3,4,5,6,7,8,9,10,10,10,10,11};
	static int[] values2;
	static int[] values3;
	static String[] suits1 = {"spades","hearts","clubs","diamonds"};
	static String[] suits2;
	static String[] suits3;
	static String[] ranks1 = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	static String[] ranks2;
	static String[] ranks3;
	
	
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		Deck deck1 = new Deck(ranks1, suits1, values1);
		
		Deck deck2 = new Deck(ranks2, suits2, values2);
		Deck deck3 = new Deck(ranks3, suits3, values3);
		
		
	}
}
