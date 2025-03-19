import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]); // 경산까지 거쳐갈 도시 개수
        int K = Integer.parseInt(str[1]); // 자선 여행에 보낼 수 있는 시간

        long[][] dp = new long[N + 1][K + 1]; // dp[i][j] : i번째 구간까지 j분 이내에 얻을 수 있는 최대 모금액
        int[][] walk = new int[N][2]; // 도보 시간, 모금액
        int[][] bike = new int[N][2]; // 자전거 시간, 모금액

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            walk[i][0] = Integer.parseInt(info[0]);  // 도보 시간
            walk[i][1] = Integer.parseInt(info[1]);  // 도보 모금액
            bike[i][0] = Integer.parseInt(info[2]);  // 자전거 시간
            bike[i][1] = Integer.parseInt(info[3]);  // 자전거 모금액
        }

        for(int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;

        for (int i = 0; i < N; i++) { // 각 구간에 대해
            for (int j = 0; j <= K; j++) { // 현재까지 쓴 시간
                if(dp[i][j] == -1) continue;

                // 도보로 이동
                int newTime = j + walk[i][0];
                if(newTime <= K) {
                    dp[i + 1][newTime] = Math.max(dp[i + 1][newTime], dp[i][j] + walk[i][1]);
                }

                newTime = j + bike[i][0];
                if(newTime <= K) {
                    dp[i + 1][newTime] = Math.max(dp[i + 1][newTime], dp[i][j] + bike[i][1]);
                }
            }
        }

        // K분 이하 시간에서 최대 모금액을 얻을 수 있으므로 일일이 찾아야 함
        long result = 0;
        for (int j = 0; j <= K; j++) {
            result = Math.max(result, dp[N][j]);
        }

        System.out.print(result);
    }
}
