package baekjoon;

import java.io.*;

public class Baekjoon_2738 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] num = br.readLine().split(" ");
	    
	    int nA = Integer.parseInt(num[0]);
	    int nB = Integer.parseInt(num[1]);
	    
	    int[][] arrA = new int[nA][nB];
	    int[][] arrB = new int[nA][nB];
	    int[][] arrC = new int[nA][nB];
	    
	    for(int i=0; i<nA; i++){
	        String[] num1 = br.readLine().split(" ");
	        for(int j=0; j<nB; j++){
	            arrA[i][j] = Integer.parseInt(num1[j]);
	        }
	    }
	    
	    for(int i=0; i<nA; i++){
	        String[] num2 = br.readLine().split(" ");
	        for(int j=0; j<nB; j++){
	            arrB[i][j] = Integer.parseInt(num2[j]);
	        }
	    }
	    
	    for(int i=0; i<nA; i++){
	        for(int j=0; j<nB; j++){
	            arrC[i][j] = arrA[i][j] + arrB[i][j];
	        }
	    }
	    
	    for(int i=0; i<nA; i++){
	        for(int j=0; j<nB; j++){
	            System.out.print(arrC[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
}
