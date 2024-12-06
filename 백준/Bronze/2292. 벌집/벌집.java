import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int MAX = 1000000000;

        if(N == 1) {
            System.out.println(N);
            return;
        }
        
        for(int i = 1; i <= MAX; i++) {
            int result = i * (2 * 6 + (i - 1) * 6) / 2;
            if(result + 1 >= N) {
                System.out.print(i + 1);
                break;
            }
        }
    }
}