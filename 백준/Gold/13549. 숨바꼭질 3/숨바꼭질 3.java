import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 0 5 -> 2
public class Main {
    public static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 수빈 위치
        int K = Integer.parseInt(input[1]); // 동생 위치

        distance = new int[100001];

        Arrays.fill(distance, Integer.MAX_VALUE);
        bfs(N, K);
        System.out.print(distance[K]);
    }

    public static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0;

        while(!queue.isEmpty()) {
            Integer index = queue.poll();
            if(index == end) break;

            int[] newIndexs = { 2 * index, index - 1, index + 1 }; // 수빈이가 이동할 수 있는 곳

            for(int i = 0; i < newIndexs.length; i++) {
                if(newIndexs[i] < 0 || newIndexs[i] > 100000) continue;
                if(distance[newIndexs[i]] != Integer.MAX_VALUE) continue;

                if(i == 0) {
                    distance[newIndexs[i]] = distance[index];
                } else {
                    distance[newIndexs[i]] = distance[index] + 1;
                }

                queue.add(newIndexs[i]);
            }
        }
    }
}