import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[n]; // i번째값을 포함할 때의 증가하는 부분 수열의 개수
        Arrays.fill(dp, 1); // 자기 자신을 포함해야 하므로 최소 1개 확보

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();
        System.out.print(max);

    }
}