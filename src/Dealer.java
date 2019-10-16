public class Dealer extends Player {

	//Playerと共通の部分が多いため、Playerクラスを継承する
	public Dealer(String name, String icon, Deck cardlist) {
		super(name,icon,cardlist);
	}

	//ディーラーのみ16点以上になるまで引かなければならない
	public void over16() {
		while(score() <= 16) {
			addACard();
		}
	}

	//１枚目のカードのみを表示するメソッド
	public String half() {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append(icon);
		sbuf.append(name);
		sbuf.append("  [?]  ");//合計スコアは不明のため伏せる
		halfStr(sbuf);
		sbuf.append("*********");
		return sbuf.toString();
	}

	//１枚目の手札の文字列表現を返すメソッド
	void halfStr(StringBuilder sbuf) {
		Card c = hand.get(0);
		sbuf.append(c.toString());
		sbuf.append("  ");
	}

}
