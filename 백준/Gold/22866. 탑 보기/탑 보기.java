import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] building = new int[N + 1]; // 건물 높이
        int[] visible = new int[N + 1]; // 볼 수 있는 건물 개수
        int[] near = new int[N + 1]; // 볼 수 있는 가장 거리가 가까운 건물 번호
        Stack<Integer> stack;
        
        building[0] = 0;
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            building[i + 1] = Integer.parseInt(input[i]);
        }

        // 왼쪽 검사
        stack = new Stack<>();
        for(int i = 1; i < N + 1; i++) {
            while(!stack.empty() && building[stack.peek()] <= building[i]) {
                stack.pop();
            }

            near[i] = stack.size() != 0 ? stack.peek() : N + 1;
            visible[i] = stack.size();
            stack.push(i);
        }

        // 오른쪽 검사
        stack = new Stack<>();
        for(int i = N; i > 0; i--) {
            while(!stack.empty() && building[stack.peek()] <= building[i]) {
                stack.pop();
            }

            if(stack.size() != 0) {
                near[i] = Math.abs(i - near[i]) <= Math.abs(i - stack.peek()) ? near[i] : stack.peek();
            }
            
            visible[i] += stack.size();
            stack.push(i);
        }

        for(int i = 1; i < N + 1; i++) {
            if(visible[i] == 0) {
                bw.write("0\n");
                continue;
            }

            bw.write(visible[i] + " " + near[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}