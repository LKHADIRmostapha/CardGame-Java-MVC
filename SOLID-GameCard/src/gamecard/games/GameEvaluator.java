package gamecard.games;

import java.util.List;

import gamecard.model.Player;
import gamecard.model.PlayingCard;

public class GameEvaluator {
	
	public Player evaluatWinner(List<Player> players) {
	Player bestPlayer=null;
	int bestRank = -1;
	int bestSuit = -1 ;
	for(Player player :players) {
		boolean newBestPlayer = false ;
		if(bestPlayer==null){
			newBestPlayer = true;
		}
		else {
			PlayingCard pc = player.getCard(0);
			int thisRank = pc.getRank().Value();
			if(thisRank >= bestRank) {
				if(thisRank > bestRank){
					newBestPlayer = true;
				}else {
					if(pc.getSuit().Value()>bestSuit) {
						newBestPlayer = true;
					}
				}
			}
		}
		
		if(newBestPlayer) {
			bestPlayer = player;
			PlayingCard pc = player.getCard(0);
			bestRank = pc.getRank().Value();
			bestSuit = pc.getSuit().Value() ;
		}
		
	}
	return bestPlayer;
	}
}
