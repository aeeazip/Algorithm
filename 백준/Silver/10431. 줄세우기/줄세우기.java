import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int i = 0; i < T; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();

            bw.write((i + 1) + " " + solution(input) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int solution(int[] input) {
        int count = 0; // 총 몇 번 이동해야 하는지

        // 1 2 7 8 3 4 5
        for(int i = 2; i < input.length; i++) {
            int now = i;

            while(i >= 2 && input[i] < input[i - 1]) {
                int temp = input[i];
                input[i] = input[i - 1];
                input[i - 1] = temp;

                count++;
                i--;
            }

            i = now;
        }

        return count;
    }
}