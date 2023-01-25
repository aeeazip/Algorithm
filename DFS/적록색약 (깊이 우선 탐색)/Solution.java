package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Baekjoon_10026 {

	static char[][] color;
	static boolean[][] visit;
	static int[] dX = {0,0,-1,1};		// 상하좌우 순서
	static int[] dY = {1,-1,0,0};		// 상하좌우 순서
	static int n;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		color = new char[n+1][n+1];
		visit = new boolean[n+1][n+1];
		
		for (int i=0; i<n; i++){		//input 입력받기
            String s = sc.next();
            for (int j=0; j<n; j++){
                color[i][j] = s.charAt(j);
            }
        }
		
		/* 적록색맹이 없는 경우 */		
		int area1 = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visit[i][j]) {		// 새로운 영역인지 체크
					dfs(i, j, color[i][j]);
					area1++;
				}
			}
		}
		
		/* 적록색약이 있는 경우 (R과 G 구분 X) */
		visit = new boolean[n+1][n+1];
		
		int area2 = 0;
		for(int i=0; i<n; i++) 		// 적록색약은 R과 G를 구분할 수 없기 때문에 
			for(int j=0; j<n; j++) 	// G인 경우를 R로 통일 (R인 경우를 G로 통일하는 방법도 가능)
				if(color[i][j] == 'G')
					color[i][j] = 'R';
			
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visit[i][j]) {	//	새로운 영역인지 체크
					dfs(i, j, color[i][j]);
					area2++;
				}
			}
		}
		
		System.out.println(area1 + " " + area2);
	}
	
	public static void dfs(int i, int j, char current) {
		visit[i][j] = true;			// 방문 표시
		
		for(int x=0; x<4; x++) {
			int newX = i + dX[x];	// 검사할 새로운 X 좌표값
			int newY = j + dY[x];	// 검사할 새로운 Y 좌표값
			
			if(newX < 0 || newX > n || newY < 0 || newY > n) 
				continue;		// 좌표값 범위가 color 배열의 size를 넘어간 경우
			
			/*
			System.out.println("얼마나 더할건지 : " + dX[x] + " " + dY[x]);
			System.out.println("현재 좌표 : " + newX + " " + newY);
			
			System.out.println("방문여부 : " + visit[newX][newY]);
			System.out.println("color값 : " + color[newX][newY]);
			*/
			
			if(!visit[newX][newY] && color[newX][newY] == current)
				dfs(newX, newY, color[newX][newY]);
		}	
	}

}
