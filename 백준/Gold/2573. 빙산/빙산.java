import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 12시 26분 start
public class Main {
    public static int[][] map;
    public static int N, M;
    public static int[] dX = { -1, 1, 0, 0 };
    public static int[] dY = { 0, 0, -1, 1 };
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int year = 0;
        while(true) {
            int count = countIceberg();
            if (count == 0 || count >= 2) {
                if (count == 0) year = 0;
                break;
            }

            year++;
            melt();
        }

        System.out.print(year);
    }

    // 빙산 덩어리 갯수 (다 녹았으면 0)
    public static int countIceberg() {
        int count = 0;
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int newdX = x + dX[i];
            int newdY = y + dY[i];

            if(newdX < 0 || newdX >= N || newdY < 0 || newdY >= M) continue;
            if(!visited[newdX][newdY] && map[newdX][newdY] != 0) {
                dfs(newdX, newdY);
            }
        }
    }

    public static void melt() {
        // 1. map 복사
        int[][] mapClone = map.clone();
        for(int i = 0; i < N; i++) {
            mapClone[i] = map[i].clone();
        }

        // 2. 빙산 녹이기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(mapClone[i][j] == 0) continue;

                int now = mapClone[i][j];
                for(int k = 0; k < 4; k++) {
                    int newdX = i + dX[k];
                    int newdY = j + dY[k];

                    if(newdX < 0 || newdX >= N || newdY < 0 || newdY >= M) continue;
                    if(mapClone[newdX][newdY] == 0) now--;
                }

                if(now < 0) now = 0;
                map[i][j] = now;
            }
        }
    }
}