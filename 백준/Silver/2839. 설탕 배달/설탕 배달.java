import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[5001];

        dp[1] = dp[2] = dp[4] = -1; // 1, 2, 4는 3과 5로 표현 불가
        dp[3] = dp[5] = 1;

        for(int i = 6; i <= N; i++) {
            if(dp[i - 5] != -1) {
                dp[i] = dp[i - 5] + 1;
                continue;
            }

            if(dp[i - 3] != -1) {
                dp[i] = dp[i - 3] + 1;
                continue;
            }

            dp[i] = -1;
        }

        System.out.print(dp[N]);
    }
}