package test;

import java.util.ArrayList;
import java.util.Collections;

import bjAction.Card;
import bjAction.CardArray;

public class TestOneCard {

	public static void main(String[] args){
		
		CardArray cardArray = new CardArray();
		cardArray.make_card();
		
		ArrayList<Card> now_use_tramp = new ArrayList<Card>();
		now_use_tramp = cardArray.getAll_tramp();
		
		Collections.shuffle(now_use_tramp);
		
		for(Card val:now_use_tramp){
			System.out.println(val.getCard_all_info());
		}
	}
	
	
}
