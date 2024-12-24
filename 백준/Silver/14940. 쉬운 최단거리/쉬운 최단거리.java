import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static int X, Y;
    public static int goalX = 0, goalY = 0;

    public static int[][] ground;
    public static boolean[][] visited;
    public static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        X = Integer.parseInt(input[0]);
        Y = Integer.parseInt(input[1]);
        ground = new int[X][Y];

        for (int i = 0; i < X; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < Y; j++) {
                ground[i][j] = Integer.parseInt(input[j]);

                if (ground[i][j] == 2) {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        dfs();

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                bw.write(distance[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs() {
        int[] dX = {1, -1, 0, 0};
        int[] dY = {0, 0, -1, 1};

        visited = new boolean[X][Y];
        distance = new int[X][Y];
        
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                distance[i][j] = ground[i][j] == 1 ? -1 : 0; // 갈 수 없는 땅은 0, 나머지는 초기 -1
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(goalX, goalY));
        distance[goalX][goalY] = 0;
        visited[goalX][goalY] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newdX = point.x + dX[i];
                int newdY = point.y + dY[i];

                if (newdX >= 0 && newdX < X && newdY >= 0 && newdY < Y) {
                    if (!visited[newdX][newdY] && ground[newdX][newdY] == 1) {
                        visited[newdX][newdY] = true;
                        distance[newdX][newdY] = distance[point.x][point.y] + 1;
                        queue.add(new Point(newdX, newdY));
                    }
                }
            }
        }
    }

}