import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static int[][] map;
    public static class Chessmen {
        int x;
        int y;
        int dir;

        public Chessmen(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static Chessmen[] chessmen;
    public static List<Integer>[][] board;
    public static int[] dX;
    public static int[] dY;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        chessmen = new Chessmen[K]; // 체스말 정보
        board = new ArrayList[N][N]; // 체스판에서 말이 쌓인 순서를 관리
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < K; i++) {
            int[] info = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            chessmen[i] = new Chessmen(info[0] - 1, info[1] - 1, info[2]);
            board[info[0] - 1][info[1] -1].add(i);
        }

        dX = new int[]{ 0, 0, 0, -1, 1 }; // 우, 좌, 상, 하
        dY = new int[]{ 0 , 1, -1, 0, 0 }; // 우, 좌, 상, 하

        boolean isFinished = false;
        int turn = 1;

        while(turn < 1000) {
            for(int i = 0; i < K; i++) {
                int pos = chessmen[i].dir;
                int newdX = chessmen[i].x + dX[pos];
                int newdY = chessmen[i].y + dY[pos];

                int result = 0;
                if(newdX >= 0 && newdX < N && newdY >= 0 && newdY < N) {
                    switch(map[newdX][newdY]) {
                        case 0:
                            result = moveWhite(chessmen[i].x, chessmen[i].y, newdX, newdY, i);
                            break;
                        case 1:
                            result = moveRed(chessmen[i].x, chessmen[i].y, newdX, newdY, i);
                            break;
                        case 2:
                            result = moveBlue(chessmen[i].x, chessmen[i].y, newdX, newdY, i);
                            break;
                    }
                } else { // 파란색과 같음
                    result = moveBlue(chessmen[i].x, chessmen[i].y, newdX, newdY, i);
                }

                if(result >= 4) {
                    isFinished = true;
                    break;
                }
            }

            if(isFinished) break;
            turn++;
        }

        if(turn >= 1000) System.out.print("-1");
        else System.out.print(turn);
    }

    // 이동하려는 칸이 흰색인 경우
    public static int moveWhite(int x, int y, int newdX, int newdY, int now) {
        List<Integer> toMove = new ArrayList<>();

        // 1. (x, y)에서 옮겨야 할 체스말 기록
        int index = board[x][y].indexOf(now);
        for(int i = index; i < board[x][y].size(); i++) {
            toMove.add(board[x][y].get(i));
        }

        // 2. (x, y)에서 옮겨야 할 체스말 삭제
        board[x][y].subList(index, board[x][y].size()).clear();


        // 3. (x, y)에 now 위로 쌓인 체스말을 순서대로 (newdX, newdY)로 옮김
        for(int chessmenIndex : toMove) {
            chessmen[chessmenIndex].x = newdX;
            chessmen[chessmenIndex].y = newdY;
            board[newdX][newdY].add(chessmenIndex);
        }

        return board[newdX][newdY].size();
    }

    // 이동하려는 칸이 빨간색인 경우
    public static int moveRed(int x, int y, int newdX, int newdY, int now) {
        Stack<Integer> stack = new Stack<>();

        // 1. (x, y)에서 옮겨야 할 체스말 기록
        int index = board[x][y].indexOf(now);
        for(int i = index; i < board[x][y].size(); i++) {
            stack.add(board[x][y].get(i));
        }

        // 2. (x, y)에서 옮겨야 할 체스말 삭제
        board[x][y].subList(index, board[x][y].size()).clear();

        // 3. (x, y)에 now 위로 쌓인 체스말을 역순으로 (newdX, newdY)로 옮김
        while(!stack.isEmpty()) {
            int chessmenIndex = stack.pop();
            chessmen[chessmenIndex].x = newdX;
            chessmen[chessmenIndex].y = newdY;
            board[newdX][newdY].add(chessmenIndex);
        }

        return board[newdX][newdY].size();
    }

    // 이동하려는 칸이 파란색인 경우
    // 파란색인 경우 A번 말의 이동 방향을 반대로 하고 한 칸 이동 = 앞으로 한 칸 띨롱이 아니라, 칸 색에 맞는 이동 로직 한 번 수행하라는 뜻
    public static int moveBlue(int x, int y, int newdX, int newdY, int now) {
        // 이동방향 반대로 변경 -> 오(1), 왼(2), 위(3), 아래(4)
        int dir = chessmen[now].dir;
        if(dir % 2 == 0) dir -= 1;
        else dir += 1;
        chessmen[now].dir = dir;

        newdX = x + dX[dir];
        newdY = y + dY[dir];

        // 방향 바꿔서 갈 수 없는 경로, 이동한 위치가 파란색인지 체크
        if(newdX < 0 || newdX >= map.length || newdY < 0 || newdY >= map.length || map[newdX][newdY] == 2) {
            return board[x][y].size();
        }

        // 이동 가능한 경우 방향 바꾸고 난 후 재시도
        if (map[newdX][newdY] == 0) {
            return moveWhite(x, y, newdX, newdY, now);
        }

        return moveRed(x, y, newdX, newdY, now);
    }

}