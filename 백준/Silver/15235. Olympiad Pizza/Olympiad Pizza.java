import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static class Node {
        int index;
        int count; // 먹어야 할 피자 개수

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        int[] result = new int[n];
        Arrays.fill(result, 0);

        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) { // 무조건 1개 이상은 먹으니까
            queue.add(new Node(i, arr[i]));
        }

        int time = 1;
        while(!queue.isEmpty()) {
            Node first = queue.poll();

            if(first.count - 1 == 0) {
                result[first.index] = time;
            } else {
                queue.add(new Node(first.index, first.count - 1));
            }

            time++;
        }

        for(int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}