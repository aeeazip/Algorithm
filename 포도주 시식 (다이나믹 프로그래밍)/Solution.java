package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2156 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] wines = new int[n];
		int[] M = new int[n];     // 동적 프로그래밍을 위한 Memoization
		
		// 아니 이거 왜 안풀리냐고 진짜 짜증나게 
		for(int i=0; i<n; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}
		
		M[0] = wines[0];
		if(n > 1)		// 첫 잔인 경우 체크 필요 : 체크 안하면 ArrayIndexOutOfBoundsException 에러 발생 
			M[1] = wines[0] + wines[1];
		if(n > 2)		// 두번째 잔인 경우 체크 필요 : 체크 안하면 ArrayIndexOutOfBoundsException 에러 발생
			M[2] = Math.max(M[1], Math.max(wines[1] + wines[2], M[0] + wines[2]));
		
		for(int i=3; i<n; i++) {
			// 연속으로 놓여 있는 3잔은 모두 마실 수 없기 때문에 
			// 3가지 case 중 가장 큰 값을 선택
			// 1. XOO		2. OXO		3. OOX
			M[i] = Math.max(M[i-1],  Math.max(M[i-2] + wines[i], M[i-3] + wines[i-1] + wines[i]));
		}
		
		System.out.println(M[n-1]);
	
	}

}
