import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static class Node implements Comparable<Node> {
        int weight; // 트럭 무게
        int time; // 다리에 올라간 시간

        public Node(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.time, n.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]); // 다리를 건너는 트럭의 수
        int w = Integer.parseInt(input[1]); // 다리의 길이
        int L = Integer.parseInt(input[2]); // 다리 최대 하중

        input = br.readLine().split(" "); // 트럭의 무게
        int[] trucks = new int[n];
        for(int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(input[i]);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        int start = 0;
        int sum = 0; // 큐에 들어간 트럭 무게의 합
        int count = 1; // 경과 시간

        queue.add(new Node(trucks[start],0));
        sum += trucks[start++];

        while(!queue.isEmpty()) {
            Node first = queue.peek();

            // 다리를 다 건넌 트럭 큐에서 제거
            if(count == first.time + w) {
                Node node = queue.poll();
                sum -= node.weight;
            }

            // 다리에 트럭 올릴 수 있으면 큐에 넣기
            if(start < n && sum + trucks[start] <= L) {
                queue.add(new Node(trucks[start], count));
                sum += trucks[start];
                start++;
            }

            count++;
        }

        System.out.print(count);

    }
}