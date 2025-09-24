import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] S = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] D = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        for(int i = 0; i < info[1]; i++) {
            int[] temp = new int[S.length];

            for(int j = 0; j < D.length; j++) {
                temp[D[j] - 1] = S[j];
            }

            S = temp.clone();
        }

        for(Integer i : S) {
            System.out.print(i + " ");
        }
    }
}