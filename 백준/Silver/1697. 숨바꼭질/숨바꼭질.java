import java.io.*;
import java.util.*;

public class Main {
    static int[] dX = { -1, 1, 2 };
    static int N;
    static int K;

    static boolean[] visit;
    static int[] seconds;

    public static void main(String[] args) throws IOException {
        // 걷기 : x - 1, x + 1
        // 순간이동 : 2x
        // 수빈이가 동생을 찾는 가장 빠른 시간

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 수빈이 위치
        K = Integer.parseInt(input[1]); // 덩생 위치

        visit = new boolean[100001];
        seconds = new int[100001];

        bfs();
        System.out.print(seconds[K]);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int now = N;

        queue.add(now);
        seconds[now] = 0;

        while(!queue.isEmpty()) {
            now = queue.poll();
            visit[now] = true;

            for(int i = 0; i < 3; i++) {
                int newdX = ( i == 2 ) ? now * 2 : now + dX[i];

                if(newdX >= 0 && newdX < visit.length) {
                    if(!visit[newdX]) {
                        visit[newdX] = true;
                        seconds[newdX] = seconds[now] + 1;
                        queue.add(newdX);
                    }
                }
            }
        }
    }
}