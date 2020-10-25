package gamecard.game.main;

import gamecard.model.Deck;
import gamecard.model.NormalDeck;
import gamecard.model.SmallDeck;
import gamecard.model.TestDeck;

public class DeckFactory {
	public enum DeckType{
		Normal,
		Small,
		Test;
	}
	
	public static Deck makeDeck(DeckType type) {
        switch (type) {
            case Normal: return new NormalDeck();
            case Small: return new SmallDeck();
            case Test: return new TestDeck();
        }
        
        // fallback
        return new NormalDeck();
	}

}
