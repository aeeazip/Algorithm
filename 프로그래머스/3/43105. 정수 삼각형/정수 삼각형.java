import java.util.*;

class Solution {
    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length + 1][];
        for(int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length + 1];
        }

        dp[0][0] = triangle[0][0];
        int lastI = triangle.length - 1;
        int lastJ = triangle[triangle.length - 1].length - 1;

        // 마지막 줄에 대해 다 호출
        for(int i = 0; i < lastJ; i++) {
            findMaxSum(triangle, dp, lastI, i);
        }

        int max = 0;
        for(int i = 0; i < lastJ; i++) {
            if(dp[lastI][i] > max) {
                max = dp[lastI][i];
            }
        }

        return max;
    }

    public static int findMaxSum(int[][] triangle, int[][] dp, int i, int j) {
        // System.out.println(i + " " + j);
        if(dp[i][j] != 0 || (i == 0 && j == 0))  {
            return dp[i][j];
        }

        if(j == 0) {
            dp[i][j] = triangle[i][j] + findMaxSum(triangle, dp, i - 1, 0);
        } else if(j == triangle[i].length - 1) {
            dp[i][j] = triangle[i][j] + findMaxSum(triangle, dp, i - 1, j - 1);
        } else {
            int left = triangle[i][j] + findMaxSum(triangle, dp, i - 1, j - 1);
            int right = triangle[i][j] + findMaxSum(triangle, dp, i - 1, j);
            dp[i][j] = Math.max(left, right);
        }

        // System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
        return dp[i][j];
    }
}