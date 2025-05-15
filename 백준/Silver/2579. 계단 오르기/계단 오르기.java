import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] steps = new int[n + 2];
        for(int i = 1; i < n + 1; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        // 계단은 한 번에 한 계단씩 / 두 계단씩
        // 연속된 3개 밟으면 안됨
        // 마지막 계단은 무조건 밟아야 함
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = steps[1];
        dp[2] = dp[1] + steps[2];

        for(int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + steps[i], // i - 2 -> i
                    dp[i - 3] + steps[i - 1] + steps[i]); // i - 3 -> i - 1 -> i
        }

        System.out.print(dp[n]);
    }
}