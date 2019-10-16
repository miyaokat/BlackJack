import lib.Util;

public class BlackJack {
	static final String DEALER_ICON="□";
	static final String PLAYER_ICON="■";
	static final String BANNER="■□■□■□BlackJack■□■□■□";
	static final int CARDS=52;
	static final int LIMIT=17;
	static final String Q_CONTINUE="続けますか？(Enter/n)";
	static final String Q_DEAL="さらにカードを引きますか？(Enter/n)";
	static final String EVEN="引き分け";
	static final String WIN="あなたの勝ち";
	static final String LOST="ディーラーの勝ち";

	static final String ANIMATION_ICON="□■□■□■□■□■□■□■";
	static final int TIMES=25;
	static final int DELAY=20;

	private Deck cardlist;
	private Dealer dealer;
	private Player player;

	//コンストラクタ
	public BlackJack(String dname, String pname) {
		cardlist = new Deck(CARDS);
		dealer = new Dealer(dname,DEALER_ICON,cardlist);
		player = new Player(pname,PLAYER_ICON,cardlist);
	}

	//山札とプレイヤーとディーラーを初期化する
	public void initialize() {
		if(cardlist.size()<LIMIT) cardlist.initialize();
		dealer.initialize();
		player.initialize();
	}

	//プレイヤーとディーラーの手札を表示する
	public void show() {
		System.out.println();
		System.out.println(dealer);
		System.out.println(player);
	}

	//プレイに関する処理
	public void play() {
		String str;
		do {
			System.out.println(BANNER);
			initialize();
			showHalf();
			deal();
			dealer.over16();
			animation(TIMES,DELAY,ANIMATION_ICON);
			show();
			judge();
		}while((str=Util.getString(Q_CONTINUE))==null);
	}

	//ディーラーは最初は１枚のみ表示する
	public void showHalf() {
		System.out.println();
		System.out.println(dealer.half());
		System.out.println(player);
	}

	//引き合い時の処理
	public void deal() {
		while(player.score()<21) {
			String str =Util.getString(Q_DEAL);
			if(str!=null) {
				break;
			}
			player.addACard();
			showHalf();
		}
	}

	//勝負判定
	public void judge() {
		int d = dealer.score();
		int p = player.score();
		if(d>21&&p>21 || d==p) {
			System.out.println(EVEN);
		}else if(p<=21 && (d>21||d<p)) {
			System.out.println(WIN);
		}else {
			System.out.println(LOST);
		}
	}

	public void animation(int times, int delay, String icon) {
		System.out.println();
		try {
			for(int i=0;i<TIMES;i++) {
				System.out.println(icon);
				Thread.sleep(delay);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
