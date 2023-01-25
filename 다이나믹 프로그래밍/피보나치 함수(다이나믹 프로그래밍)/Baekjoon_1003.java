package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for(int i=0; i<n; i++) {
			int[] M0 = new int[arr[i] + 1]; 	// fib(n)의 0 출력 개수를 담는 Memoization
			int[] M1 = new int[arr[i] + 1]; 	// fib(n)의 1 출력 개수를 담는 Memoization

			// fib(0), fib(1), fib(2)에 대한 Exception 처리
			M0[0] = 1;
			M1[0] = 0;

			if(arr[i] >= 1) {
				M0[1] = 0;
				M1[1] = 1;
			}	

			if(arr[i] >= 2) {
				M0[2] = M0[0] + M0[1];		// 1로 적어도 무방
				M1[2] = M1[0] + M1[1];		// 1로 적어도 무방
			}

			for(int j=3; j<=arr[i]; j++) {
				M0[j] = M0[j-1] + M0[j-2];	// 직전 두 개의 0 개수 합
				M1[j] = M1[j-1] + M1[j-2];	// 직전 두 개의 1 개수 합
			}
			
			System.out.println(M0[arr[i]] + " " + M1[arr[i]]);
		}

	}

}
;