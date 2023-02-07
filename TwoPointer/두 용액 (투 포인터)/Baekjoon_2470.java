package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] num = new int[n];
		
		for(int i=0; i<n; i++) 
			num[i] = Integer.parseInt(str[i]);
			
		Arrays.sort(num);	// 오름차순 정렬
		pick(num, 0, n-1);
	}
	
	public static void pick(int[] num, int start, int end) {
		int minA = -1, minB = -1;
		int min = 2000000000;
		
		while(start < end) {
			int sum = num[start] + num[end];
			
			if(min > Math.abs(sum)) {
				minA = num[start];
				minB = num[end];
				min = Math.abs(sum);
			}
			
			if(sum > 0)
				end--;
			else
				start++;
		}
		
		System.out.println(minA + " " + minB);
	}
}
