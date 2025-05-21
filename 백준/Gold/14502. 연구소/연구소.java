import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int max = 0; // 최대 안전 영역의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] map = new int[size[0]][size[1]];
        for(int i = 0; i < size[0]; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 조합으로 벽 설치할 위치 구하기
        installWall(map, size[0], size[1], 0, 0);
        System.out.print(max);
    }

    // 벽 설치할 위치 선정하는 메소드
    public static void installWall(int[][] map, int n, int m, int start, int depth) {
        if(depth == 3) {
            // bfs로 안전영역의 크기 구함
            int result = bfs(map, n, m);
            max = Math.max(result, max);
            return;
        }

        for(int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if(map[x][y] == 0) { // 벽 설치 가능한 위치면
                map[x][y] = 1;
                installWall(map, n, m, i + 1, depth + 1);
                map[x][y] = 0;
            }
        }
    }

    // 안전 영역의 개수 구할 메소드
    public static int bfs(int[][] map, int n, int m) {
        // map 복제본 만들기 (깊은 복사)
        int[][] newMap = map.clone();
        for(int i = 0; i < n; i++) {
            newMap[i] = map[i].clone();
        }

        int[] dX = { -1, 1, 0, 0 };
        int[] dY = { 0, 0, -1, 1 };

        Queue<Point> queue = new LinkedList<>();
        // 바이러스 있는 곳 큐에 다 넣기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 2) queue.add(new Point(i, j));
            }
        }

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i = 0; i < 4; i++) {
                int newdX = point.x + dX[i];
                int newdY = point.y + dY[i];

                if(newdX < 0 || newdX >= n || newdY < 0 || newdY >= m) continue;
                if(newMap[newdX][newdY] == 0) { // 바이러스가 퍼지기 위한 조건
                    newMap[newdX][newdY] = 2;
                    queue.add(new Point(newdX, newdY));
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(newMap[i][j] == 0) count++;
            }
        }

        return count;
    }
}