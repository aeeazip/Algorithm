import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // dp[N][j]일때, 숫자 J로 끝나는 경우의 수
            int[][] dp = new int[10001][4];
            dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

            for(int j = 4; j <= N; j++) {
                dp[j][1] = dp[j - 1][1];
                dp[j][2] = dp[j - 2][1] + dp[j - 2][2];
                dp[j][3] = dp[j - 3][1] + dp[j - 3][2] + dp[j - 3][3];
            }

            int result = dp[N][1] + dp[N][2] + dp[N][3];
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}