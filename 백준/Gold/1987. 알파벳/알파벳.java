import java.io.*;
import java.util.*;

public class Main {
    public static int[] dX = { 0, 0, -1, 1 };
    public static int[] dY = { 1, -1, 0, 0 };

    public static String[][] board;

    public static int R, C;
    public static int[] alpha;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]); // 세로
        C = Integer.parseInt(input[1]); // 가로

        board = new String[R][C];
        alpha = new int[26];

        for(int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                board[i][j] = line[j];
            }
        }

        dfs(0, 0, 1);
        System.out.print(count);
    }

    public static void dfs(int x, int y, int len) {
        alpha[board[x][y].charAt(0) - 'A'] = 1;
        count = Math.max(count, len);

        for(int i = 0; i < 4; i++) {
            int newX = x + dX[i];
            int newY = y + dY[i];

            if(newX < 0 || newX >= R || newY < 0 || newY >= C)
                continue;

            if(alpha[board[newX][newY].charAt(0) - 'A'] == 0) {
                alpha[board[newX][newY].charAt(0) - 'A'] = 1;
                dfs(newX, newY, len + 1);
                alpha[board[newX][newY].charAt(0) - 'A'] = 0;
            }
        }
    }
}