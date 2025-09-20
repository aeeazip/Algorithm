import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);

        result = new ArrayList<>();
        make(0, n, "", 0);

        Collections.sort(result);

        if(result.size() < k) {
            System.out.print("-1");
            return;
        }

        System.out.print(result.get(k - 1));
    }

    public static void make(int now, int n, String str, int sum) {
        if(sum == n) {
            result.add(str.substring(0, str.length() - 1)); // 마지막 + 빼주기
            return;
        }

        for(int i = 1; i <= 3; i++) {
            make(i, n, str + i + "+", sum + i);
            if(sum + i >= n) return;
        }
    }

}