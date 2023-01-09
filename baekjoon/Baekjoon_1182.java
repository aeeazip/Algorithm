package baekjoon;

import java.util.Scanner;

public class Baekjoon_1182 {
	// dfs로 풀기 (포함 / 미포함 이용하기)
	static int n, s;
	static int count=0;
	static int[] arr;
	
	public static void dfs(int v, int sum) {
		if(v==n) {
			if(sum==s)
				count++;
			return;
		}
		
		dfs(v+1, sum+arr[v]); // 부분수열 즉 지금 위치의 원소 포함
		dfs(v+1, sum); // 부분수열 즉 지금 위치의 원소 미포함
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n=sc.nextInt();
		s=sc.nextInt();
		arr = new int[n];

		for(int i=0; i<n; i++)
			arr[i]=sc.nextInt();

		dfs(0,0);

		if(s==0) // count가 0인 경우 공집합도 포함되므로 하나를 빼준다.
			count--;
		System.out.println(count);
	}
	
}
	/*

	// 조합으로 풀기

	public static int countS(int[] arr, int[] bucket, int k, int s) {
		int count=0, sum = 0;
		int i, smallest, lastIndex;

		if(k==0) {
			for(i=0; i<bucket.length; i++)
				sum+=arr[bucket[i]];
			if(sum==s)
				return 1;
			else 
				return 0;
		}

		lastIndex = bucket.length-k-1;	
		if(k==bucket.length)
			smallest = 0;
		else
			smallest = bucket[lastIndex] + 1;

		for(i=smallest; i<arr.length; i++) {
			bucket[lastIndex+1]=i;
			count+=countS(arr, bucket, k-1, s);
		}
		return count;	
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n, s;
		int count = 0;

		n = sc.nextInt();
		s = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();

		for(int i=0; i<n; i++) { 
			int[] bucket = new int[i+1];
			count+=countS(arr, bucket, i+1, s);
		}

		System.out.println(count);
	}
	 */
