import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static long[] M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        M = new long[N + 1];
        for(int i = 0; i < M.length; i++) {
            M[i] = 0;
        }
        
        long result = pinary(N, N);
        System.out.print(result);
    }

    public static long pinary(int N, int now) {
        if(now == 0 || now == 1) {
            M[now] = now;
            return M[now];
        }

        if(M[now] != 0)
            return M[now];

        M[now] = pinary(N, now - 1) + pinary(N, now - 2);
        return M[now];
    }
}