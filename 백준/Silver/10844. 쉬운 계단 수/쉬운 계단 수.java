import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] stairNum = new long[N + 1][10];

        for(int i = 1; i < 10; i++) {
            stairNum[1][i] = 1;
        }

        long mod = 1000000000;
        for(int i = 2; i <= N; i++) {
            //0~9까지 탐색
            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    stairNum[i][j] = stairNum[i-1][1] % mod; // 1 뒤에 올 수 있는 건 0 뿐
                } else if(j == 9) {
                    stairNum[i][j] = stairNum[i-1][8] % mod; // 9 뒤에 올 수 있는 건 8 뿐
                } else {
                    stairNum[i][j] = (stairNum[i-1][j-1] + stairNum[i-1][j+1]) % mod; // 2 - 8 뒤에 올 수 있는 건 i - 1, i + 1
                }
            }
        }

        System.out.println(Arrays.stream(stairNum[N]).sum() % mod);
    }
}