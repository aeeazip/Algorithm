import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        int[] count = new int[100001];
        int start = 0;
        int max = 0;

        for(int i = 0; i < N; i++) { // i = end (슬라이딩 윈도우)
            int index = Integer.parseInt(input[i]);
            count[index]++;

            while(count[index] > K) {
                int startIndex = Integer.parseInt(input[start]);
                count[startIndex]--;
                start++;
            }

            max = Math.max(max, i - start + 1);
        }

        System.out.print(max);

    }
}