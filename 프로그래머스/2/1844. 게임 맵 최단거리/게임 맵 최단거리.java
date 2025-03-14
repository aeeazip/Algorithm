import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        int result = bfs(maps);
        return result;
    }
    
    public static int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];    
        
        int[] dX = { 1, -1, 0, 0};
        int[] dY = { 0, 0, 1, -1 };
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ 0, 0 });
        visited[0][0] = true;
        distance[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int newdX = now[0] + dX[i];
                int newdY = now[1] + dY[i];
                
                if(newdX < 0 || newdX >= n || newdY < 0 || newdY >= m) continue;
                
                if(!visited[newdX][newdY] && maps[newdX][newdY] != 0) {
                    visited[newdX][newdY] = true;
                    queue.add(new int[]{ newdX, newdY });
                    distance[newdX][newdY] = distance[now[0]][now[1]] + 1;
                }
            }
        }
        
        return distance[n - 1][m - 1] == 0 ? -1 : distance[n - 1][m - 1];      
    }
}