package lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
	//キーボードから入力された文字列を返すメソッド
	public static String getString(String s) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str;
		try {
			System.out.println(s+"  >");
			str = in.readLine();
			if(str.length()>0) {
				return str;
			}else{
				return null;
			}
		}catch(IOException e){
			return null;
		}
	}
}
