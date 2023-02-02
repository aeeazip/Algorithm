package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1475 {

	public static void main(String[] args) throws IOException {
		int[] count = new int[10];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split("");
		
		for(int i=0; i<num.length; i++) {
			int n = Integer.parseInt(num[i]);
			
			if(n==9 || n==6) {
				if(count[9] > count[6])
					count[6]++;
				else
					count[9]++;
			}
			else count[n]++;
		}
		
		int max = 0;
		for(int i=0; i<10; i++) 
			if(count[i] > max) max = count[i];
		
		System.out.println(max);
	}

}
