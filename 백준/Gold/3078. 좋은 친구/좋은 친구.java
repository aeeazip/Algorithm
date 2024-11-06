import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]); // 등수 차이 max

        Queue<Integer>[] queues = new Queue[21];
        for(int i = 0; i < 21; i++) {
            queues[i] = new LinkedList<>();
        }

        long count = 0;
        for(int i = 0; i < N; i++) {
            int length = br.readLine().length();

            while(!queues[length].isEmpty() && i - queues[length].peek() > K){
                queues[length].poll();
            }

            count += queues[length].size();
            queues[length].offer(i);
        }

        System.out.print(count);
    }
}