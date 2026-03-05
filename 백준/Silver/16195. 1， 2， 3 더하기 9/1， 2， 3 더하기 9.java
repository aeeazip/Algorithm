import java.io.*;
import java.util.*;

public class Main {
    public static int[] item = {1, 2, 3};
    public static int r;
    public static List<Integer> bucket;
    public static int target;
    public static int result;
    public static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[] info = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();


            dp = new long[info[0] + 1][info[1] + 1];
            dp[0][0] = 1;

            for(int j = 1; j < info[0] + 1; j++) {
                for(int k = 1; k < info[1] + 1; k++) {
                    if(j - 1 >= 0) dp[j][k] += dp[j - 1][k - 1];
                    if(j - 2 >= 0) dp[j][k] += dp[j - 2][k - 1];
                    if(j - 3 >= 0) dp[j][k] += dp[j - 3][k - 1];

                    dp[j][k] %= 1000000009;
                }
            }

            long result = 0;
            for(int j = 1; j < info[1] + 1; j++) {
                result += dp[info[0]][j];
                result %= 1000000009;
            }

            bw.write(result + "\n");
        }

        bw.flush();
    }
}