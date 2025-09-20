import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    public static List<Node> graph;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); // 정점 개수, 간선 개수

       // 크루스칼용
       parent = new int[info[0] + 1];
       for(int i = 0; i < info[0] + 1; i++) {
           parent[i] = i;
       }

       graph = new ArrayList<>();
       for(int i = 0; i < info[1]; i++) {
           int[] input = Arrays.stream(br.readLine().split(" "))
                   .mapToInt(Integer::parseInt)
                   .toArray();

           graph.add(new Node(input[0], input[1], input[2]));
       }

       Collections.sort(graph);

       int sum = 0;
       int count = 0;

       for(Node n : graph) {
           if(union(n.from, n.to)){
               sum += n.cost;
               count++;

               if(count == info[0] - 1) break;
           }
       }

       System.out.print(sum);
    }

    public static boolean union(int from, int to) {
        // 1. 대표 찾기
        from = find(from);
        to = find(to);

        // 2. to 대표 from으로 변겯
        if(from != to) {
            parent[to] = from;
            return true;
        }

        return false;
    }

    public static int find(int v) {
        if(parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }
}