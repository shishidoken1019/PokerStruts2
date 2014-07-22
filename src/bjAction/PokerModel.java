package bjAction;

import java.util.ArrayList;

public class PokerModel {
	
	/**
	 * 親のカード情報
	 */
	private ArrayList<String> parent_card;
	/**
	 * プレイヤーのカード情報
	 */
	private ArrayList<String> player_card;
	/**
	 * 結果コメント
	 */
	private String result = "";
	/**
	 * 親のカードの合計
	 */
	private int parent_point = 0;
	/**
	 * プレイヤーのカードの合計
	 */
	private int player_point = 0;
	/**
	 * チェックボックスの値
	 */
	private String checkboxField1;
	
	
	
	
	private ArrayList<String> values = new ArrayList<String>();
	/**
	 * @return parent_card
	 */
	public ArrayList<String> getParent_card() {
		return parent_card;
	}
	/**
	 * @param parent_card セットする parent_card
	 */
	public void setParent_card(ArrayList<String> parent_card) {
		this.parent_card = parent_card;
	}
	/**
	 * @return player_card
	 */
	public ArrayList<String> getPlayer_card() {
		return player_card;
	}
	/**
	 * @param player_card セットする player_card
	 */
	public void setPlayer_card(ArrayList<String> player_card) {
		this.player_card = player_card;
	}
	/**
	 * @return result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result セットする result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return parent_point
	 */
	public int getParent_point() {
		return parent_point;
	}
	/**
	 * @param parent_point セットする parent_point
	 */
	public void setParent_point(int parent_point) {
		this.parent_point = parent_point;
	}
	/**
	 * @return player_point
	 */
	public int getPlayer_point() {
		return player_point;
	}
	/**
	 * @param player_point セットする player_point
	 */
	public void setPlayer_point(int player_point) {
		this.player_point = player_point;
	}
	/**
	 * @return values
	 */
	public ArrayList<String> getValues() {
		return values;
	}
	/**
	 * @param values セットする values
	 */
	public void setValues(ArrayList<String> values) {
		this.values = values;
	}

	public void addValues(String aaa) {
		this.values.add(aaa);
	}
	/**
	 * @return checkboxField1
	 */
	public String getCheckboxField1() {
		return checkboxField1;
	}
	/**
	 * @param checkboxField1 セットする checkboxField1
	 */
	public void setCheckboxField1(String checkboxField1) {
		this.checkboxField1 = checkboxField1;
	}

	
	
	/**
	 * 
	 */
	private String[] checkboxField3;
	/**
	 * @return checkboxField3
	 */
	public String[] getCheckboxField3() {
		return checkboxField3;
	}
	/**
	 * @param checkboxField3 セットする checkboxField3
	 */
	public void setCheckboxField3(String[] checkboxField3) {
		this.checkboxField3 = checkboxField3;
	}
	
	

}
