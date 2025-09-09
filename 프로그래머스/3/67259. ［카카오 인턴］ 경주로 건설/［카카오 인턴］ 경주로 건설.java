import java.util.*;

class Solution {
    public static class Node implements Comparable<Node> {
        int x; // x 좌표
        int y; // y 좌표
        int dir; // 방향 (0 : 상 / 1 : 하 / 2 : 좌 / 3 : 우)
        int cost; // 최소 비용

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    public static int[][][] distance;

    public int solution(int[][] board) {
        distance = new int[board.length][board.length][4];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                Arrays.fill(distance[i][j], Integer.MAX_VALUE);
            }
        }

        bfs(board);
        return Arrays.stream(distance[board.length - 1][board.length - 1])
                .min()
                .getAsInt();
    }

    public static void bfs(int[][] board) {
        int[] dX = { -1, 1, 0, 0 };
        int[] dY = { 0, 0, -1, 1 };

        PriorityQueue<Node> queue = new PriorityQueue();
        queue.add(new Node(0, 0, -1, 0));
        for(int i = 0; i < 4; i++) {
            distance[0][0][i] = 0;
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int newdX = node.x + dX[i];
                int newdY = node.y + dY[i];

                if(newdX < 0 || newdX >= board.length || newdY < 0 || newdY >= board.length) continue;
                if(board[newdX][newdY] == 1) continue;

                int newCost = node.cost + 100;
                if(node.dir != i && node.dir != -1) newCost += 500;
                
                if(distance[newdX][newdY][i] > newCost) {
                    distance[newdX][newdY][i] = newCost;
                    queue.add(new Node(newdX, newdY, i, distance[newdX][newdY][i]));
                }
            }
        }
    }
}