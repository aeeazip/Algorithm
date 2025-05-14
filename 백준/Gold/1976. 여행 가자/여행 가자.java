import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int[][] map;
    public static int[] plan;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        for(int i = 1; i < N + 1; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j + 1] = Integer.parseInt(input[j]);
            }
        }

        plan = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String result = bfs();
        System.out.print(result);
    }

    public static String bfs() {
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1]; // 여행 계획 첫 도시에서의 최단 거리
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(plan[0]);
        distance[plan[0]] = 0;

        while(!queue.isEmpty()) {
            int first = queue.poll();
            visited[first] = true;

            for(int i = 1; i < N + 1; i++) {
                if(!visited[i] && map[first][i] == 1) { // 아직 방문 안했고, 도시 연결되어있음
                    distance[i] = distance[first] + 1;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        for(int i = 0; i < M; i++) {
            if(distance[plan[i]] == Integer.MAX_VALUE)
                return "NO";
        }

        return "YES";
    }
}