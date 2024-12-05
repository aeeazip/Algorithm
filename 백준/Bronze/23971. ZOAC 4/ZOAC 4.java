import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int H  = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        int N = Integer.parseInt(input[2]); // 세로 차
        int M = Integer.parseInt(input[3]); // 가로 차


        int x = H / (N + 1) + (H % (N + 1) !=  0 ? 1 : 0); // 몇 개의 행이 가능한지
        int y = W / (M + 1) + (W % (M + 1) !=  0 ? 1 : 0); // 한 열에 몇 개 가능한지

        System.out.print(x * y);
    }
}