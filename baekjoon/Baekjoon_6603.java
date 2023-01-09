package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class Baekjoon_6603 {
	
	public static void pick(int[] arr, int[] bucket, int k) {
		int i, smallest, lastIndex;
		lastIndex = bucket.length-k-1;
		
		if(k==0) {
			for(i=0; i<bucket.length; i++)
				System.out.print(arr[bucket[i]] + " ");
			System.out.println("");
			return;
		}
		
		if(k==bucket.length)
			smallest=0;
		else
			smallest=bucket[lastIndex]+1;
		
		for(i=smallest; i<arr.length; i++) {
			bucket[lastIndex+1]=i;
			pick(arr, bucket, k-1);
		}
		return;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr;
		int[] bucket;
		int n;
		
		while(true) {
			String str = br.readLine();	
			if(str.equals("0")) break;
			
			String[] input = str.split(" ");
			n = Integer.parseInt(input[0]);
			
			if(n<6) break;
			arr = new int[n];
			
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(input[i+1]);
			
			bucket = new int[6];
			pick(arr, bucket, 6);
			System.out.println();
		}
	}
}


