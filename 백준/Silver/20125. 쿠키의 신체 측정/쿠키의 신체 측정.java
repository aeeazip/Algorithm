import java.io.*;
import java.util.*;

public class Main {
    public static String[][] cookie;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 쿠키 신체 정보 입력 받기
        int N = Integer.parseInt(br.readLine());
        cookie = new String[N + 1][N + 1];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < input.length; j++) {
                cookie[i + 1][j + 1] = input[j];
            }
        }

        int x = 0, y = 0;
        int[] body = new int[5]; // 신체 정보 (왼쪽팔, 오른쪽팔, 허리, 왼쪽 다리, 오른쪽 다리)
        boolean isHead = false;

        for(int i = 1; i < cookie.length; i++) {
            for(int j = 1; j < cookie[i].length; j++) {
                if(!isHead && cookie[i][j].equals("*")) {
                    isHead = true;
                    // 심장은 머리 바로 아래
                    x = i + 1;
                    y = j;

                    body[0] = checkLeftArm(x, y);
                    body[1] = checkRightArm(x, y);
                    body[2] = checkBack(x, y);
                    body[3] = checkLeftLeg(x, y, body[2]);
                    body[4] = checkRightLeg(x, y, body[2]);
                    break;
                }
            }
        }

        System.out.println(x + " " + y);
        for(int b : body) {
            System.out.print(b + " ");
        }
    }

    public static int checkLeftArm(int x, int y) {
        int count = 0;

        for(int i = y - 1; i >= 1; i--) {
            if(cookie[x][i].equals("*")) {
                count++;
            }
        }
        return count;
    }

    public static int checkRightArm(int x, int y) {
        int count = 0;

        for(int i = y + 1; i < cookie.length; i++) {
            if(cookie[x][i].equals("*")) {
                count++;
            }
        }
        return count;
    }

    public static int checkBack(int x, int y) {
        int count = 0;

        for(int i = x + 1; i < cookie.length; i++) {
            if(cookie[i][y].equals("*")) {
                count++;
            }
        }
        return count;
    }

    public static int checkLeftLeg(int x, int y, int last) {
        int count = 0;

        for(int i = x + last + 1; i < cookie.length; i++) {
            if(cookie[i][y - 1].equals("*")) {
                count++;
            }
        }
        return count;
    }

    public static int checkRightLeg(int x, int y, int last) {
        int count = 0;

        for(int i = x + last + 1; i < cookie.length; i++) {
            if(cookie[i][y + 1].equals("*")) {
                count++;
            }
        }
        return count;

    }
}