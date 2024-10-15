import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int count = 0;
        int[] num = new int[N];

        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(num); // 정렬
        for(int i = 0; i < N; i++) { 
            /*
                2 pointer

                - N개의 수들은 정수 (음의 정수, 0, 양의 정수 모두 포함)
                - 어떤수 = 다른수 + 다른수 (자기 자신 제외)
            */
            
            int start = (i == 0) ? 1 : 0;
            int end = (i == N - 1) ? N - 2 : N - 1;

            while(start != end && (start < N && end > -1)) {
                int sum = num[start] + num[end];
                
                if(sum == num[i]) {
                    //System.out.println(num[start] + " + " + num[end] + " = " + sum);
                    count++;
                    break;
                }

                if(sum < num[i]) {
                    // start++;
                    start = start + 1 == i ? start + 2 : start + 1;
                } else {
                    // end--;
                    end = end - 1 == i ? end - 2 : end - 1;
                }
            }
        }  

        System.out.print(count);
    }
}