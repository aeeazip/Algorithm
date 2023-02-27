import java.util.*;
import java.io.*;

public class Main {
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};
    
    static int[][] height;
    static boolean[][] visit;
    
    static int n;
    
    public static int dfs(int x, int y, int h){
        visit[x][y] = true;
        
        for(int i=0; i<4; i++){
            int newX = dX[i] + x;
            int newY = dY[i] + y;
            
            if(newX < 0 || newX > n-1 || newY < 0 || newY > n-1)
                continue;
            if(visit[newX][newY])
                continue;
            if(height[newX][newY] > h)
                dfs(newX, newY, h);
        }
        
        return 1;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		height = new int[n][n];
        int maxHeight = -1;
        
		for(int i=0; i<n; i++){
		    String[] num = br.readLine().split(" ");
		    for(int j=0; j<n; j++){
		        height[i][j] = Integer.parseInt(num[j]);
		        
		        if(height[i][j] > maxHeight)
		            maxHeight = height[i][j];
		    }
		}
		
		int max = 0;
		for(int h=0; h<=maxHeight; h++){
		    visit = new boolean[n][n];
		    int count = 0;
		    
		    for(int i=0; i<n; i++){
		        for(int j=0; j<n; j++){
		            if(!visit[i][j] && height[i][j] > h){
		                count += dfs(i, j, h);
		            }
		        }
		    }
		    
		    max = Math.max(max, count);
		}
		System.out.println(max);
	}
}
