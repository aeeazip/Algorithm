import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] tower = new int[N + 1];
        int[] result = new int[N + 1];

        String[] input= br.readLine().split(" ");

        for(int i = 1; i < N + 1; i++) {
            tower[i] = Integer.parseInt(input[i - 1]);
            result[i] = 0;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = N; i > 0; i--) {
            while(!stack.empty() && tower[stack.peek()] < tower[i]) {
                int n = stack.pop();
                result[n] = i;
            }

            stack.push(i);
        }

        for(int i = 1; i < N + 1; i++) {
            System.out.print(result[i] + " ");
        }

    }
}