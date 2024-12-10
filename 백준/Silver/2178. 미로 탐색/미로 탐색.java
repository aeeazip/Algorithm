import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] dX = { 0, 0, 1, -1 };
    static int[] dY = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N  = Integer.parseInt(input[0]);
        M  = Integer.parseInt(input[1]);

        int[][] graph = new int[N + 1][M + 1];
        boolean[][] visited = new boolean[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            input = br.readLine().split("");
            for(int j = 1; j <= M; j++) {
                graph[i][j] = Integer.parseInt(input[j - 1]);
                visited[i][j] = false;
            }
        }

        int result = dfs(graph, visited, 1);
        System.out.print(result);
    }

    // DFS
    public static int dfs(int[][] graph, boolean[][] visited, int start) {
        int[][] distance = new int[N + 1][M + 1]; // 시작 위치부터 1칸을 포함한 최소 이동 칸 수

        distance[start][start] = 1;
        visited[start][start] = true;
        Queue<String> queue = new LinkedList<>();
        queue.add(start + "," + start);

        while(!queue.isEmpty()) {
            String[] first = queue.poll().split(",");
            int nowX = Integer.parseInt(first[0]);
            int nowY = Integer.parseInt(first[1]);

            // System.out.println("now : " + nowX + ", " + nowY);

            for(int i = 0; i < 4; i++) {
                int newX = nowX + dX[i];
                int newY = nowY + dY[i];

                if(newX >= 1 && newX <= N && newY >= 1 && newY <= M) {
                    if(graph[newX][newY] != 0 && !visited[newX][newY]) {
                        distance[newX][newY] = distance[nowX][nowY] + 1;
                        visited[newX][newY] = true;
                        queue.add(newX + "," + newY);
                    }
                }
            }
        }

        return distance[N][M];
    }
}