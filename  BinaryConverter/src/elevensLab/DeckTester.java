package elevensLab;

import java.util.ArrayList;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"jack", "queen", "king"};
		String[] suits = {"blue", "red"};
		int[] pointValues = {11, 12, 13};
		Deck d = new Deck(ranks, suits, pointValues);

		System.out.println("**** Original Deck Methods ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After 1 Card Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal Remaining 5 Cards ****");
		for (int i = 0; i < 5; i++) {
			System.out.println("  deal: " + d.deal());
		}
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After All Cards Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card From Empty Deck ****");
	//	System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		/* *** TO BE COMPLETED IN ACTIVITY 4 *** */
		d.shuffle();
		
		System.out.println("shuffle : " + d.toString());
		
		System.out.println();
		System.out.println();
		
		String[] rankReal = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		String[] suitReal = {"spades","hearts","clubs","diamonds"};
		int[] pointValueReal = {2,3,4,5,6,7,8,9,10,10,10,10,11};
		Deck deck = new Deck(rankReal, suitReal, pointValueReal);
		
		System.out.println(deck.toString());
	}
}
