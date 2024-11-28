import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    static int N;
    static long[][] memo; // 인덱스 저장용 메모
    static long[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        memo = new long[N + 1][3];
        cost = new long[N + 1][3];

        for(int i = 1; i < N + 1; i++) { // input 입력받기
            String[] input = br.readLine().split(" ");

            cost[i][0] = Long.parseLong(input[0]); // 빨강으로 칠하는 비용
            cost[i][1] = Long.parseLong(input[1]); // 초록으로 칠하는 비용
            cost[i][2] = Long.parseLong(input[2]); // 파랑으로 칠하는 비용

            memo[i][0] = Math.min(memo[i - 1][1], memo[i - 1][2]) + cost[i][0];
            memo[i][1] = Math.min(memo[i - 1][0], memo[i - 1][2]) + cost[i][1];
            memo[i][2] = Math.min(memo[i - 1][0], memo[i - 1][1]) + cost[i][2];
        }

        long result = Math.min(memo[N][0], Math.min(memo[N][1], memo[N][2]));
        System.out.print(result);
    }
}