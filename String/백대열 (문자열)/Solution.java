package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_14990 {

	public static int GCD(int x, int y) { // 항상 x > y
		if(y==0)
			return x;
		return GCD(y, x % y);
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] num = str.split(":");

		int x = Integer.parseInt(num[0]);
		int y = Integer.parseInt(num[1]);

		int n = (x > y) ? GCD(x, y) : GCD(y, x);
		
		System.out.println(x / n + ":" + y / n);
	}

}
