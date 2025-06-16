import java.util.*;

class Solution {
    public static int n, m;
    public static int[] dX = { -1, 1, 0, 0 };
    public static int[] dY = { 0, 0, 1, -1 };
    public static boolean[][] visited;
    public static Map<Integer, Integer> map; // 그룹, 총 석유량
    public static int[][] group;
    public static int groupId = 1;
    
    public int solution(int[][] land) {
        n = land.length; // 땅의 세로 길이
        m = land[0].length; // 땅의 가로 길이

        group = new int[n][m];
        visited = new boolean[n][m];
        map = new HashMap<>();

        // 1. dfs로 석유가 있는 영역과, 영역별 좌표 기록하기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && land[i][j] == 1) {
                    group[i][j] = groupId;
                    int count = dfs(i, j, land);
                    map.put(groupId++, count);
                }
            }
        }

        // 2. 1 ~ m까지 비교하면서 최댓값 구하기
        int max = 0;
        for(int i = 0; i < m; i++) {
            int amount = 0;
            Set<Integer> set = new HashSet<>();
            
            for(int j = 0; j < n; j++) { set.add(group[j][i]); }
            for(Integer line : set) {
                amount += map.getOrDefault(line, 0);
            }
            
            max = Math.max(amount, max);
        }

        return max;
    }

    public static int dfs(int x, int y, int[][] land) {
        int count = 1;
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int newdX = x + dX[i];
            int newdY = y + dY[i];

            if(newdX < 0 || newdX >= n || newdY < 0 || newdY >= m) continue;

            // 방문 전 + 석유가 있는 땅
            if(!visited[newdX][newdY] && land[newdX][newdY] == 1) {
                group[newdX][newdY] = groupId;
                count += dfs(newdX, newdY, land);
            }
        }
        
        return count;
    }
}