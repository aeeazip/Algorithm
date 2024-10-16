import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dX = {0, 0, -1, 1}; 
    static int[] dY = {1, -1, 0, 0};

    static int N; // 가로
    static int M; // 세로
    static String[][] army; // 병사들 옷 색 저장
    static boolean[][] visit; // 방문 여부 저장
    static int count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inputNum = br.readLine().split(" ");
        N = Integer.parseInt(inputNum[0]); // 가로
        M = Integer.parseInt(inputNum[1]); // 세로
        
        army = new String[M][N]; 
        visit = new boolean[M][N];
        
        for(int i = 0; i < M; i++) { // 병사들 옷 색 입력받기
            String[] inputArea = br.readLine().split("");
            
            for(int j = 0; j < inputArea.length; j++) {
                army[i][j] = inputArea[j];
                visit[i][j] = false; // 방문 초기화
            }
        }

        int ourPowerSum = 0; // 우리 병사 위력합
        int enemyPowerSum = 0; // 적국 병사 위력합
        
        // 1. 우리 병사 위력합 구하기
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                count = 0;
              
                if(!visit[i][j] && army[i][j].equals("W")) {
                    dfs(i, j, "W");
                }

                ourPowerSum += count * count;
            }
        }

        // 방문 초기화
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                visit[i][j] = false;
            }
        }
        
        // 2. 적국 병사 위력합 구하기
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                count = 0;
              
                if(!visit[i][j] && army[i][j].equals("B")) {
                    dfs(i, j, "B");
                }

                enemyPowerSum += count * count;
            }
        }

        System.out.print(ourPowerSum + " " + enemyPowerSum);
    }

    public static void dfs(int x, int y, String color) {
        visit[x][y] = true; // 방문 여부 표시
        count++;
        
        for(int i = 0; i < 4; i++) {
            int newX = x + dX[i]; // 다음 탐색 x좌표
            int newY = y + dY[i]; // 다음 탐색 y좌표

            if(newX < 0 || newX >= M || newY < 0 || newY >= N) 
                continue;
            
            if(army[newX][newY].equals(color) && !visit[newX][newY]) {
                dfs(newX, newY, color);
            }
        }
    }
}