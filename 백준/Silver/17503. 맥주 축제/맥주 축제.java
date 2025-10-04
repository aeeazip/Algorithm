import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, K;
    public static long M;
    public static List<int[]> beers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]); // 축제가 열리는 기간
        M = Long.parseLong(str[1]); // 채워야하는 선호도의 합
        K = Integer.parseInt(str[2]); // 맥주 종류의 수

        beers = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            beers.add(
                    Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray()
            );
        }

        Collections.sort(beers, new Comparator<int[]>() {
            @Override
            public int compare(int[] b1, int[] b2) {
                if(b1[1] != b2[1]) return Integer.compare(b1[1], b2[1]);
                return Integer.compare(b1[0], b2[0]);
            }
        });


        long left = 1; // 도수 레벨 최솟값
        long right = beers.get(K - 1)[1]; // 도수 레벨 최댓값
        long answer = -1;

        while(left <= right) {
            long mid = (left + right) / 2;

            if(canDrink(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(answer);
    }

    public static boolean canDrink(long level) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long sum = 0;

        for(int[] beer : beers) {
            if(beer[1] > level) break;

            queue.add(beer[0]);
            sum += beer[0];

            if(queue.size() > N) {
                sum -= queue.poll();
            }
        }

        return queue.size() == N && sum >= M;
    }
}