import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static boolean[][] board; // 사과 있으면 true
    public static Map<Integer, String> info;
    public static Deque<Point> deque; // 뱀 위치 기록
    public static int[] dX = { 0, 1, 0, -1 }; // 우하좌상
    public static int[] dY = { 1, 0, -1, 0 }; // 우하좌상
    public static int dir = 0; // 방향 인덱스

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 보드의 크기
        int K = Integer.parseInt(br.readLine()); // 사과 갯수

        board = new boolean[N][N];

        for(int i = 0; i < K; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            board[arr[0] - 1][arr[1] - 1] = true; // 사과 위치 기록
        }

        int L = Integer.parseInt(br.readLine()); // 방향 변환 정보
        info = new HashMap<>();
        for(int i = 0; i < L; i++) {
            String[] arr = br.readLine().split(" ");
            info.put(Integer.parseInt(arr[0]), arr[1]);
        }

        deque = new ArrayDeque<>(); // 머리 = first, 꼬리 = last
        deque.addFirst(new Point(0, 0));

        int answer = 0;
        while(true) {
            answer++;

            Point pos = deque.peekFirst();
            int headX = pos.x + dX[dir];
            int headY = pos.y + dY[dir];

            // 옮기려는 위치에 뱀 없는지 체크 && 벽이 아닌지 체크
            if(headX < 0 || headX >= N || headY < 0 || headY >= N) break;
            if(deque.contains(new Point(headX, headY))) break;

            // 위치에 사과 있으면 그대로 두고, 없으면 꼬리 위치 옮기기
            if(!board[headX][headY]) {
                deque.removeLast();
            } else {
                board[headX][headY] = false;
            }

            deque.addFirst(new Point(headX, headY));

            // 위치 정보 없으면 오른쪽 있으면 그 방향으로 이동
            String trans = info.getOrDefault(answer, "");
            if(trans.equals("L")) {
                dir = (dir + 3) % 4; // 반시계
            } else if(trans.equals("D")) {
                dir = (dir + 1) % 4; // 시계
            }
        }

        System.out.print(answer);
    }
}