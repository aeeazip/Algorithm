import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        /*
            BigInteger 연산
            - 더하기 = .add
            - 빼기 = subtract
            - 곱하기 = multiply
            - 나누기 = divide
            - 나머지 = remainder
         */

        // nCm
        BigInteger bi = BigInteger.ONE;
        for(int i = 1; i <= arr[1]; i++) {
            bi = bi.multiply(BigInteger.valueOf(arr[0] - (arr[1] - i)));
            bi = bi.divide(BigInteger.valueOf(i));
        }

        System.out.print(bi);
    }
}