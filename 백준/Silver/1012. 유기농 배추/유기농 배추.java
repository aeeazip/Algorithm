import java.io.*;
import java.util.*;

public class Main {
    static int[] dX = { 0, 0, -1, 1 };
    static int[] dY = { 1, -1, 0, 0 };

    static boolean[][] visited; // 방문 여부
    static int[][] field; // 배추밭

    static int M; // 배추밭 가로 길이
    static int N; // 배추밭 세로 길이
    static int K; // 배추 심어진 위치 개수

    public static void main(String[] args) throws IOException {
        // 입력 첫 줄 : 테스트 케이스 T
        // 입력 둘째 줄 : 배추밭 가로 길이(M), 세로 길이(N), 배추 심어진 위치 개수(K)
        // 배추 심어진 위치 (X, Y)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");

            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            // 초기화
            initVisited();
            initField();

            // 배추 심은 위치 기록
            for(int j = 0; j < K; j++) {
                String[] position = br.readLine().split(" ");
                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);

                field[x][y] = 1;
            }

            // dfs 호출
            int count = 0;

            for(int x = 0; x < M; x++) {
                for(int y = 0; y < N; y++) {
                    if(!visited[x][y] && field[x][y] == 1) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void initVisited() {
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void initField() {
        field = new int[M][N];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                field[i][j] = 0;
            }
        }
    }
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;

        if(field[x][y] == 0)
            return;

        for(int i = 0; i < 4; i++) {
            int newdX = x + dX[i];
            int newdY = y + dY[i];

            if(newdX < 0 || newdX >= M || newdY < 0 || newdY >= N) {
                continue;
            }

            if(!visited[newdX][newdY] && field[newdX][newdY] == 1)
                dfs(newdX, newdY);
        }
    }
}