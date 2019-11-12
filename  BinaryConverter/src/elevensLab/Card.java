package elevensLab;

public class Card {
	
	private String rank;
	private String suit;
	private int pointValue;
	
	public Card(String r, String s, int pV) {
		rank = r;
		suit = s;
		pointValue = pV;
	}
	
	public String getRank() {
		return this.rank;
	}
	
	public String getSuit() {
		return this.suit;
		
	}
	
	public int getPointValue() {
		return this.pointValue;
	}
	
	public boolean matches(Card c) {
		return this.rank == c.rank && this.suit == c.suit && this.pointValue == c.pointValue;
			
	}
	
	@Override
	public String toString() {
		return rank + " of " + suit + " (point value : " + pointValue + ")";
	}

}
