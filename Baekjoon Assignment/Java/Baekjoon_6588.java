package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_6588 {
	public static final int MAX = 1000000;
	public static void main(String[] args) throws IOException {
		// 에라토스테네스의 체
	
		Scanner sc = new Scanner(System.in);
		
		boolean[] isPrime = new boolean[MAX+1];
		for(int i=2; i<=MAX; i++)
			isPrime[i]=true;
		
		for(int i=2; i<=MAX; i++) {
			for(int j=i*2; j<=MAX; j+=i) {
				if(!isPrime[j]) continue;
				isPrime[j]=false;
			}			
		}
		
		while(true) {
			int x = sc.nextInt();
			boolean ok = false;
			
			if(x==0)
				break;
			for(int i=2; i<=x/2; i++) {
				if(isPrime[i] && isPrime[x-i]) {
					System.out.println(x + " = " + i + " + " + (x-i));
					ok=true;
					break;
				}
			}
			
			if(!ok)
				System.out.println("Goldbach's conjecture is wrong.");
		}
		
	}
}
