package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_3273 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.valueOf(st.nextToken());
	
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(num);
		
		int count = 0;
		int start = 0;
		int end = n - 1;
		
		while(start < end) {
			int sum = num[start] + num[end];
			
			if(sum == x)
				count++;
			
			if(sum <= x)
				start++;
			else
				end--;
		}
		
		System.out.println(count);
	}

}
