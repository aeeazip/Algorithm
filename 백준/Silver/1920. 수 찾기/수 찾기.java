import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long [] A = new long[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) A[i] = Long.parseLong(input[i]);

        int M = Integer.parseInt(br.readLine());
        long[] arr = new long[M];
        input = br.readLine().split(" ");
        for(int i = 0; i < M; i++) arr[i] = Long.parseLong(input[i]);

        // 1. A 정렬
        Arrays.sort(A);

        // 2. 이분탐색
        for(long num : arr) {
            int left = 0;
            int right = N - 1;
            boolean isIn = false;

            while(left <= right) {
                int mid = (left + right) / 2;

                if(num > A[mid]) {
                    left = mid + 1;
                }
                else if(num < A[mid]) {
                    right = mid - 1;
                }
                else {
                    isIn = true;
                    break;
                }
            }

            if(isIn) bw.write("1\n");
            else bw.write("0\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

