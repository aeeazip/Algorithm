import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static List<Node>[] graph;

    public static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost); // 가중치로 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]); // 정점의 개수
        int E = Integer.parseInt(input[1]); // 간선의 개수
        int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

        graph = new ArrayList[V + 1];
        for(int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            // u -> v로 가는 가중치가 w인 간선이 존재
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            graph[u].add(new Node(v, w));
        }

        boolean[] visited = new boolean[V + 1];
        int[] distance = new int[V + 1];

        dijkstra(K, visited, distance);

        for(int i = 1; i < V + 1; i++) {
            if(distance[i] != Integer.MAX_VALUE)
                bw.write(distance[i] + "\n");
            else bw.write("INF\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int K, boolean[] visited, int[] distance) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;
        queue.add(new Node(K, 0));

        while(!queue.isEmpty()) {
            // 가장 최단 거리가 짧은 노드를 꺼냄
            Node node = queue.poll();
            int u = node.to;
            
            visited[u] = true;
            
            for(Node newNode : graph[node.to]) {
                int v = newNode.to;
                int w = newNode.cost;

                if(!visited[v] && distance[v] > distance[u] + w) {
                    distance[v] = distance[u] + w; // 최단 거리 업데이트
                    queue.add(new Node(v, distance[v]));
                }
            }
        }
    }
}