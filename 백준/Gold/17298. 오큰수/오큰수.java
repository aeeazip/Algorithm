import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] num = new int[N + 1];
        int[] result = new int[N + 1];

        for(int i = 1; i < N + 1; i++) {
            num[i] = Integer.parseInt(input[i - 1]);
            result[i] = -1;
        }

        // 시간 초과;;;
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i < N + 1; i++) {
            while(!stack.empty() && num[stack.peek()] < num[i]) {
                int n = stack.pop();
                result[n] = num[i];
            }

            stack.push(i);
        }

        for(int i = 1; i < N + 1; i++) {
            bw.write(result[i] + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}