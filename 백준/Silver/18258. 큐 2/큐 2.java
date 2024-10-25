import java.io.*;
import java.util.*;

public class Main {
    // 해당 문제는 단순히 Queue로 풀 수 없음 : back 즉 큐의 가장 뒤에 있는 정수를 출력할 방법이 없기 때문
    // 방법 1) LinkedList로 구현
    // 방법 2) 배열을 사용해 직접 구현

    // 방법 1) LinkedList로 구현
    static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            switch(command) {
                case "push":
                    push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    bw.write(pop() + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    bw.write(queue.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    bw.write(front() + "\n");
                    break;
                case "back":
                    bw.write(back() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void push(int n) {
        queue.add(n);
    }

    public static int pop() {
        if(queue.isEmpty())
            return -1;
        return queue.poll();
    }

    public static int front() {
        if(queue.isEmpty())
            return -1;
        return queue.peek();
    }

    public static int back() {
        if(queue.isEmpty())
            return -1;
        return queue.peekLast();
    }
}

