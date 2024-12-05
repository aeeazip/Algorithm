import java.io.*;
import java.util.*;

//    1
//    abcddadca
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] word = br.readLine().split("");
            sb.append(isPalindrome(word) + "\n");
        }

        System.out.print(sb);
        br.close();
    }

    public static int isPalindrome(String[] word) {
        // 회문 : 0, 유사 회문 : 1, 둘 다 아니면 2
        int start = 0;
        int end = word.length - 1;
        int diffStart = start;
        int diffEnd = end;
        int count = 0;

        while(start <= end) {
            if(word[start].equals(word[end])) {
                start++;
                end--;
                continue;
            }

            count++; // 다른 문자가 나옴

            if(count == 1) { // 처음으로 다른 문자가 나오면
                diffStart = start;
                diffEnd = end;
                start++; // start 제외
            } else if(count == 2) { // 두 번째로 다른 문자가 나오면
                // 처음으로 다른 문자가 나온 시점으로 돌아가서 end만 감소
                start = diffStart;
                end = diffEnd - 1;
            } else if(count == 3) {
                return 2; // 회문도 유사 회문도 아님
            }
        }

        if(count == 0)
            return 0;  // 회문

        return 1; // 유사 회문
    }
}