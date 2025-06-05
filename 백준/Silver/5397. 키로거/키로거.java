import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            String result = solution(input);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static String solution(String[] input) {
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for(int i = 0; i < input.length; i++) {
            // 1. 커서 왼쪽으로 이동 = 왼쪽 덱 마지막 -> 오른쪽 덱 마지막으로
            if(input[i].equals("<")) {
                if(!left.isEmpty()) right.addFirst(left.removeLast());
                continue;
            }

            // 2. 커서 오른쪽으로 이동 = 오른쪽 덱 처음 -> 왼쪽 덱 마지막으로
            if(input[i].equals(">")) {
                if(!right.isEmpty()) left.addLast(right.removeFirst());
                continue;
            }

            // 3. 백스페이스 = 왼쪽 덱 마지막 삭제
            if(input[i].equals("-")) {
                if(!left.isEmpty()) left.removeLast();
                continue;
            }

            // 4. 그냥 문자열인 경우 = 왼쪽 덱 마지막에 삽입
            left.addLast(input[i].charAt(0));
        }

        // 왼쪽 덱 + 오른쪽 덱 결과 합치기
        StringBuilder sb = new StringBuilder();
        for(Character c : left) sb.append(c);
        for(Character c : right) sb.append(c);

        return sb.toString();
    }
}