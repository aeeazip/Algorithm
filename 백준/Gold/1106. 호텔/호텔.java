import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int C = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);


        /*
            인덱스 i명의 고객을 얻기 위해 필요한 최소 금액
            최소 C명으로 늘리기 위함이니 C보다 클 수 있음 (배열 크기 넉넉히 설정)
         */
        int[] dp = new int[C + 101]; // 인덱스 i명의 고객을 얻기 위해 필요한 최소 금액
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int cost = Integer.parseInt(input[0]); // 홍보 비용
            int customer = Integer.parseInt(input[1]); // 얻을 수 있는 고객

            for(int j = customer; j < dp.length; j++) {
                if(dp[j - customer] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - customer] + cost);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = C; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }

        System.out.print(min);
    }
}