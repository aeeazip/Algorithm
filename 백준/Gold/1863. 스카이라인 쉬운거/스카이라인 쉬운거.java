import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            String[] pos = br.readLine().split(" ");
            int y = Integer.parseInt(pos[1]); // y좌표

            // y좌표가 0이면 스택 전부 비우기
            if(!stack.isEmpty() && y == 0) {
                result += stack.size();
                stack.clear();
            }

            // y좌표가 top보다 작으면 stack 계속 비우기
            while(!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                result++;
            }

            // 스택이 비어있으면서 y좌표가 0이 아니거나
            // 스택에 값이 있지만 꼭대기값과 y좌표 값이 다르면
            // 스택에 삽입
            if((stack.isEmpty() && y != 0) || (!stack.isEmpty() && stack.peek() != y)) {
                stack.push(y);
            }
        }

        result += stack.size();
        System.out.print(result);
    }
}