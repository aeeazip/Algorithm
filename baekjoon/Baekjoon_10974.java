package baekjoon;

import java.util.*;
public class Baekjoon_10974 {
	public static void permutation(int n, int[] bucket, int k) {
		int i, lastIndex, smallest, flag;
		lastIndex = bucket.length-k-1;
		
		if(k==0) {
			for(i=0; i<bucket.length; i++)
				System.out.print(bucket[i] + " ");
			System.out.print("\n");
			return;
		}
		
		smallest=1;
		for(i=smallest; i<=n; i++) {
			flag=0;
			for(int j=0; j<=lastIndex; j++) {
				if(i == bucket[j]) {
					flag=1;
					break;
				}
			}
			
			if(flag==0) {
				bucket[lastIndex+1] = i;
				permutation(n, bucket, k-1);
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] bucket = new int[n];
		permutation(n, bucket, n);
	}

}
