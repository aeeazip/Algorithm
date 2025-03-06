import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            solution(1, n, "1");
            System.out.println();
        }
    }

    public static void solution(int now, int N, String exp) {
        if(now == N) {
            String result = exp;
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < result.length(); i++) {
                if(i == 0) { // 첫번째 숫자는 그대로 넣기
                    list.add(Integer.parseInt(String.valueOf(result.charAt(i))));
                } else if(result.charAt(i) == '+') {
                    list.add(Integer.parseInt(String.valueOf(result.charAt(i + 1))));
                } else if(result.charAt(i) == '-') {
                    list.add(Integer.parseInt(String.valueOf(result.charAt(i + 1))) * -1);
                } else if(result.charAt(i) == ' ') {
                    String last = String.valueOf(list.get(list.size() - 1));
                    last += String.valueOf(result.charAt(i + 1));
                    list.remove(list.size() - 1);
                    list.add(Integer.parseInt(last));
                }
            }

            int sum = list.stream().mapToInt(Integer::intValue).sum();
            if(sum == 0) {
                System.out.println(result);
            }

            return;
        }

        solution(now + 1, N, exp + " " + (now + 1));
        solution(now + 1, N, exp + "+" + (now + 1));
        solution(now + 1, N, exp + "-" + (now + 1));
    }
}