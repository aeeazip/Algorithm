import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3]; // 빨, 초, 파
        for(int i = 0; i < N; i++) {
            cost[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][][] dp = new int[N][3][3]; // N * 현재색 * 시작색
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], 1000000);
            }
        }

        for(int i = 0; i < 3; i++) {
            dp[0][i][i] = cost[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                // RED
                dp[i][0][j] = Math.min(dp[i - 1][1][j], dp[i - 1][2][j]) + cost[i][0];

                // GREEN
                dp[i][1][j] = Math.min(dp[i - 1][0][j], dp[i - 1][2][j]) + cost[i][1];

                // BLUE
                dp[i][2][j] = Math.min(dp[i-1][0][j], dp[i-1][1][j]) + cost[i][2];
            }
        }

        int result = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == j) continue; // 첫 집과 마지막 집 색깔은 달라야 함
                result = Math.min(result, dp[N - 1][i][j]);
            }
        }

        System.out.print(result);



    }
}