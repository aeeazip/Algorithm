package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_2667 {
	static int apart[][];
	static boolean visit[][];
	
	static int[] dX = {0, 0, -1, 1};
	static int[] dY = {1,-1, 0, 0};
	static int[] apartCount = new int[25*25];
	
	static int n;
	
	public static void dfs(int i, int j, int N) {
		visit[i][j] = true;						// 방문 표시
		apartCount[N]++;
		
		for(int x=0; x<4; x++) {
			int newX = i + dX[x];
			int newY = j + dY[x];
			
			if(newX < 0 || newX > n || newY < 0 || newY > n)
				continue;
			
			if(!visit[newX][newY] && apart[newX][newY] == 1) {
				dfs(newX, newY, N);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());					// 지도의 크기
		
		apart = new int[n+1][n+1];
		visit = new boolean[n+1][n+1];
		
		for(int i=0; i<n; i++) {				// 집이 있는 / 없는 곳 입력 받기
			String[] input = br.readLine().split("");
			
			for(int j=0; j<n; j++) {
				apart[i][j] = Integer.parseInt(input[j]);
			}
		}
	
		// visit 검사해서 dfs 호출
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visit[i][j] && apart[i][j] == 1) {				// 첫 방문인지 체크
					count++;
					dfs(i, j, count);	
				}
			}
		}
		
		System.out.println(count);									// 정렬
		Arrays.sort(apartCount);
		for(int i=0; i<apartCount.length; i++) {
			if(apartCount[i] != 0)
				System.out.println(apartCount[i]);
		}
	}

}
