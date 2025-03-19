import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]); // 지름길 개수
        int D = Integer.parseInt(str[1]); // 고속도로 길이

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int len = Integer.parseInt(input[2]);
            list.add(new int[]{ start, end, len });
        }

        // 1. 지름길 정보 오름차순 정렬
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
                if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[2], b[2]);
            }
        });

        int last = -1; // 마지막으로 선택된 지름길
        int[] dp = new int[D + 1];
        Arrays.fill(dp, -1);

        for(int i = 0; i <= D; i++) {
            boolean flag = false;

            for(int j = 0; j < N; j++) {
                int[] shortWay = list.get(j); // 지름길 정보

                if(shortWay[1] == i) {
                    flag = true;
                    int case1 = dp[i];
                    int case2 = dp[shortWay[0]] + shortWay[2];
                    int case3 = dp[shortWay[0]] + (shortWay[1] - shortWay[0]);

                    int min = Math.min(case2, case3);
                    if(case1 != -1) min = Math.min(min, case1);
                    if(last != -1) min = Math.min(min, dp[last] + (i - last));

                    dp[i] = min;
                    last = i;
                }
            }

            if(!flag) dp[i] = (i == 0) ? 0 : dp[i - 1] + 1;
 
        }

        System.out.print(dp[D]);
    }
}