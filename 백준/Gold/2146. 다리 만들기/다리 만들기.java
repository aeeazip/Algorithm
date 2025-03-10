import java.io.*;
import java.util.*;

public class Main {
    public static int[] dX = {0, 0, -1, 1};
    public static int[] dY = {1, -1, 0, 0};
    public static int N;
    public static int[][] map;
    public static boolean[][] visited;
    public static List<List<int[]>> islands = new ArrayList<>();
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]); // 0 = 바다, 1 = 육지
            }
        }

        // 1. 섬 분류 후 해안가 정보 저장
        int count = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    List<int[]> coastlines = new ArrayList<>();
                    dfs(i, j, count, coastlines);
                    islands.add(coastlines);
                    count++;
                }
            }
        }

        // 2. 각 섬마다 BFS 실행해서 최단 다리 찾기
        for(int i = 0; i < islands.size(); i++) {
            for(int[] pos : islands.get(i)) {
                bfs(pos[0], pos[1], map[pos[0]][pos[1]]);
            }
        }

        System.out.print(min);
    }

    public static void dfs(int x, int y, int count, List<int[]> coastlines) {
        visited[x][y] = true;
        map[x][y] = count;
        boolean isCoast = false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dX[i];
            int ny = y + dY[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            if (map[nx][ny] == 0) isCoast = true;

            if (!visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny, count, coastlines);
            }
        }

        if (isCoast) {
            coastlines.add(new int[]{x, y});
        }
    }


    public static void bfs(int x, int y, int islandId) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];
        visited[x][y] = true;
        queue.add(new int[]{ x, y, 0 });

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY  = now[1];
            int distance = now[2];

            // 현재가 해안가가 아니고 다른 섬을 만났을 때
            if(map[nowX][nowY] != 0 && map[nowX][nowY] != islandId) {
                min = Math.min(min, distance - 1);
                return;
            }

            if(distance > min) return;

            for (int i = 0; i < 4; i++) {
                int newdX = now[0] + dX[i];
                int newdY = now[1] + dY[i];

                if(newdX < 0 || newdX >= N || newdY < 0 || newdY >= N) continue;
                // 같은 섬이 아니면 방문
                if (!visited[newdX][newdY] && map[newdX][newdY] != islandId) {
                    visited[newdX][newdY] = true;
                    queue.add(new int[]{ newdX, newdY, distance + 1 });
                }
            }
        }
    }
}
