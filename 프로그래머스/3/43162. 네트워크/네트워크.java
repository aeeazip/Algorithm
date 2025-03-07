class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, visited, i, n);
                count++;
            }
        }
        
        return count;
    }
    
    public static void dfs(int[][] computers, boolean[] visited, int start, int n) {
        visited[start] = true;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i] && computers[start][i] == 1) { // 현재를 기준으로 근처에 간선이 있는지
                visited[i] = true;
                dfs(computers, visited, i, n);
            }
        }
    }
}