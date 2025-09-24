import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int N, M;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dX = { 1, -1, 0, 0 };
    public static int[] dY = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = info[0];
        M = info[1];

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < info[2]; i++) {
            int[] pos = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            map[pos[0] - 1][pos[1] - 1] = 1;
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    max = Math.max(dfs(i, j) + 1, max);
                }
            }
        }

        System.out.print(max);
    }

    public static int dfs(int x, int y) {
        int count = 0;
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int newdX = x + dX[i];
            int newdY = y + dY[i];

            if(newdX < 0 || newdX >= N || newdY < 0 || newdY >= M) continue;
            if(!visited[newdX][newdY] && map[newdX][newdY] == 1) {
                count += dfs(newdX, newdY) + 1;
            }
        }

        return count;
    }

}