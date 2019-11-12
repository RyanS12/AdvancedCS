package elevensLab;

public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		
		Card card1 = new Card("1", "Spades", 1);
		Card card2 = new Card("2", "Heart", 2);
		Card card3 = new Card("3", "Diamonds", 3);
		
		
		System.out.println(card1.equals(card2));
		System.out.println(card1.getPointValue());
		System.out.println(card1.getRank());
		System.out.println(card1.getSuit());
		
		System.out.println();
		
		System.out.println(card2.equals(card2));
		System.out.println(card2.getPointValue());
		System.out.println(card2.getRank());
		System.out.println(card2.getSuit());
		
		System.out.println();
		
		System.out.println(card3.equals(card2));
		System.out.println(card3.getPointValue());
		System.out.println(card3.getRank());
		System.out.println(card3.getSuit());
		
		
		
	}
}
