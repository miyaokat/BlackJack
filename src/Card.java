public class Card {
	private int n;
	static final int RANK = 13;
	static final int SUIT = 4;
	int number;
	int m ,k;
	//カードの文字列配列
	static final String[] NS = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	//カードの柄配列
	static final String[] SS = {"スペード","ダイヤ","クラブ","ハート"};
	//カードのポイント配列（10以上は全て10として扱う）
	static final int[] PS = {1,2,3,4,5,6,7,8,9,10,10,10,10};

	//コンストラクタ
	public Card(int ml) {
		n = ml;
	}

	public int getNum() {
		return number;
	}

	//カード番号（１〜１３）を返す
	public int cardNumber() {
		number = (n-1) % RANK +1;
		return number;
	}

	//カードの柄を返す（13ごとに分けており、その結果に応じた配列番号を渡している）
	public int suitNumber() {
		number = (n-1)/RANK;
		return number;
	}

	//カード番号をベースに配列の値を取得（配列は０始まりのため、マイナス1をしている）
	public int score( ) {
		k = cardNumber();
		return PS[k-1];
	}

	//文字列型のカード番号を取得
	public String cardNumberString() {
		k = cardNumber();
		return NS[k-1];
	}

	//カードの柄の文字列を取得
	public String suitName() {
		m = suitNumber();
		return SS[m];
	}

	//カードの柄と数字を連結させる
	public String toString() {
		return suitName() + cardNumberString();
	}

}
