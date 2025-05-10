import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N % 2 != 0) { // N이 홀수인 경우는 만들 수 없음
            System.out.print("0");
            return;
        }

        int[] dp = new int[N + 1];
        dp[1] = 0;
        dp[2] = 3; // 3 * 2를 만들 수 있는 경우의 수

        /*
         N = 2) 3
         
         N = 4) dp[2] * dp[2] 
                + 2(4를 만드는 특수한 방법)
                
         N = 6) dp[2] * dp[4] 
                + dp[2](2를 만드는 일반적 방법) * 2(4를 만드는 특수한 방법) 
                + 2(6을 만드는 특수한 방법)
                
         N = 8) dp[2] * dp[6] 
                + dp[2](2를 만드는 일반적 방법) * 2(6을 만드는 특수한 방법) 
                + dp[4](4를 만드는 일반적 방법) * 2(4를 만드는 특수한 방법)
                + 2 (8을 만드는 특수한 방법)
             
         N = 10) dp[2] * dp[8] 
                + dp[2](2를 만드는 일반적 방법) * 2(8을 만드는 특수한 방법) 
                + dp[4](4를 만드는 일반적 방법) * 2(6를 만드는 특수한 방법)
                + dp[6](6을 만드는 일반적 방법) * 2(4를 만드는 특수한 방법)
                + 2 (10을 만드는 특수한 방법)   
         */
        for(int i = 4; i <= N; i += 2) {
            int result = 3 * dp[i - 2] + 2;
            for(int j = 2; j < i - 2; j += 2) {
                result += 2 * dp[j];
            }
            dp[i] = result;
        }

        System.out.print(dp[N]);
    }
}