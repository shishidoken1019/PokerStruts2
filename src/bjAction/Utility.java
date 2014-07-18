package bjAction;

import bjAction.Player;

public class Utility {
	/**
	 *  ブラックジャックで結果を出す処理
	 * @param player（プレイヤー）
	 * @param parent（親）
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
	public String poker_skill_jadge(Player player){
		//手札全体を見て
		//役が成立しているかどうかを判定
		boolean skill_exist = false;
		
		
		//マークと数字に分割
		for(String val :player.getPlayer_card()){
				
		}
		
		//数字が同じ系の判定
		for(String val :player.getPlayer_card()){
			
		}
		
		
		return "手役のポイント";
	}
}
