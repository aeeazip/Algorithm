import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] num;
    static int[][] check; // Memoization
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                                               
        int N = Integer.parseInt(br.readLine()); // 수열의 크기
        num = new int[N + 1]; // 홍준이가 칠판에 적은 수 N개를 담는 배열
        check = new int[N + 1][N + 1];

        for(int i = 0; i < N +1 ; i++) { // 초기화
            for(int j = i; j < N + 1; j++) { // 절반만 필요함 (S <= E)
                if(i == j)
                    check[i][j] = 1; // palindrome임
                else
                    check[i][j] = -1;
            }
        }
        
        String[] input = br.readLine().split(" ");
        for(int i = 1; i < N + 1; i++)
            num[i] = Integer.parseInt(input[i - 1]);

        int M = Integer.parseInt(br.readLine()); // 홍준이가 한 질문의 개수
        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]); // 홍준이가 명우에게 한 질문 S
            int end = Integer.parseInt(input[1]); // 홍준이가 명우에게 한 질문 E

            bw.write(isPalindrome(start, end) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 팰린드롬인지 체크
    public static int isPalindrome(int start, int end) {
        if(check[start][end] != -1 || start == end) // 팰린드롬 체크한 기록이 있거나 자기 자신일 때
            return check[start][end];
    
        if(num[start] != num[end]) { // 팰린드롬이 아님
            check[start][end] = 0; 
            return 0;
        }

        if(start + 1 > end - 1)
            check[start][end] = 1;
        else
            check[start][end] = isPalindrome(start + 1, end - 1);
        
        return check[start][end];
    }
}