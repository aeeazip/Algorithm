import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int min = Math.abs(arr[0] + arr[N - 1]);
        int lastLeft = arr[left];
        int lastRight = arr[right];

//        while(left <= right) {
//            int mid = (left + right) / 2;
//            int sum = arr[left] + arr[right];
//
//            if(Math.min(Math.abs(sum), min) == sum) {
//                min = Math.abs(sum);
//                lastLeft = left;
//                lastRight = right;
//            }
//
//            System.out.println(arr[left] + " 와 " + arr[right] + " : min = " + min);
//            if(sum > 0) {
//                right = mid - 1;
//            } else if(sum < 0){
//                left = mid + 1;
//            } else {
//                break;
//            }
//        }

        while(left < right) {
            int sum = arr[left] + arr[right];

            if(Math.min(Math.abs(sum), min) == Math.abs(sum)) {
                min = Math.abs(sum);
                lastLeft = arr[left];
                lastRight = arr[right];

            }

            //System.out.println(arr[left] + " 와 " + arr[right] + " : min = " + min);
            if(sum > 0) {
                right--;
            } else if(sum < 0){
                left++;
            } else {
                break;
            }
        }

        System.out.print(lastLeft + " " + lastRight);
    }
}