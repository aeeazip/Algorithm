import java.util.*;

class Solution {
    public static int solution(int m, int n, int[][] puddles) {
         int mod = 1000000007;
        int[][] dp = new int[n + 1][m + 1];

        // 물 웅덩이 표시
        for(int[] p : puddles) {
            int x = p[1];
            int y = p[0];
            dp[x][y] = -1;
        }

        dp[1][1] = 1; // 출발점

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(i == 1 && j == 1) continue;

                if(dp[i][j] == -1) { // 물에 잠긴 곳
                    dp[i][j] = 0;
                } else {
                    if(i > 1) { dp[i][j] = (dp[i][j] + dp[i-1][j]) % mod; }
                    if(j > 1) { dp[i][j] = (dp[i][j] + dp[i][j-1]) % mod; }
                }
            }
        }

        return dp[n][m];

    }
}