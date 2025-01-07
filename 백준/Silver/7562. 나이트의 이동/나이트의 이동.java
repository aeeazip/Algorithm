import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int N = Integer.parseInt(br.readLine());
       for(int i = 0; i < N; i++) {
           int I = Integer.parseInt(br.readLine());

           boolean[][] visited = new boolean[I][I];
           int[][] distance = new int[I][I];

           String[] input1 = br.readLine().split(" ");
           String[] input2 = br.readLine().split(" ");

           Point start = new Point(Integer.parseInt(input1[0]), Integer.parseInt(input1[1]));
           Point end = new Point(Integer.parseInt(input2[0]), Integer.parseInt(input2[1]));

           int result = bfs(start, end, visited, distance, I);
           bw.write(result + "\n");
       }

       bw.flush();
       bw.close();
       br.close();
    }

    public static int bfs(Point start, Point end, boolean[][] visited, int[][] distance, int I) {
        int[] dX = { -2, -2, -1, -1, 1, 1, 2, 2 };
        int[] dY = { -1, 1, -2, 2, -2, 2, -1, 1 };

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            visited[point.x][point.y] = true;

            for(int i = 0; i < 8; i++) {
                int newdX = point.x + dX[i];
                int newdY = point.y + dY[i];

                if(newdX < 0 || newdX >= I || newdY < 0 || newdY >= I) continue;

                if(!visited[newdX][newdY]) {
                    visited[newdX][newdY] = true;
                    distance[newdX][newdY] = distance[point.x][point.y] + 1;
                    queue.add(new Point(newdX, newdY));
                }

                if(newdX == end.x && newdY == end.y) {
                    break;
                }
            }
        }

        return distance[end.x][end.y];
    }
}
