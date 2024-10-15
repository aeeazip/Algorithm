import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        int end = N % 2 == 0 ? N / 2 : N / 2 + 1;
        
        if(N == 1) {
            System.out.println("1");
            return;
        }
        
        for(int i = 1; i <= end; i++) {
            if(isContinuousSum(i, N))
                count++;
        }

        count++; // N 자신도 연속된 자연수의 합
        System.out.println(count);
    }

    // i부터 내림차순으로 더해서 N 넘기면 false 같으면 true
    public static boolean isContinuousSum(int x, int N) {
        int sum = 0;
        
        for(int i = x; i >= 1; i--) {
            sum += i;
            
            if(sum == N) {
                return true;
            } 
            else if(sum > N) {
                return false;
            }
        }
        
        return false;
    }
}