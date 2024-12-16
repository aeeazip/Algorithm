import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int i = 0;
        int count = 0;

        while(count != N) {
            int x = N - count - 3 >= 0 ? 3 : 1;
            //System.out.println(x);
            count += x;
            i++;
        }

        String winner = (i - 1) % 2 == 0 ? "SK" : "CY";
        System.out.print(winner);
    }
}