import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static long[][] dp;
    public static int[][] item;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 물품의 개수
        int K = Integer.parseInt(input[1]); // 준서가 버틸 수 있는 무게

        dp = new long[N + 1][K + 1]; // N번째 물건까지 봤을 때, 가방에 담을 수 있는 무게가 K + 1인 경우의 최대 가치
        item = new int[N + 1][2];

        for(int i = 1; i < N + 1; i++) {
            input = br.readLine().split(" ");
            item[i][0] = Integer.parseInt(input[0]); // 물건의 무게
            item[i][1] = Integer.parseInt(input[1]); // 물건의 가치
        }

        // bottom-up 방식
        for(int i = 1; i <= N; i++) { // 물건 개수
            for(int j = 0; j < K + 1; j++) { // 무게
                if(item[i][0] > j) { // 담을 수 없는 경우 = 현재 물건의 무게 > 가방 남은 여유 무게
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], item[i][1] + dp[i - 1][j - item[i][0]]);
                }
            }
        }

        System.out.print(dp[N][K]);
    }
}
