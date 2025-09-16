import java.util.*;

class Solution {
    public static Map<Integer, List<Integer>> graph;
    public static Set<Integer> visited;
    
    public int[] solution(int[] nodes, int[][] edges) {
        graph = new HashMap<>();
        visited = new HashSet<>();
        
        int[] answer = new int[2];
        
        // 1. graph 정보 기록
        for(int n : nodes) {
            graph.put(n, new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }                                    
        
        // 2. 트리 검사
        for(int n : nodes) {
            if(!visited.contains(n)) {  
                int[] color = dfs(n);
                
                if(color[0] == 1) answer[1]++;
                if(color[1] == 1) answer[0]++;   
            }           
        }
        
        return answer;
    }
    
    public static int[] dfs(int start) {      
       int yellow = 0;
       int red = 0;
        
       visited.add(start);
       
       boolean isYellow = (start % 2 == (graph.get(start).size() - 1) % 2);
       if(isYellow) yellow++;
       else red++;
        
       for(int n : graph.get(start)) {
           if(!visited.contains(n)) {
               int[] child = dfs(n);
               
               yellow += child[0];
               red += child[1];
           }
       }
        
       return new int[]{ yellow, red };
    }
}
