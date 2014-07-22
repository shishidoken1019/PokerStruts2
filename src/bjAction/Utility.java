package bjAction;

import java.util.ArrayList;
import java.util.Collections;

import bjAction.Player;

public class Utility {
	/**
	 * ブラックジャックで結果を出す処理
	 * 
	 * @param player
	 *            （プレイヤー）
	 * @param parent
	 *            （親）
	 * @return 結果コメント
	 */
	public String result(Player player, Player parent) {

		String result = "";
		// 結果
		// 引き分け条件
		if (player.getPlayer_sum_card() == parent.getPlayer_sum_card()
				|| (parent.getPlayer_sum_card() > 21 && player
						.getPlayer_sum_card() > 21)) {
			result = "引き分け";
		}
		// プレイヤー勝利条件
		else if ((parent.getPlayer_sum_card() > 21)
				|| (player.getPlayer_sum_card() > parent.getPlayer_sum_card() && player
						.getPlayer_sum_card() <= 21)) {
			result = "あなたの勝ち";
		}
		// プレイヤー負け条件
		else if ((player.getPlayer_sum_card() > 21)
				|| (player.getPlayer_sum_card() < parent.getPlayer_sum_card() && parent
						.getPlayer_sum_card() <= 21)) {
			result = "あなたの負け";
		}

		return result;
	}

	/**
	 * ポーカーの役の判定を行う
	 */
	public String poker_skill_jadge(Player player) {
		// 手札全体を見て
		// 役が成立しているかどうかを判定
		boolean skill_exist = false;

		// 各々の数字に何枚カードがあるか
		ArrayList<Integer> number_for_card_count = new ArrayList<Integer>();
		for (int i = 0; i <= 13; i++) {	
			number_for_card_count.add(0);
		}
		
		// 数字が同じ系の判定
		for (Card val : player.getPlayer_card()) {
			// カードの数字がどれにあてはまるか検索
			for (int i = 1; i <= 13; i++) {
				// 数字毎に何枚あるか配列に格納
				if (val.getCard_number() == i) {
					int num = number_for_card_count.get(i);
					number_for_card_count.set(i,num+1);
				}
			}
		}

		//枚数が多い数字順に並べる
		Collections.sort(number_for_card_count);
		Collections.reverse(number_for_card_count);
		for (int val : number_for_card_count) {
			System.out.println(val);
		}

		return "手役のポイント";
	}
}
