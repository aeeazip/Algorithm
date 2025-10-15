import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int count = calc(arr);
        System.out.print(count);
    }

    public static int calc(int[] arr) {
        int count = 0;

        while(!isAllZero(arr)) {
            boolean flag = false;

            for(int i = 0; i < arr.length; i++) {
                if(arr[i] % 2 != 0) {
                    arr[i]--;
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                arr = Arrays.stream(arr)
                        .map(n -> n / 2)
                        .toArray();
            }

            count++;
        }

        return count;
    }

    public static boolean isAllZero(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) return false;
        }
        return true;
    }
}