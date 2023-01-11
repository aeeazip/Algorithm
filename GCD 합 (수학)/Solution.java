package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_9613 {
	public static long GCD(int x, int y) {
		if(y == 0)
			return x;
		return GCD(y, x % y);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long total;
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			int m = Integer.parseInt(str[0]);
			
			int[] array = new int[m];
			for(int j=0; j<m; j++) 
				array[j] = Integer.parseInt(str[j+1]);
			
			total = 0; // total 초기화
			for(int k=0; k<m; k++) { // 조합으로 2개씩 선택하고, GCD 호츌
				for(int l=k+1; l<m; l++) {
					total += (array[k] > array[l] ? GCD(array[k], array[l]) : GCD(array[l], array[k])); 
				}
			}
			
			System.out.println(total);
			
		}	
	}

}
