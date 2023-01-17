package baekjoon;
import java.util.*;
public class Baekjoon_1748 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(10^3);
		// 1~9 : 1자리 (9)
		// 10~99 : 2자리 (90)
		// 100~999 : 3자리 (900)
		// ...
		// 100000000~999999999 : 9자리
		
		// n이 몇 자리 자연수인지 체크
		int cnt = 0, sum=0;
		while(true) {
			if(n/10 == 0) {
				cnt++;
				break;
			}
			n=n/10;
			cnt++;
		}
		
		for(int i=1; i<cnt; i++) 
			sum+=(9*10^n-i);
		
		for(int i=10^(cnt-1); i<=n; i++)
			sum+=cnt;
		
		System.out.println(sum);
	}
	
	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = n;		
		int cnt=0;

		// 1-9(9개) : 1자리 
		// 10-99(90개) : 2자리
		// 100-999(900개) : 3자리
		// 1000-9999 : 4자리
		// 10000-99999 : 5자리
		// 100000-999999 : 6자리
		// 1000000-9999999 : 7자리
		// 10000000-99999999 : 8자리
		// 100000000-999999999 : 9자리

		while(true) { // n의 자리수 구하기
			n=n/10;
			cnt++;
			if(n==0)
				break;
		}

		long sum = 0;		
		for(int i=1; i<cnt; i++) { // n의 직전 자리수에 해당 하는 수의 길이를 더해준다.
			int k=1;
			for(int j=1; j<i; j++) 
				k*=10;
			sum += (k*i*9);
		}

		int x=1;
		for(int i=1; i<cnt; i++)
			x*=10;
		sum+=(a-x+1)*cnt;
		System.out.println(sum);
	}
	*/
}
