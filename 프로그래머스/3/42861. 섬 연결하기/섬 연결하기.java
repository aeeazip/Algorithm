import java.util.*;

class Solution {
    public static List<Integer>[] graph; // 연결된 섬 기록
    public static int[] parent;
    
    public int solution(int n, int[][] costs) {
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 다리 건설 비용을 기준으로 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] c1, int[] c2) {
                return Integer.compare(c1[2], c2[2]);
            }
        });
        
        // kruskal
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        
        int answer = 0;
        int count = 0;
        
        for(int i = 0; i < costs.length; i++) {
            if(find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                count++;
                answer += costs[i][2];
            }
            
            if(count == n - 1) break;    
        }
        
        return answer;
    }
    
    public static int find(int x) {
        if(parent[x] == x) return parent[x];
        return parent[x] = find(parent[x]);
    }
    
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if(x != y) parent[y] = x;
    }
}