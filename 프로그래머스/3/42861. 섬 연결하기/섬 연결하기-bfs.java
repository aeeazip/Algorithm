import java.util.*;

class Solution {
    public static List<Integer>[] graph; // 연결된 섬 기록
    public static boolean[] visited;
    
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
        
        int answer = 0;
        int count = 0;
        
        for(int i = 0; i < costs.length; i++) {
            visited = new boolean[n];
            
            if(!isCycle(costs[i][0], costs[i][1])) {
                graph[costs[i][0]].add(costs[i][1]);
                graph[costs[i][1]].add(costs[i][0]);
                count++;
                answer += costs[i][2];
            }
            
            if(count == n - 1) break;
        }
        
        return answer;
    }
    
    public static boolean isCycle(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int n = queue.poll();
            
            if(n == end) return true;
            for(Integer i : graph[n]) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        
        return false;
    }
}
