import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int L;
    public static int R;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] num = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(num[j]);
            }
        }

        int count = 0;
        while(true) {
            boolean isUnion = false;
            boolean[][] visited = new boolean[N][N]; // 방문 체크 배열 초기화

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        boolean result = bfs(i, j, visited);
                        if(result) isUnion = true;
                    }
                }
            }

            if(isUnion) count++;
            else break;
        }

        System.out.print(count);
    }

    public static boolean bfs(int x, int y, boolean[][] visited) {
        int[] dX = { 1, -1, 0, 0 };
        int[] dY = { 0, 0, 1, -1 };

        int sum = arr[x][y];
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{ x, y });

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ x, y });
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int nowX = pos[0];
            int nowY = pos[1];

            for(int i = 0; i < 4; i++) {
                int newdX = nowX + dX[i];
                int newdY = nowY + dY[i];

                if(newdX < 0 || newdX >= N || newdY < 0 || newdY >= N) continue;

                if(!visited[newdX][newdY]) {
                    int diff = Math.abs(arr[nowX][nowY] - arr[newdX][newdY]);
                    if (diff >= L && diff <= R) {
                        visited[newdX][newdY] = true;
                        list.add(new int[]{newdX, newdY});
                        queue.add(new int[]{ newdX, newdY });
                        sum += arr[newdX][newdY];
                    }
                }
            }
        }

        if(list.size() > 1) { // 연합이 있다는 뜻
            int newPopulation = sum / list.size(); // 새로운 인구 수 계산
            for(int[] pos : list) {
                arr[pos[0]][pos[1]] = newPopulation;
            }
            return true;
        }

        return false;
    }
}
