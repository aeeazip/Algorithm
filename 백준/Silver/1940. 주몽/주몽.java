import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        int[] num = new int[N];
        boolean[] isExist = new boolean[100000];
        int count = 0;
        
        for(int i = 0; i < isExist.length; i++) { // 초기화
            isExist[i] = false;
        }
            
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(input[i]);
            num[i] = n;
            isExist[n] = true;
        }

        for(int i = 0; i < N; i++) {
            if(M - num[i] > 0 && M - num[i] < 100000 && M - num[i] != num[i]) {
                if(isExist[num[i]] && isExist[M - num[i]]) {
                    count++;
                    isExist[M - num[i]] = false;
                    isExist[num[i]] = false;
                }
            }
        }

        System.out.print(count);
    }
}