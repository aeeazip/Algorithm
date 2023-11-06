import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        String[] croatia = {"c=", "c-", "d-", "lj", "nj", "s=", "z=", "dz="};
        int count = 0;

        for (int i = 0; i < input.length; i++) {
            // IndexOutOfBoundException 방지를 위해 삼항 연산자 사용
            String alpha = i + 1 < input.length ? input[i] + input[i + 1] : input[i];

            /*
                isAlpha = 1 -> 한 자리 문자열로 만들어진 크로아티아 알파벳 (a, b, c ...)
                isAlpha = 2 -> 두 자리의 문자열로 만들어진 크로아티아 알파벳 (c=, c-, d-, lj, nj, s=, z=)
                isAlpha = 3 -> 세 자리의 문자열로 만들어진 크로아티아 알파벳 (dz=)
             */
            int isAlpha = 1;
            for (int j = 0; j < croatia.length - 1; j++) {  // croatia[6]까지만 검사
                if (alpha.equals(croatia[j])) { // 일치하면 두 자리의 문자열로 만들어진 크로아티아 알파벳
                    isAlpha = 2;
                    break;
                }
            }

            // 반복문 종료 후 세 자리의 문자열로 만들어진 크로아티아 알파벳인지 검사
            if (i <= input.length - 3 && (alpha + input[i + 2]).equals(croatia[7]))
                isAlpha = 3;

            if (isAlpha == 2)
                ++i;
            else if (isAlpha == 3)
                i += 2;

            count++;
        }

        System.out.println(count);
    }
}