import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] building = new int[N + 1];

        building[0] = 0;
        for(int i = 1; i < N + 1; i++) {
            building[i] = Integer.parseInt(br.readLine());
        }

        // 10 3 7 4 12 2
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        for(int i = 1; i < N + 1; i++) {
            while(!stack.empty() && stack.peek() <= building[i]) {
                stack.pop();
            }

            result += stack.size();
            stack.push(building[i]);
        }

        System.out.print(result);
    }
}