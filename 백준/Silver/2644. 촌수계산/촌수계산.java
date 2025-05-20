import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static boolean[] visited;
    public static int[] distance;
    public static Set<int[]> relation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] question = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int m = Integer.parseInt(br.readLine());
        relation = new HashSet<>();
        for(int i = 0; i < m; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            relation.add(input);
        }

        visited = new boolean[N + 1];
        distance = new int[N + 1];

        bfs(question);

        int result = distance[question[1]];
        if(result == 0) result = -1;

        System.out.print(result);
    }

    public static void bfs(int[] question) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ question[0], question[0] });
        distance[question[0]] = 0;
        visited[question[0]] = true;

        while(!queue.isEmpty()) {
            int[] first = queue.poll();
            
            if((first[0] == question[0] && first[1] == question[1]) ||
                    (first[0] == question[1] && first[1] == question[0])) break;

            // 부모 -> 부모로 올라가기
            int newParent = findParent(first[0]);
            if(!visited[newParent] && newParent != 0) {
                visited[newParent] = true;
                queue.add(new int[] { newParent, first[0] });
                distance[newParent] = distance[first[0]] + 1;
            }

            // 부모 -> 다른 자식으로 내려가기
            ArrayList<Integer> otherChilds = findChilds(first[0]);
            for(int child : otherChilds) {
                if(child != first[1] && !visited[child]) {
                    visited[child] = true;
                    queue.add(new int[] { first[0], child });
                    distance[child] = distance[first[0]] + 1;
                }
            }

            // 자식 -> 자식으로 내려가기
            int newChild = findChild(first[1]);
            if(!visited[newChild] && newChild != 0) {
                visited[newChild] = true;
                queue.add(new int[] { first[1], newChild });
                distance[newChild] = distance[first[1]] + 1;
            }

            if(newParent == 0 && newChild == 0 && otherChilds.isEmpty()) break;
        }
    }

    // 부모 찾기
    public static int findParent(int child) {
        for(int[] arr : relation) {
            if(arr[1] == child) {
                return arr[0];
            }
        }
        return 0;
    }

    // 자식 찾기
    public static int findChild(int parent) {
        for(int[] arr : relation) {
            if(arr[0] == parent) {
                return arr[1];
            }
        }
        return 0;
    }

    public static ArrayList<Integer> findChilds(int parent) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int[] arr : relation) {
            if(arr[0] == parent) {
                list.add(arr[1]);
            }
        }
        return list;
    }
}