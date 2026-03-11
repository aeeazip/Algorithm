import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dX = { -1, 1, 2 };
    static boolean[] visited = new boolean[100001];
    static int[] seconds = new int[100001];
    static int[] last = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        bfs(info[0], info[1]);
        System.out.println(seconds[info[1]]);

        List<Integer> list = new ArrayList<>();
        list.add(info[1]);

        int index = info[1];
        while(index != info[0]) {
            list.add(last[index]);
            index = last[index];
        }

        for(int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }

    }

    public static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visited[start] = true;
        seconds[start] = 0;
        last[start] = start;

        while(!queue.isEmpty()) {
            int pos = queue.poll();
            visited[pos] = true;

            if(pos == end) break;

            for(int i = 0; i < 3; i++) {
                int newdX = (i == 2) ? pos * dX[i] : pos + dX[i];

                if(newdX < 0 || newdX > 100000) continue;
                
                if(!visited[newdX]) {
                    queue.add(newdX);
                    seconds[newdX] = seconds[pos] + 1;
                    last[newdX] = pos;
                    visited[newdX] = true;
                }
            }
        }
    }
}
