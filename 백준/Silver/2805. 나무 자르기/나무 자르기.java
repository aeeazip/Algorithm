import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 적어도 M미터를 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 나무의 수
        int M = Integer.parseInt(input[1]); // 집으로 가져가려고 하는 나무 길이

        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int result = 0;
        int left = 1;
        int right = arr[N - 1];

        while(left <= right) {
            int mid = (left + right) / 2;

            long len = 0;
            for(int i = 0; i < N; i++) {
                if(arr[i] - mid > 0) len += (arr[i] - mid);
            }

            if(len < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
                result = Math.max(result, mid);
            }
        }

        System.out.print(result);
    }
}