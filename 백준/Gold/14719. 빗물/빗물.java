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
        String[] input = br.readLine().split(" ");

        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        int[][] world = new int[H][W]; // 1 : 블록, 2 : 빗물
        String[] block = br.readLine().split(" ");

        for(int i = 0; i < W; i++) {
            for(int j = H - 1; j > H - 1 - Integer.parseInt(block[i]); j--) {
                world[j][i] = 1;
            }
        }

        int count = 0;
        for(int i = 0; i < H; i++) {
            int start = 0;
            int end = W - 1;

            boolean findLeft = false;
            boolean findRight = false;

            while (start != end && start < W && end >= 0) {
                if (world[i][start] != 1) {
                    start++;
                } else {
                    findLeft = true;
                }

                if (world[i][end] != 1) {
                    end--;
                } else {
                    findRight = true;
                }

                // 같은 높이 블록이 1개인 경우 혹은 2개인 경우
                if (start == end || (findLeft && findRight)) {
                    break;
                }
            }

            if (findLeft && findRight) {
                for (int j = start; j <= end; j++) {
                    if(world[i][j] != 1) {
                        count++;
                    }
                }
            }
        }

        System.out.print(count);
    }

}