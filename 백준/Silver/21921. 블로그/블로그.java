import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        int[] visits = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        
        int lastSum = 0;
        
        for(int i = 0; i < X; i++) {
            lastSum += visits[i];
        }

        int max = lastSum;
        int period = 1;
        
        for(int i = X; i < N; i++) {
            int sum = lastSum + visits[i] - visits[i - X];
            lastSum = sum;

            if(sum == max) {
                period++;
            }

            if(sum > max) {
                max = sum;
                period = 1;
            }
        }

        if(max == 0) {
            System.out.print("SAD");
        } else {
            System.out.print(max + "\n" + period);
        }
    }
}