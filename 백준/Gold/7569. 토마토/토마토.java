import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static int[] dX = { 0, 0, -1, 1, 0, 0 };
    public static int[] dY = { 1, -1, 0, 0, 0, 0 };
    public static int[] dZ = { 0, 0, 0, 0, 1, -1 };
    public static int M, N, H;
    public static int[][][] box;
    public static boolean[][][] visited;
    public static int[][][] distance;
    public static Queue<Position> queue;

    public static class Position {
        int x;
        int y;
        int z;

        public Position(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);

        box = new int[H][N][M];
        visited = new boolean[H][N][M];
        distance = new int[H][N][M];
        queue = new LinkedList<>();

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                String[] tomato = br.readLine().split(" ");
                for(int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(tomato[k]);
                    if(box[i][j][k] == 1) {
                        queue.add(new Position(i, j, k));
                    }
                }
            }
        }

        if(isAllRipen()) { // 저장될때부터 모두 익은 상태
            System.out.println("0");
            return;
        }

        int count = bfs();
        if(!isAllRipen()) { // 토마토가 모두 익지는 못하는 상태
            System.out.println("-1");
            return;
        }

        System.out.print(count);
    }

    public static boolean isAllRipen() {
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(box[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static int bfs() {
        int result = -1;

        while(!queue.isEmpty()) {
            Position p = queue.poll();
            visited[p.x][p.y][p.z] = true;

            for(int i = 0; i < 6; i++) {
                int newdX = p.x + dX[i];
                int newdY = p.y + dY[i];
                int newdZ = p.z + dZ[i];

                if(newdX < 0 || newdX >= H || newdY < 0 || newdY >= N || newdZ < 0 || newdZ >= M) {
                    continue;
                }

                // 방문 전 + 본인이 안익은 토마토
                if(!visited[newdX][newdY][newdZ] && box[newdX][newdY][newdZ] == 0) {
                    box[newdX][newdY][newdZ] = 1;
                    visited[newdX][newdY][newdZ] = true;
                    distance[newdX][newdY][newdZ] = distance[p.x][p.y][p.z] + 1;
                    result = distance[newdX][newdY][newdZ];
                    queue.add(new Position(newdX, newdY, newdZ));
                }
            }
        }

        return result;
    }

}