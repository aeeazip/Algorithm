import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] dpLeft = new int[N][M]; // 왼쪽 대각선에서 온 경우
        int[][] dpRight = new int[N][M]; // 오른쪽 대각선에서 온 경우
        int[][] dpDown = new int[N][M]; // 위에서 온 경우

        for(int i = 0; i < M; i++) {
            dpLeft[0][i] = arr[0][i];
            dpRight[0][i] = arr[0][i];
            dpDown[0][i] = arr[0][i];
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // 현재 칸이 위에서 온 경우 = 이전 방향은 left / right
                dpDown[i][j] = Integer.MAX_VALUE;
                if(j - 1 >= 0) dpDown[i][j] = Math.min(dpDown[i][j], dpLeft[i - 1][j - 1] + arr[i][j]);
                if(j + 1 < M) dpDown[i][j] = Math.min(dpDown[i][j], dpRight[i - 1][j + 1] + arr[i][j]);

                // 현재 칸이 왼쪽 대각선에서 온 경우 = 이전 방향은 right / down
                if(j + 1 < M) dpLeft[i][j] = Math.min(dpRight[i - 1][j + 1], dpDown[i - 1][j]) + arr[i][j];
                else dpLeft[i][j] = Integer.MAX_VALUE;

                // 현재 칸이 오른쪽 대각선에서 온 경우 = 이전 방향은 left / down
                if(j - 1 >= 0) dpRight[i][j] = Math.min(dpLeft[i - 1][j - 1], dpDown[i - 1][j]) + arr[i][j];
                else dpRight[i][j] = Integer.MAX_VALUE;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++) {
            min = Math.min(Math.min(dpLeft[N - 1][i], dpRight[N - 1][i]), Math.min(dpDown[N - 1][i], min));
        }

        System.out.print(min);

    }
}