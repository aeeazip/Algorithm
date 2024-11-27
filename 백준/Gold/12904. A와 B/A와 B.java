import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        while(S.length() != T.length()) {
            char last = T.charAt(T.length() -1);

            T = T.substring(0, T.length() - 1); // 마지막 문자 삭제

            if(Objects.equals(last, 'B')) {
               // 문자열 뒤집기
               T = new StringBuilder(T).reverse().toString();
            }
        }

        // S와 T의 문자열 길이가 같을 때 비교
        if(Objects.equals(S, T)) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
    }
}