import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        String L = input[0];
        String R = input[1];
        int count = 0; // L과 R의 자릿수가 다른 경우 정답은 항상 0 (ex. 1, 10)

        // L과 R의 자릿수가 같을 때
        if(L.length() != R.length())
            System.out.println(count);
        else {
            // 몇 자리까지 같은지 계산 -> 같은 자리수에 8 개수 + 나머지 자리수는 무조건 0
            for(int i = 0; i < L.length(); i++) {
                if(L.charAt(i) == R.charAt(i) && L.charAt(i) == '8')
                    count++;
                else if(L.charAt(i) == R.charAt(i))
                    continue;
                else
                    break;
            }

            System.out.println(count);
        }
    }
}
