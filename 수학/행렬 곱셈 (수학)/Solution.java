package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Baekjoon_2740 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 행렬 A의 크기 N
		int M = sc.nextInt();		// 행렬 A의 크기 M
			
		int[][] A = new int[N][M];
		
		for(int i=0; i<N; i++) 
			for(int j=0; j<M; j++) 
				A[i][j] = sc.nextInt();
			
		M = sc.nextInt();			// 행렬 B의 크기 M
		int K = sc.nextInt();		// 행렬 B의 크기 K
		
		int[][] B = new int[M][K];
		
		for(int i=0; i<M; i++) 
			for(int j=0; j<K; j++) 
				B[i][j] = sc.nextInt();
		
		int[][] C = new int[N][K];
		for(int i=0; i<N; i++) 
			for(int j=0; j<K; j++) 
				for(int k=0; k<M; k++) 
					C[i][j] += A[i][k]*B[k][j];
				
		for(int i=0; i<N; i++) {
			for(int j=0; j<K; j++)
				System.out.print(C[i][j] + " ");
			System.out.println();
		}	
	}

}
