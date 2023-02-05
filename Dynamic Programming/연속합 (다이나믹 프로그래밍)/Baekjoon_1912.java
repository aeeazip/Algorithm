package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] num = br.readLine().split(" ");
		int[] memo = new int[n];
		
		memo[0] = Integer.parseInt(num[0]);
		
		for(int i=1; i<n; i++) {
			int now = Integer.parseInt(num[i]);
			if(now > memo[i-1] + now)
				memo[i] = now;
			else
				memo[i] = memo[i-1] + now;
		}

		Arrays.sort(memo);
		System.out.println(memo[n-1]);
	}

}
