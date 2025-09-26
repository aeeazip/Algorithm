import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//10
//2
//0 1
public class Main {
    public static boolean[] impossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 이동하려는 채널
        int M = Integer.parseInt(br.readLine()); // 고장난 버튼 개수

        impossible = new boolean[10]; // 누를 수 없는 번호 목록
        String[] info = M != 0 ? br.readLine().split(" ") : null;
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(info[i]);
            impossible[num] = true;
        }

        // + / -로만 채널 이동 가능
        int min = Math.abs(100 - N);
        if(M == 10 || N == 100) {
            System.out.print(min);
            return;
        }

        for(int i = 0; i < 1000001; i++) {
            String[] str = String.valueOf(i).split("");
            boolean result = isPossible(str);
            if(!result) continue;
            int count = Math.abs(i - N) + str.length;
            min = Math.min(min, count);
        }

        System.out.print(min);
    }

    public static boolean isPossible(String[] str) {
        for(int i = 0; i < str.length; i++) {
            int num = Integer.parseInt(str[i]);
            if(impossible[num]) return false;
        }
        return true;
    }
}