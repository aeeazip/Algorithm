package baekjoon;

import java.util.*;

public class Baekjoon_9095 {
	public static int pick(int x, int[] item, int[] bucket, int k) {
		int cnt = 0;
		int i, smallest, lastIndex;
		int sum=0;
		
		for(i=0; i<bucket.length-k; i++) 
			sum+=item[bucket[i]];
		
		if(sum==x) 
			return 1;
		else if(sum>x)
			return 0;
		
		lastIndex = bucket.length-k-1;
		
		smallest=0;
		
		for(i=smallest; i<item.length; i++) {
			bucket[lastIndex+1] = i;
			cnt += pick(x, item, bucket, k-1);
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] item = {1,2,3};
		int n = sc.nextInt();
		int[] bucket = new int[11];	
		int[] list = new int[n];
		
		for(int i=0; i<n; i++) 
			list[i] = sc.nextInt();
		
		for(int i=0; i<n; i++)
			System.out.println(pick(list[i], item, bucket, 11));
	}
}
