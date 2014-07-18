package bjAction;

import java.util.ArrayList;

import bjAction.Player;

/**
 * カードの情報を持っているクラス
 * @author Admin
 *
 */
public class CardArray {

	/**
	 * 全てのトランプ
	 */
	private ArrayList<Card> All_tramp = new ArrayList<Card>();
	
	/**
	 * 現在使っているトランプ
	 */
	private ArrayList<Card> now_use_tramp = new ArrayList<Card>();

	/**
	 * cardを作る
	 */
	public void make_card(){
		int key = 0;

		// カードを定義する
		for (int i = 1; i < 14; i++) {
			//ハートのカード
			Card card = new Card("H:" + i);
			this.All_tramp.add(card);
			key++;
			
			//ダイヤのカード
			Card card2 = new Card("D:" + i);
			this.All_tramp.add(card2);
			key++;
			
			//スペードのカード
			Card card3 = new Card("S:" + i);
			this.All_tramp.add(card3);
			key++;
			
			//クローバーのカード
			Card card4 = new Card("C:" + i);
			this.All_tramp.add(card4);
			key++;
		}	
	}

	/**
	 * トランプを配る二人用（山のトランプ、一人に対して配る枚数,プレイヤー1、プレイヤー2）
	 */
	public ArrayList<Card> deal_tramp(ArrayList<Card> now_use_tramp,
			int deal_tramp_count, Player player1, Player player2) {

		// 配る枚数分まわす
		for (int i = 0; i < deal_tramp_count; i++) {
			// それぞれに配る
			now_use_tramp = player1.hit(now_use_tramp);
			now_use_tramp = player2.hit(now_use_tramp);
		}
		return now_use_tramp;
	}

	/**
	 * 表示用の配列に変換
	 * 
	 * @param array_card
	 *            (表示させたいカードの配列)
	 * @return 変換した表示させたいカードの配列
	 */
	public ArrayList<String> display_card(ArrayList<Card> array_card) {

		ArrayList<String> disp_card = new ArrayList<String>();

		// 変換する
		for (Card val : array_card) {
			String[] pieces;

			// マークと数字にわける
			pieces = val.getCard_all_info().split(":");

			// マークを変換
			String mark = "";
			switch (pieces[0]) {
			case "H":
				mark = "♥";
				break;
			case "D":
				mark = "♦";
				break;
			case "S":
				mark = "♠";
				break;
			case "C":
				mark = "♣";
				break;
			}

			// 数字部分を変換
			switch (pieces[1]) {
			case "11":
				pieces[1] = "J";
				break;
			case "12":
				pieces[1] = "Q";
				break;
			case "13":
				pieces[1] = "K";
				break;
			case "1":
				pieces[1] = "A";
				break;
			}
			// 元の形に戻して
			disp_card.add(mark + ":" + pieces[1]);
		}

		return disp_card;
	}

	/**
	 * @return all_tramp
	 */
	public ArrayList<Card> getAll_tramp() {
		return All_tramp;
	}

	/**
	 * @param all_tramp
	 *            セットする all_tramp
	 */
	public void setAll_tramp(ArrayList<Card> all_tramp) {
		All_tramp = all_tramp;
	}

	/**
	 * @return now_use_tramp
	 */
	public ArrayList<Card> getNow_use_tramp() {
		return now_use_tramp;
	}

	/**
	 * @param now_use_tramp セットする now_use_tramp
	 */
	public void setNow_use_tramp(ArrayList<Card> now_use_tramp) {
		this.now_use_tramp = now_use_tramp;
	}

	
}