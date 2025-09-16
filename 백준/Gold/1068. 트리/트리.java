import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] num = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int root = -1;
        for(int i = 0; i < N; i++) {
            if(num[i] == -1) root = i;
            else graph[num[i]].add(i);
        }

        int removeNum = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N];

        int result = 0;
        if(removeNum != root) result = bfs(root, removeNum, visited);
        System.out.print(result);
    }

    public static int bfs(int root, int removeNum, boolean[] visited) {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;

        while(!queue.isEmpty()) {
            int n = queue.poll();
            int count = 0;

            for(Integer i : graph[n]) {
                if (!visited[i] && i != removeNum) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }

            if(count == 0) result++; // 자식이 없다는 뜻
        }

        return result;
    }

}