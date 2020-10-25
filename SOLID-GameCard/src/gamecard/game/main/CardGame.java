package gamecard.game.main;

import gamecard.controller.GameController;
import gamecard.game.main.DeckFactory.DeckType;
import gamecard.games.GameEvaluator;
import gamecard.model.Deck;
import gamecard.view.CommandLineView;
import gamecard.view.GameSwing;

public class CardGame {

	public static void main(String[] args) {
		GameSwing gs =  new GameSwing();
		gs.createAndShowGUI();
		GameController gc = new GameController(gs, DeckFactory.makeDeck(DeckType.Small),new GameEvaluator());
		gc.run();
	}

}
