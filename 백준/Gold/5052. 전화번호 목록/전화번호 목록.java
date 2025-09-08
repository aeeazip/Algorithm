import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 전화번호의 수

            String[] phones = new String[n];
            for(int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                for(int k = 0; k < input.length; k++) {
                    phones[j] += input[k];
                }
            }

            bw.write(isConsistent(phones) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static String isConsistent(String[] phones) {
        // 오름차순 정렬
        Arrays.sort(phones);

        // i + 1번째 i번째 포함한다면 일관성이 없는 것
        for(int i = 0; i < phones.length - 1; i++) {
            if(phones[i + 1].contains(phones[i])) return "NO";
        }

        return "YES";
    }
}