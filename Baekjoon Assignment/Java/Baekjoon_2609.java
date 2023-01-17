package baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon_2609 {

	public static int gcd(int x, int y) {
		int r;
		
		while(y!=0) {
			r=x%y;	
			x=y;
			y=r;
		}
		return x;
	}
	
	public static void main(String[] args) throws IOException{
		// 유클리드 호제법 사용
		// r = a를 b로 나눈 나머지
		// a와 b의 최대공약수를 (a, b)라고 할 때, (a, b)의 최대공약수는 (b, r)의 최대공약수와 같다. 
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int r = gcd(x, y);
		
		System.out.println(r);
		System.out.println(x * y / r);
	}

}
