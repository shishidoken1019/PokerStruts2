package test;

import java.util.ArrayList;
import java.util.Collections;

import bjAction.Card;
import bjAction.CardArray;
import bjAction.Player;
import bjAction.Utility;

public class TestOneCard {

	public static void main(String[] args){
		
		CardArray cardArray = new CardArray();
		cardArray.make_card();
		
		ArrayList<Card> now_use_tramp = new ArrayList<Card>();
		now_use_tramp = cardArray.getAll_tramp();
		
		Collections.shuffle(now_use_tramp);
		
		//
		Player p1 = new Player();
		Player p2 = new Player();
		Utility ut = new Utility();
		
		//配る
		cardArray.deal_tramp(now_use_tramp, 8, p1, p2);
		for(Card val:p1.getPlayer_card()){
			System.out.println(val.getCard_all_info());
		}
		ut.poker_skill_jadge(p1);
		
		
	}
	
	
}
