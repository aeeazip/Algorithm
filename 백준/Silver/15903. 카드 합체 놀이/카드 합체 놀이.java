import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        long[] cards = new long[input2.length];
        for(int i=0; i<input2.length; i++) {
            cards[i] = Integer.parseInt(input2[i]);
        }
        
        // m번 반복
        for(int i=0; i<m; i++) {
            Arrays.sort(cards); // 오름차순 정렬
            long sum = cards[0] + cards[1];
            cards[0] = sum;
            cards[1] = sum;
        }

        // 카드 n개의 값의 총합
        long sum = 0;
        for(int i=0; i<n; i++) {
            sum += cards[i];
        }

        System.out.println(sum);
    }
}