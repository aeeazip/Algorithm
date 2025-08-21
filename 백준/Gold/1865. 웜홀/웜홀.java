import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 도로는 방향이 없음 (양방향)
// 웜홀은 방향이 있음 (단방향)
// 웜홀은 도착하면 시작했을 때보다 시간이 뒤로 가게 된다 = 음의 가중치
// 한 지점에서 출발해서 다시 출발지로 돌아왔을 때 시간이 되돌아가는 경우가 있는지
public class Main {
    public static class Node implements Comparable<Node> {
        int to;
        int cost;

        Node(int to, int cost) {
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        for (int i = 0; i < TC; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]); // 지점의 수
            int M = Integer.parseInt(input[1]); // 도로의 개수
            int W = Integer.parseInt(input[2]); // 홀의 개수

            List<Node>[] graph = new ArrayList[N + 1];
            for (int j = 0; j < N + 1; j++) {
                graph[j] = new ArrayList<>();
            }

            // 도로 정보 (도로는 양방향 연결)
            for (int k = 0; k < M; k++) {
                int[] info = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray(); // S, E, T
                graph[info[0]].add(new Node(info[1], info[2]));
                graph[info[1]].add(new Node(info[0], info[2]));
            }

            // 웜홀 정보 (웜홀은 단방향 연결)
            for (int l = 0; l < W; l++) {
                int[] info = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray(); // S, E, T
                graph[info[0]].add(new Node(info[1], -1 * info[2]));
            }

            // 음수 사이클이 있는지만 체크
            boolean result = hasNegativeCycle(graph, N);
            if(result) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    /*
       출발점이 특정되지 않고, 그래프 어디든 음수 사이클이 있는지만 찾으면 된다
       = 모든 정점에서 출발했을 때를 동시에 고려해야 함!
       = distance를 0으로 초기화

       (i == N)일 때 갱신된다는 뜻은 그래프 어딘가에 음수 사이클이 존재한다.
       = 최단거리가 갱신되려면 기존값보다 작아져야함
       = 가능한 경우의 수는 사이클이 존재 (사이클이 없다면 간선 개수를 V-1개 넘길 수 없음)
           + 간선이 음수임 (최단거리가 갱신되려면 기존값보다 작아져야함)
   */
    public static boolean hasNegativeCycle(List<Node>[] graph, int N) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, 0);

        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (Node n : graph[j]) {
                    if (distance[n.to] > distance[j] + n.cost) {
                        distance[n.to] = distance[j] + n.cost;
                        if (i == N) return true;
                    }
                }
            }
        }

        return false;
    }
}