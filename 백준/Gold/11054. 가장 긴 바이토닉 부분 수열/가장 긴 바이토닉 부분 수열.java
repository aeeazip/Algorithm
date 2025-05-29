import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 0 ~ N-1까지 i번째 포함하는 증가하는 바이토닉 부분 수열 길이
        int[] upDp = new int[N];
        Arrays.fill(upDp, 1);

        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    upDp[i] = Math.max(upDp[j] + 1, upDp[i]);
                }
            }
        }

        // N-1 ~ 0까지 i번째 포함하는 증가하는 바이토닉 부분 수열 길이 = (감소하는 부분 수열 길이)
        int[] downDp = new int[N];
        Arrays.fill(downDp, 1);

        for(int i = N - 2; i >= 0; i--) {
            for(int j = N - 1; j > i; j--) {
                if(arr[i] > arr[j]) {
                    downDp[i] = Math.max(downDp[j] + 1, downDp[i]);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, upDp[i] + downDp[i] - 1); // i번째 2번 포함되므로 1번 빼주기
        }

        System.out.print(max);
    }
}