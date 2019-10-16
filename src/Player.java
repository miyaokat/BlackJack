import java.util.ArrayList;

public class Player {
	protected Deck cardlist;
	protected ArrayList<Card> hand;
	protected String name;
	protected String icon;

	//コンストラクタ
	public Player(String name, String icon, Deck cardlist) {
		this.name =name;
		this.icon =icon;
		this.cardlist = cardlist;
		hand = new ArrayList<Card>();
		initialize();
	}

	//手札の初期化
	public void initialize() {
		hand.clear();
		for(int i=0;i<2;i++) {
			addACard();
		}
	}

	//カードを一枚取得する
	public void addACard() {
		Card c = cardlist.next();
		if (c != null) {
			hand.add(c);
		}
	}

	//手札の点数を取得する
	public int score() {
		int sum =0;
		for(Card c: hand) {
			sum += c.score();
		}
		return sum;
	}

	//プレイヤーのスコアと文字列を表示させる
	public String toString() {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append(icon);
		sbuf.append(name);
		sbuf.append("  [");
		sbuf.append(score());
		sbuf.append("]  ");
		cardStr(sbuf);
		return sbuf.toString();
	}

	void cardStr(StringBuilder sbuf) {
		for(Card c: hand) {
			sbuf.append(c.toString());
			sbuf.append("  ");
		}
	}
}
