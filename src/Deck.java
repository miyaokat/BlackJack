import java.util.ArrayList;

public class Deck {

	private int max;
	private ArrayList<Card> cardlist;

	//コンストラクタ
	public Deck(int max) {
		this.max = max;
		cardlist = new ArrayList<Card>();
		initialize();
	}

	//山札を初期化する
	public void initialize() {
		cardlist.clear();
		for(int i =0; i<max; i++) {
		Card c = new Card(i+1);
		cardlist.add(c);
		}
	}

	//現在の山札の数を確認する
	public int size() {
		return cardlist.size();
	}

	//次のCardオブジェクトを取得
	public Card next() {
		int n = size();
		if(n == 0) {
			return null;
		}
		int p = (int)(Math.random()*n);
		Card c = cardlist.remove(p);
		return c;
	}

	Card indexOf(int k) {
		return cardlist.get(k);
	}
}
