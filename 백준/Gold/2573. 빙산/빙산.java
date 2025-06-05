import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static int N, M;
    public static int[][] map;
    public static List<int[]> iceList;
    public static boolean[][] visited;
    public static int[] dX = { -1, 1, 0, 0 };
    public static int[] dY = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        iceList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] != 0) iceList.add(new int[]{ i, j });
            }
        }

        int year = 1;

        while(true) {
            // 1. 다 녹았는지 체크
            if(iceList.isEmpty()) {
                System.out.print(0);
                return;
            }

            // 2. 빙산 녹이기
            melting();

            // 3. dfs로 빙산 덩어리 세기
            visited = new boolean[N][M];
            int count = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(!visited[i][j] && map[i][j] != 0) {
                        count += dfs(i, j);
                    }
                }
            }

            if(count >= 2) {
                System.out.print(year);
                return;
            }

            year++;
        }
    }

    public static void melting() {
        int[] melt = new int[iceList.size()];

        for(int i = 0; i < iceList.size(); i++) {
            int count = 0;

            for(int j = 0; j < 4; j++) {
                int newdX = iceList.get(i)[0] + dX[j];
                int newdY = iceList.get(i)[1] + dY[j];

                if(newdX >= 0 && newdX < N && newdY >= 0 && newdY < M && map[newdX][newdY] == 0)
                    count++;
            }

            melt[i] = count;
        }

        List<int[]> newList = new ArrayList<>();
        for(int i = 0; i < iceList.size(); i++) {
            int x = iceList.get(i)[0];
            int y = iceList.get(i)[1];
            map[x][y] = Math.max(0, map[x][y] - melt[i]);
            if(map[x][y] != 0) newList.add(new int[] { x, y });
        }

        iceList = newList;
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int newdX = x + dX[i];
            int newdY = y + dY[i];

            if(newdX < 0 || newdX >= N || newdY < 0 || newdY >= M) continue;
            if(!visited[newdX][newdY] && map[newdX][newdY] != 0) {
                dfs(newdX, newdY);
            }
        }

        return 1;
    }

}