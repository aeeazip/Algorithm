import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static List<Integer>[] graph;
    public static int[][] arr;
    public static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); // 정점 개수, 간선 개수

        graph = new ArrayList[input[0] + 1];
        for (int i = 0; i < input[0] + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        arr = new int[input[1]][3];
        for (int i = 0; i < input[1]; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 가중치를 기준으로 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return Integer.compare(a1[2], a2[2]);
            }
        });

        int sum = 0;
        int count = 0;
        parent = new int[input[0] + 1]; // union find용 배열

        // 초기화
        for(int i = 0; i < input[0] + 1; i++) parent[i] = i;
        for(int i = 0; i < arr.length; i++) {
            // 사이클 검사
            if(find(arr[i][0]) != find(arr[i][1])) {
                union(arr[i][0], arr[i][1]);
                sum += arr[i][2];
                count++;
            }

            if(count == input[0] - 1) break;
        }

        System.out.print(sum);
    }

    // 집합 대표 찾기
    public static int find(int x) {
        if(parent[x] == x) return parent[x];
        return parent[x] = find(parent[x]);
    }

    // 두 집합 합치기
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a; // b를 a에 합치기
    }
}