import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static int[] dX = { 1, -1, 0, 0 };
    public static int[] dY = { 0, 0, -1, 1 };
    public static int M, N;
    public static int[][] box;
    public static boolean[][] visited;
    public static int[][] distance;
    public static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        box = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];

        // 1 = 익은 토마토, 0 = 익지 않은 토마토, -1 = 토마토가 들어있지 않음
        queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(input[j]);
                if(box[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }

        if(isAllRipen()) { // 저장될 때부터 모든 토마토가 익어있는 상태
            System.out.print("0");
            return;
        }

        int result = bfs();

        if(!isAllRipen()) { // 토마토가 모두 익지는 못하는 상태
            System.out.print("-1");
            return;
        }

        System.out.print(result);
    }

    public static boolean isAllRipen() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int bfs() {
        int result = 0;

        while(!queue.isEmpty()) {
            Point point =  queue.poll();
            visited[point.x][point.y] = true;

            for(int i = 0; i < 4; i++) {
                int newdX = point.x + dX[i];
                int newdY = point.y + dY[i];

                if(newdX < 0 || newdX >= N || newdY < 0 || newdY >= M)
                    continue;

                if(!visited[newdX][newdY] && box[newdX][newdY] == 0) {
                    box[newdX][newdY] = 1; // 익음
                    visited[newdX][newdY] = true; // 방문
                    distance[newdX][newdY] = distance[point.x][point.y] + 1;
                    queue.add(new Point(newdX, newdY));
                    result = distance[newdX][newdY];
                }
            }
        }

        return result;
    }
}