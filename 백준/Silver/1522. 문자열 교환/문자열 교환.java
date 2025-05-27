import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 1. a의 개수를 센다
        long aCount = Arrays.stream(str.split(""))
                .filter(s -> s.equals("a"))
                .count();

        // 2. 첫 윈도우에서 b의 개수를 센다.
        int bCount = 0;
        for(int i = 0; i < aCount; i++) {
            if(str.charAt(i) == 'b') bCount++;
        }

        int min = bCount;
        String newStr = str + str; // 문자열이 원형 -> 슬라이딩 윈도우 적용을 위해 str + str

        for(int i = 1; i < str.length(); i++) {
            if(newStr.charAt(i - 1) == 'b') bCount--;
            if(newStr.charAt(i + (int) aCount -1) == 'b') bCount++;
            
            min = Math.min(min, bCount);
        }

        System.out.print(min);

    }
}