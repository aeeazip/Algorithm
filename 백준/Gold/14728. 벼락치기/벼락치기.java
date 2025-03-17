import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 단원 개수
        int T = Integer.parseInt(input[1]); // 공부할 수 있는 총 시간

        int[][] chapter = new int[N][2];
        long[][] dp = new long[N][T + 1]; // N번째까지 봤을 때, T 시간 공부해서 얻을 수 있는 최대 점수

        for(int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            chapter[i][0] = Integer.parseInt(info[0]); // 각 단원 별 예상 공부 시간
            chapter[i][1] = Integer.parseInt(info[1]); // 단원 문제의 배점
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < T + 1; j++) {
                if(chapter[i][0] > j) {
                    dp[i][j] = (i == 0) ? 0 : dp[i - 1][j];
                }

                if(chapter[i][0] <= j) {
                    long notSelected = (i == 0) ? 0 : dp[i - 1][j];
                    long selected = (i == 0) ? chapter[i][1] : chapter[i][1] + dp[i - 1][j - chapter[i][0]];
                    dp[i][j] = Math.max(notSelected, selected);
                }
            }
        }

        System.out.print(dp[N - 1][T]);
    }
}