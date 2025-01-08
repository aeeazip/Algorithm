import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 행
        M = Integer.parseInt(input[1]); // 열
        int R = Integer.parseInt(input[2]); // 연산 개수

        arr = new int[N][M];
        int[] operation = new int[R];

        for(int i = 0; i < N; i++) {
            String[] num = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(num[j]);
            }
        }

        String[] operand = br.readLine().split(" ");
        for(int i = 0; i < R; i++) {
            operation[i] = Integer.parseInt(operand[i]);

            switch(operation[i]) {
                case 1:
                    step1(makeCopy()); break;
                case 2:
                    step2(makeCopy()); break;
                case 3:
                    step3(makeCopy()); break;
                case 4:
                    step4(makeCopy()); break;
                case 5:
                    step5(makeCopy()); break;
                case 6:
                    step6(makeCopy()); break;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] makeCopy() {
        int[][] copy = new int[arr.length][arr[0].length]; // 현재 배열의 크기를 기준으로 복사

        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, copy[i], 0, arr[i].length);
        }
        return copy;
    }

    // 상하 반전
    public static void step1(int[][] copy) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = copy[N - 1 - i][j];
            }
        }
    }

    // 좌우 반전
    public static void step2(int[][] copy) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = copy[i][M - 1 -j];
            }
        }
    }

    // 오른쪽으로 90도 회전
    public static void step3(int[][] copy) {
        int[][] newArr = new int[M][N]; // 크기가 반대가 되는 배열 생성

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[j][N - 1 - i] = copy[i][j];
            }
        }

        // N과 M 값을 교환하고 arr 갱신
        int temp = N;
        N = M;
        M = temp;
        arr = newArr;
    }

    // 왼쪽으로 90도 회전
    public static void step4(int[][] copy) {
        int[][] newArr = new int[M][N]; // 크기가 반대가 되는 배열 생성

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[M - 1 - j][i] = copy[i][j];
            }
        }

        // N과 M 값을 교환하고 arr 갱신
        int temp = N;
        N = M;
        M = temp;
        arr = newArr;
    }

    // 시계방향 회전 (1 -> 2 -> 3 -> 4 -> 1 위치로)
    public static void step5(int[][] copy) {
        int rowMid = N / 2;
        int colMid = M / 2;

        // 4 -> 1
        for (int i = 0; i < rowMid; i++) {
            for (int j = 0; j < colMid; j++) {
                arr[i][j] = copy[i + rowMid][j];
            }
        }

        // 1 -> 2
        for (int i = 0; i < rowMid; i++) {
            for (int j = colMid; j < M; j++) {
                arr[i][j] = copy[i][j - colMid];
            }
        }

        // 2 -> 3
        for (int i = rowMid; i < N; i++) {
            for (int j = colMid; j < M; j++) {
                arr[i][j] = copy[i - rowMid][j];
            }
        }

        // 3 -> 4
        for (int i = rowMid; i < N; i++) {
            for (int j = 0; j < colMid; j++) {
                arr[i][j] = copy[i][j + colMid];
            }
        }
    }

    // 반시계방향 회전 (1 -> 4 -> 3 -> 2 -> 1 위치로)
    public static void step6(int[][] copy) {
        int rowMid = N / 2;
        int colMid = M / 2;

        // 1 -> 4
        for (int i = rowMid; i < N; i++) {
            for (int j = 0; j < colMid; j++) {
                arr[i][j] = copy[i - rowMid][j];
            }
        }

        // 4 -> 3
        for (int i = rowMid; i < N; i++) {
            for (int j = colMid; j < M; j++) {
                arr[i][j] = copy[i][j - colMid];
            }
        }

        // 3 -> 2
        for (int i = 0; i < rowMid; i++) {
            for (int j = colMid; j < M; j++) {
                arr[i][j] = copy[i + rowMid][j];
            }
        }

        // 2 -> 1
        for (int i = 0; i < rowMid; i++) {
            for (int j = 0; j < colMid; j++) {
                arr[i][j] = copy[i][j + colMid];
            }
        }
    }
}
