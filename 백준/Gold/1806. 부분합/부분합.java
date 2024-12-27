import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        String[] num = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }

        int start = 0, end = 0, sum = 0;
        int answer = Integer.MAX_VALUE;

        while (end < N) {
            // 윈도우 확장: end를 오른쪽으로 이동하며 sum에 포함
            sum += arr[end++];

            // 조건 만족: sum >= S일 경우 최소 길이 갱신 및 윈도우 축소
            while (sum >= S) {
                answer = Math.min(answer, end - start);
                sum -= arr[start++];
            }
        }

        // S를 만족하는 부분합이 없는 경우 처리
        System.out.print(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}