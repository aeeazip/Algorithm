import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 
        int M = Integer.parseInt(br.readLine());

        int len = 3 + (N - 1) * 2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            String s = i % 2 == 0 ? "I" : "O";
            sb.append(s);
        }

        // 첫 번째 윈도우 계산
        int count = 0;
        String input = br.readLine();
        for(int i = 0; i <= input.length() - len; i++) {
            String str = input.substring(i, i + len);
            
            if(str.contentEquals(sb))
                count++;
        }

        System.out.print(count);
    }
}