import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        long[] arr = new long[K];
        for(int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long result = 0;
        long left = 1;
        long right = arr[K - 1]; // max값

        while(left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for(int i = 0; i < K; i++) { count += (arr[i] / mid); }

            if(count < N) {
                right = mid - 1;
            } else {
                left = mid + 1;
                result = Math.max(mid, result);
            }
        }

        System.out.print(result);
    }
}