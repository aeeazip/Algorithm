import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 벨트에 놓인 접시의 수
        int d = Integer.parseInt(input[1]); // 초밥 가짓수
        int k = Integer.parseInt(input[2]); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(input[3]); // 쿠폰 번호

        List<String> str = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            str.add(br.readLine());
        }

        // 첫 번째 윈도우 검사
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++) {
            map.put(str.get(i), map.getOrDefault(str.get(i), 0) + 1);
        }

        int max = map.size();
        if(!map.containsKey(String.valueOf(c))) max++;

        // 나머지 윈도우 검사
        for(int i = 1; i < N; i++) {
            // i - 1 삭제
            if(map.get(str.get(i - 1)) != null) {
                int n = map.get(str.get(i - 1));
                if(n == 1) map.remove(str.get(i - 1));
                else map.put(str.get(i - 1), n - 1);
            }

            int index = (i + k - 1) % N;
            map.put(str.get(index), map.getOrDefault(str.get(index), 0) + 1);

            // 쿠폰 포함되어있는지 검사
            if(!map.containsKey(String.valueOf(c))) {
                max = Math.max(max, map.size() + 1);
            }
            else {
                max = Math.max(max, map.size());
            }
        }

        System.out.print(max);
    }
}