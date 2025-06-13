import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M;

    public static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 헛간 개수
        M = Integer.parseInt(input[1]); // 소들의 길 개수

        List<Node>[] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
           int[] num = Arrays.stream(br.readLine().split(" "))
                   .mapToInt(Integer::parseInt)
                   .toArray();

           graph[num[0]].add(new Node(num[1], num[2]));
           graph[num[1]].add(new Node(num[0], num[2]));
        }

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        int[] result = new int[N + 1]; // result[i] = 1 -> i번째 헛간까지의 최소 여물
        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0)); // 출발지

        while(!queue.isEmpty()) {
            Node first = queue.poll();
            int to = first.to;
            
            visited[to] = true;

            // 도착지를 출발지로 하는 것들 몽땅 넣기
            for(Node node : graph[to]) {
                if(result[node.to] > result[to] + node.cost) {
                    queue.add(new Node(node.to, node.cost));
                    result[node.to] = result[to] + node.cost;
                }
            }
        }

        System.out.print(result[N]);
    }
}