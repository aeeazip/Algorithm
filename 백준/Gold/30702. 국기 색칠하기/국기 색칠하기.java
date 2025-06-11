import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N, M;
    public static String[][] flag1;
    public static String[][] flag2;
    public static boolean[][] visited;
    public static int[] dX = { -1, 1, 0, 0 };
    public static int[] dY = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        flag1 = new String[N][M];
        for(int i = 0; i < N; i++) {
            flag1[i] = br.readLine().split("");
        }

        flag2 = new String[N][M];
        for(int i = 0; i < N; i++) {
            flag2[i] = br.readLine().split("");
        }

        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && !dfs(i, j, flag2[i][j])) {
                    System.out.print("NO");
                    return;
                }
            }
        }

        System.out.print("YES");
    }

    public static boolean dfs(int x, int y, String color) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int newdX = x + dX[i];
            int newdY = y + dY[i];

            if(newdX < 0 || newdX >= N || newdY < 0 || newdY >= M) continue;
            if(!visited[newdX][newdY] && flag1[newdX][newdY].equals(flag1[x][y])) {
                if(!flag2[newdX][newdY].equals(flag2[x][y])) return false;
                if(!dfs(newdX, newdY, color)) return false;
            }
        }

        return true;
    }

}