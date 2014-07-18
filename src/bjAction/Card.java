package bjAction;

import java.util.ArrayList;

import bjAction.Player;

/**
 * 1カードの情報を持っているクラス
 * @author Admin
 *
 */

public class Card {

	/**
	 * カードの（マークと数字）情報
	 */
	String card_all_info;
	String card_mark;
	int card_number;
	
	public Card(String card_all_info){
		this.card_all_info = card_all_info;
		//マークと数字に分ける
		String [] val = card_all_info.split(":");
		this.card_mark = val[0];
		this.card_number = Integer.parseInt(val[1]);
		
	}


	/**
	 * 表示用の配列に変換
	 * 
	 * @param array_card
	 *            (表示させたいカードの配列)
	 * @return 変換した表示させたいカードの配列
	 */
	public ArrayList<String> display_card(ArrayList<String> array_card) {

		ArrayList<String> disp_card = new ArrayList<String>();

		// 変換する
		for (String val : array_card) {
			String[] pieces;

			// マークと数字にわける
			pieces = val.split(":");

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
	 * @return card_all_info
	 */
	public String getCard_all_info() {
		return card_all_info;
	}


	/**
	 * @param card_all_info セットする card_all_info
	 */
	public void setCard_all_info(String card_all_info) {
		this.card_all_info = card_all_info;
	}


	/**
	 * @return card_mark
	 */
	public String getCard_mark() {
		return card_mark;
	}


	/**
	 * @param card_mark セットする card_mark
	 */
	public void setCard_mark(String card_mark) {
		this.card_mark = card_mark;
	}


	/**
	 * @return card_number
	 */
	public int getCard_number() {
		return card_number;
	}


	/**
	 * @param card_number セットする card_number
	 */
	public void setCard_number(int card_number) {
		this.card_number = card_number;
	}



}