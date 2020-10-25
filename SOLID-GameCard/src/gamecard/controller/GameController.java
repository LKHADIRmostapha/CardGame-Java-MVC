package gamecard.controller;

import java.util.ArrayList;

import gamecard.games.GameEvaluator;
import gamecard.model.*;
import gamecard.view.CommandLineView;
import gamecard.view.GameViewable;


public class GameController {
	
	enum GameState {
		AddingPlayers,
		CardsDealt,
		WinnerRevealed
	}
	
	Deck deck;
	ArrayList<Player> players;
	Player winner;
	GameViewable view;
	GameState gamestate;
	GameEvaluator gameEvaluator;
	
	public GameController(GameViewable view,Deck deck,GameEvaluator gameEvaluator) {
		this.view=view;
		this.deck = deck;
		players = new ArrayList<Player>();
		gamestate = GameState.AddingPlayers;
		view.setController(this);
		this.gameEvaluator =gameEvaluator;
	}
	
	public void run() {
		while (true ) {
			switch(gamestate) {
			case AddingPlayers :
				view.promptForPlayerName();
				break;
			case CardsDealt :
				view.promptForFlip();
				break;
			case WinnerRevealed:
				view.promptForNewGame();
				break;
			
			}
		}
	}
	
	
	public void addPlayer(String palayerName) {
		if(gamestate == GameState.AddingPlayers){
			players.add(new Player (palayerName));;
			view.showPlayerName(players.size(),palayerName);
		}
	}
	
	public void startGame() {
		if(gamestate != GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex =1;
			for(Player player :players) {
				player.addCardToHand(deck.removeTopCard());
				view.showFaceDownCardForPlayer(playerIndex++,player.getName());
			}
			gamestate = GameState.CardsDealt;
			
		}
	}
	public void flipCards() {
	int playerIndex =1;
	for(Player player :players) {
		PlayingCard pc = player.getCard(0);
		pc.flip();
		view.showCardForPlayer(playerIndex++,player.getName(),pc.getRank().toString(),pc.getSuit().toString());
	}
	
	evaluateWinner();
	displayWinner();
	rebuildDeck();
	gamestate = GameState.WinnerRevealed;
	}
	
	public void restartGame() {
		rebuildDeck();
		gamestate = GameState.AddingPlayers;
	}
	
	void evaluateWinner() {
		winner = gameEvaluator.evaluatWinner(players);
	}
	
	
	
	void displayWinner() {
		view.showWinner(winner.getName());
	}
	
	 void rebuildDeck() {
		for(Player player :players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}
}
	
	
	
	
