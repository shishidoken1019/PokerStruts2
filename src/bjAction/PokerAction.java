package bjAction;

import java.util.ArrayList;


import java.util.Collections;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.opensymphony.xwork2.ModelDriven;

import bjAction.Card;
import bjAction.Player;
import bjAction.AbstractAction;

@Results({ @Result(name = "errorPage", value = "errorPage.action", type = ServletRedirectResult.class) })
public class PokerAction extends AbstractAction implements ModelDriven<PokerModel>{

	//モデル情報はpokerModel.javaで持つ
	private static final long serialVersionUID = 1L;
	private  PokerModel pokerModel = new PokerModel();

	// 初期アクセス時の処理
	public String execute() throws Exception {

		// ゲームをリロードしようとしたらエラー
		if (sessionMap.get("parent") != null) {
			// セッションを消して
			sessionMap.put("parent", null);
			// エラーページに飛ぶ
			return "errorPage";
		}

		// 対戦相手を作る
		Player parent = new Player();

		// プレイヤーのインスタンスをセッション情報から持ってくる
		Player player = (Player) sessionMap.get("player");

		// 継続してゲームの場合、プレイヤーのカードを初期化
		if (player.getPlayer_card() != null) {
			player.setPlayer_card(new ArrayList<Card>());
		}

		// ゲームを始めるにあたってトランプを作る
		CardArray cardArray = new CardArray();
		cardArray.make_card();
		//今回使うトランプを用意
		ArrayList<Card> now_use_tramp = cardArray.getAll_tramp();

		// トランプを混ぜる
		Collections.shuffle(now_use_tramp);

		// カードを親とプレイヤーに配る
		now_use_tramp = cardArray.deal_tramp(now_use_tramp, 5, parent, player);
		
		// セッションに情報を格納
		this.session_put_common(now_use_tramp, parent, player);

		// 表示側に渡す情報をセット
		this.common_disp(parent, player);
		
		////
		////
		pokerModel.addValues("aaa");
		pokerModel.addValues("bbb");
		pokerModel.addValues("ccc");
		

		// 画面を表示
		return "success";
	}

	/**
	 * 	チェンジを押されたときに実行
	 * @return 遷移先
	 */
	public String change() {

		// ゲームをリロードしようとしたらエラー
		if (sessionMap.get("parent") == null) {
			// エラーページに飛ぶ
			return "errorPage";
		}

		System.out.println("aaaaaa");
		System.out.println(pokerModel.getCheckboxField3()[0]);
		System.out.println(pokerModel.getCheckboxField3()[1]);
		System.out.println(pokerModel.getCheckboxField3()[2]);
		// セッション情報からインスタンスを取得
		Player player = (Player) sessionMap.get("player");
		Player parent = (Player) sessionMap.get("parent");
		ArrayList<Card> now_use_tramp = (ArrayList<Card>) sessionMap.get("now_use_tramp");

		// 親が行動

		// セッションに情報を格納
		this.session_put_common(now_use_tramp, parent, player);
		

		// 共通部分を表示側に渡す
		this.common_disp( parent, player);

		return "success";

	}

	/**
	 * スタンドを押されたときに実行 
	 * @return 遷移先
	 */
	public String stand() {

		//
		Card card = new Card();

		// ゲームをリロードしようとしたらエラー
		if (sessionMap.get("parent") == null) {
			// エラーページに飛ぶ
			return "errorPage";
		}

		// セッション情報からインスタンスを取得
		Player player = (Player) sessionMap.get("player");
		Player parent = (Player) sessionMap.get("parent");
		ArrayList<String> now_use_tramp = (ArrayList<String>) sessionMap
				.get("now_use_tramp");

		// 親が行動
		now_use_tramp = parent.parent_act(now_use_tramp);

		// ヒットしたのでプレイヤーは手札にカードを追加
		player.setPlayer_state("stand");

		// セッションに情報を格納
		this.session_put_common(now_use_tramp, parent, player);

		// もしプレイヤーのカードが21を超えていたら勝負
		if (parent.getPlayer_state() == "stand") {
			//
			this.fight(player, parent);
		}

		// 共通部分を表示側に渡す
		this.common_disp(card, parent, player);

		//
		return "success";
	}
	
	public String battle(){
		
		//
		
	}

	/**
	 * 共通でセッションに情報を格納するもの
	 */
	public void session_put_common(ArrayList<Card> now_use_tramp,
			Player parent, Player player) {
		sessionMap.put("game_name", (String) sessionMap.get("game_name"));
		sessionMap.put("now_use_tramp", now_use_tramp);
		sessionMap.put("parent", parent);
		sessionMap.put("player", player);
	}

	/**
	 * 共通で表示側に渡すものを渡す
	 * 
	 * @param card
	 * @param parent
	 * @param player
	 */
	public void common_disp(Player parent, Player player) {
		// 表示側に渡す
		CardArray card = new CardArray();
		pokerModel.setParent_card(card.display_card(parent.getPlayer_card()));
		pokerModel.setPlayer_card(card.display_card(player.getPlayer_card()));

	}

	/**
	 * 勝負した場合の処理
	 * 
	 * @param player
	 * @param parent
	 */
	public void fight(Player player, Player parent) {

		Utility utility = new Utility();
		String re = utility.result(player, parent);
		pokerModel.setResult(re);
		pokerModel.setPlayer_point(player.getPlayer_sum_card());
		pokerModel.setParent_point(parent.getPlayer_sum_card());

		sessionMap.put("parent", null);
	}



	@Override
	public PokerModel getModel() {
		// TODO 自動生成されたメソッド・スタブ
		return pokerModel;
	}
	

}
