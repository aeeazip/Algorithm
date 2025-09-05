import java.util.*;

class Solution {
    public static Map<String, LinkedList<String>> graph;
    public static boolean[] visited;
    public static List<String> answer;
    
    public List<String> solution(String[][] tickets) {
        // 1. 출발지 - 목적지 기록
        graph = new HashMap<>();
        for(int i = 0; i < tickets.length; i++) {
            graph.computeIfAbsent(tickets[i][0], k -> new LinkedList<>()).add(tickets[i][1]);
        }
        
        // 2. value 기준 오름차순 정렬
        List<String> keys = new ArrayList<>(graph.keySet());
        for(String key : keys) {
            Collections.sort(graph.get(key));
        }
        
        // 3. dfs 호출
        List<String> path = new ArrayList<>();
        path.add("ICN");
        answer = new ArrayList<>();
        
        dfs("ICN", path, tickets);
        return answer;
    }
    
    public static boolean dfs(String now, List<String> path, String[][] tickets) {
        if(path.size() == tickets.length + 1) { // 다 방문
            answer.addAll(new ArrayList<>(path));
            return true;
        }
        
        if (!graph.containsKey(now)) return false;

        LinkedList<String> destinations = graph.get(now);
        for (int i = 0; i < destinations.size(); i++) {
            String next = destinations.remove(i); // 티켓 사용
            path.add(next);

            if (dfs(next, path, tickets)) return true;

            path.remove(path.size() - 1); // 백트래킹
            destinations.add(i, next);     // 티켓 복원
        }
        
        return false;
    }
}