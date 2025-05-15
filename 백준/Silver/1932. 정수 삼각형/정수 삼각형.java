import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(arr[i], -1);
        }

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < input.length; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i + 1; j++) {
                int left = 0, right = 0;

                // 현재값이 대각선 왼쪽에서 내려옴
                if(arr[i - 1][j] != -1) {
                    left = dp[i - 1][j] + arr[i][j];
                }

                // 현재값이 대각선 오른쪽에서 내려옴
                if(j >= 1 && arr[i - 1][j - 1] != -1) {
                    right = dp[i - 1][j - 1] + arr[i][j];
                }

                dp[i][j] = Math.max(left, right);
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        System.out.print(max);
    }
}