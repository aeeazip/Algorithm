import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 정점(노드)의 개수
        int M = Integer.parseInt(input[1]); // 간선의 개수
        int V = Integer.parseInt(input[2]); // 탐색 시작할 정점 번호

        int[][] graph = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            String[] edges = br.readLine().split(" ");
            int x = Integer.parseInt(edges[0]);
            int y = Integer.parseInt(edges[1]);

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(graph, visited, V, N);
        System.out.println();

        visited = new boolean[N + 1]; // 방문 배열 초기화
        bfs(graph, visited, V, N);
    }

    // DFS
    public static void dfs(int[][] graph, boolean[] visited, int start, int end) {
        visited[start] = true;
        System.out.print(start + " ");

        for(int i = 1; i <= end; i++) {
            if(graph[start][i] == 1 && !visited[i]) {
                dfs(graph, visited, i, end);
            }
        }
    }

    // BFS
    public static void bfs(int[][] graph, boolean[] visited, int start, int end) {
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[start] = true;
        queue.add(start);
        System.out.print(start + " ");

        while(!queue.isEmpty()) {
            start = queue.poll();

            for(int i = 1; i <= end; i++) {
                if(graph[start][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    System.out.print(i + " ");
                }
            }
        }
    }
}