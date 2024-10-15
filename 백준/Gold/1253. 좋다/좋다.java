import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        /*
            2 pointer

            - N개의 수들은 정수 (음의 정수, 0, 양의 정수 모두 포함)
            - 어떤수 = 다른수 + 다른수 (자기 자신 제외)
        */
        
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
            int start = (i == 0) ? 1 : 0; // 처음일 때 자기 자신 제외
            int end = (i == N - 1) ? N - 2 : N - 1; // 끝일 때 자기 자신 제외

            while(start != end && (start < N && end > -1)) {
                int sum = num[start] + num[end];
                
                if(sum == num[i]) {
                    count++;
                    break;
                }

                if(sum < num[i]) {
                    // start++;
                    start = start + 1 == i ? start + 2 : start + 1; // 자기 자신일 때 하나 건너뜀
                } else {
                    // end--;
                    end = end - 1 == i ? end - 2 : end - 1; // 자기 자신일 때 하나 건너뜀
                }
            }
        }  

        System.out.print(count);
    }
}