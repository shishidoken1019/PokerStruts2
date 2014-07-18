package test;

import java.util.ArrayList;

import bjAction.Card;
import bjAction.Player;

public class testClass {

	public static void main(String[] args){
		
//		Player aaa = testp();
//		System.out.print(aaa.getPlayer_money());
		
		testa();
	
		
	}
	
	public static Player testp(){
		Player player = new Player();
		return player;
	}
	
	public static void testa(){
		ArrayList list = new ArrayList();
		Player player = new Player();
		Card card = new Card();
		list.add(player);
		list.add(card);
	}
}
