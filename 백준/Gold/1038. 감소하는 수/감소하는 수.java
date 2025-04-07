import java.util.*;
import java.io.*;

public class Main {
    public static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 0 - 9까지 감소하는 수 만들기
        for(int i = 0; i <= 9; i++) {
            dfs(i, i);
        }

        Collections.sort(list);

        long result = list.size() <= N ? -1 : list.get(N);
        System.out.print(result);
    }

    // 현재 now, last 보다 작은 수를 뒤에 이어 붙임
    public static void dfs(long now, int last) {
        list.add(now);

        for(int i = 0; i < last; i++) {
            dfs(now * 10 + i, i);
        }
    }
}