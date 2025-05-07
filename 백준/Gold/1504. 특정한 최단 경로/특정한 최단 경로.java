import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static int N;
    public static List<Node>[] graph;
    public static boolean[] visited;
    public static int[] distance;
    public static int INF = Integer.MAX_VALUE;

    public static class Node implements Comparable<Node> {
        public int index;
        public int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            // 가중치 기준 오름차순 정렬
            return Integer.compare(this.cost, n.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        graph = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < E; i++) {
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        // 반드시 지나야 하는 임의의 두 정점
        input = br.readLine().split(" ");
        int V1 = Integer.parseInt(input[0]);
        int V2 = Integer.parseInt(input[1]);

        /*
         * 가능한 경로
         * 1) 1 -> V1 -> V2 -> N
         * 2) 1 -> V2 -> V1 -> N
         */

        // 시작 정점이 1인 다익스트라
        dijkstra(1);
        int oneToV1 = distance[V1];
        int oneToV2 = distance[V2];

        // 시작 정점이 V1인 다익스트라
        dijkstra(V1);
        int v1ToV2 = distance[V2];
        int v1ToN= distance[N];

        // 시작 정점이 V2인 다익스트라
        dijkstra(V2);
        int v2ToN = distance[N];
        int v2ToV1 = distance[V1];


        int case1 = (oneToV1 == INF || v1ToV2 == INF || v2ToN == INF) ? INF : oneToV1 + v1ToV2 + v2ToN;
        int case2 = (oneToV2 == INF || v2ToV1 == INF || v1ToN == INF) ? INF : oneToV2 + v2ToV1 + v1ToN;

        int min = Math.min(case1, case2);
        System.out.print(min == INF ? -1 : min);
    }

    public static void dijkstra(int start) {
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int now = node.index;

            visited[now] = true;

            for(Node n : graph[now]) {
                int to = n.index;
                int weight = n.cost;

                if(!visited[to] && distance[to] > distance[now] + weight) {
                    distance[to] = distance[now] + weight;
                    queue.add(new Node(to, distance[to]));
                }
            }
        }
    }
}