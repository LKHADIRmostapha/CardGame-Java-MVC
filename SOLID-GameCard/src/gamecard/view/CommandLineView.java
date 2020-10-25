package gamecard.view;

import java.util.Scanner;

import gamecard.controller.GameController;

public class CommandLineView implements GameViewable{
	
	GameController controller;
	Scanner keyboard = new Scanner(System.in);
	
	public  void setController(GameController gc) {
		this.controller=gc;
	}
	public void promptForPlayerName() {
		System.out.println("enter player name");
		String name = keyboard.nextLine();
		if (name.isEmpty()) {
			controller.startGame();
		}else {
			controller.addPlayer(name);
		}
	}
	
	public void promptForFlip() {
		System.out.println("press enter to reveal cards");
		keyboard.nextLine();
		controller.flipCards();
	}
	public void promptForNewGame() {
		System.out.println("press enter to deal again");
		keyboard.nextLine();
		controller.startGame();
	}
	
    public void showPlayerName(int playerIndex, String name) {
    	System.out.println("["+playerIndex+"]["+name+"]");
    }
    public void showFaceDownCardForPlayer(int playerIndex, String name) {
    	System.out.println("["+name+"][][]");
    }
    public void showCardForPlayer(int playerIndex, String name, String rank, String suit){
    	System.out.println("["+name+"]["+rank+"]["+suit+"]");
    }
	public void showWinner (String winnerName){
		System.out.println("Winner! : "+ winnerName);
	}
}
