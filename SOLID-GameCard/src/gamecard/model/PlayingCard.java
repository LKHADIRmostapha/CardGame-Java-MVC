package gamecard.model;

public class PlayingCard {
	Rank rank;
	Suit suit;
	boolean faceUp;
	
	
	public PlayingCard(Rank rank,Suit suit) {
		this.rank = rank;
		this.suit = suit;
		faceUp = false;
	}
	
	public Rank getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit ;
	}
	public boolean isFaceUp() {
		return faceUp;
	}
	
	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}
}
