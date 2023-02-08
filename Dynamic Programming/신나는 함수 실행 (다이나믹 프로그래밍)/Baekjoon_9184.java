package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Baekjoon_9184 {
	
	static int[][][] w = new int[21][21][21];
	
	public static boolean checkRange(int a, int b, int c) {
		if(a>=0 && a<=20 && b>=0 && b<=20 && c>=0 && c<=20)
			return true;
		return false;
	}
	
	public static int w(int a, int b, int c) {
		
		if(checkRange(a, b, c) && w[a][b][c] != 0)
			return w[a][b][c];
		
		if(a <= 0 || b <= 0 || c <= 0)
			return 1;
		
		if(a > 20 || b > 20 || c > 20) 
			return w[20][20][20] = w(20, 20, 20);
		
		if(a < b && b < c) 
			return w[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		
		return w[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(a == -1 && b == -1 && c == -1)
				break;
			
			bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");	
		}
		
		bw.flush();
		bw.close();
	}

}
